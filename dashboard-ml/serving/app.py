from flask import Flask, request, jsonify
import torch
import numpy as np
import pandas as pd
import utils
from ts_transformer import TSTransformerEncoderClassiregressor
from data import Normalizer
import pickle

app = Flask(__name__)

CHECKPOINT = r"C:/Users/wshiy/Desktop/USDY/COMP5703/mvts_transformer-master/experiments/MyPA_fromScratch_Regression_2025-08-27_17-46-56_OEO/checkpoints/model_best.pth"     # 你的ckpt路径
CSV_PATH   = r"C:/Users/wshiy/Desktop/USDY/COMP5703/data/CS79_1/PA_synthetic/SYNTH_000410.csv"  # 这次要预测的那份CSV

MAX_SEQ_LEN = 222          # 训练时用的序列对齐长度
CSV_HAS_HEADER = True     # 训练数据无表头就 False；有表头就 True
FEATURE_COLS = [2,3,4,5,6,7]   # 0-based 索引：示例=第3~8列
ADD_TIME_INDEX = True      # 训练时是否把 t 当作特征一起喂给模型
PAD_VALUE = 0.0

# ======= 读CSV =======
df = pd.read_csv(CSV_PATH, header=0 if CSV_HAS_HEADER else None)

with open(r"C:/Users/wshiy/Desktop/USDY/COMP5703/mvts_transformer-master/experiments/MyPA_fromScratch_Regression_2025-08-27_17-46-56_OEO/normalization.pickle", "rb") as f:
    norm_dict = pickle.load(f)

# 2. 用里面的参数初始化 Normalizer
normalizer = Normalizer(norm_dict["norm_type"],
                        mean=norm_dict.get("mean"),
                        std=norm_dict.get("std"),
                        min_val=norm_dict.get("min_val"),
                        max_val=norm_dict.get("max_val"))

# ======= 构建模型 & 载入权重 =======
device = "cuda" if torch.cuda.is_available() else "cpu"
model = TSTransformerEncoderClassiregressor(6, 222, 64, 8, 3, 256, 1, 0.1, 'fixed', 'gelu', 'BatchNorm', False)
model = utils.load_model(model, CHECKPOINT)
model.eval()

@app.route("/predict", methods=["POST"])
def predict():
    file = request.files['file']   # 前端传CSV
    df = pd.read_csv(file)
    feat = df.iloc[:, FEATURE_COLS].copy()
    feat.columns = ["f1", "f2", "f3", "f4", "f5", "f6"]
    feat = normalizer.normalize(feat)
    T = len(feat)
    L = MAX_SEQ_LEN
    if T >= L:
        feat = ( feat.iloc[:L, :]).reset_index(drop=True)
    else:
        pad_rows = L - T
        pad_df = pd.DataFrame(PAD_VALUE, index=range(pad_rows), columns=feat.columns)
        feat = (pd.concat([feat, pad_df], axis=0, ignore_index=True))
        
    valid_len = min(T, L)
    pad_len = L - valid_len
    padding_mask = torch.ones(L, dtype=torch.bool)
    if pad_len > 0:
        padding_mask[-pad_len:] = False
    padding_mask = padding_mask.unsqueeze(0)
    
    x = torch.from_numpy(feat.values.astype(np.float32)).unsqueeze(0)

    with torch.no_grad():
        y = model(x.to(device), padding_masks=padding_mask.to(device))
        if isinstance(y, (tuple, list)):
            y = y[0]
        bmi = float(y.reshape(-1)[0])

    return jsonify({"bmi": bmi})
