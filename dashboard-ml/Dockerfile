FROM python:3.8-slim

# 安装 PyTorch（根据你本地训练时的版本选择 CPU 或 CUDA 版）
RUN pip install torch==2.2.2 -f https://download.pytorch.org/whl/cpu/torch_stable.html

# 安装项目运行需要的依赖
RUN pip install flask gunicorn numpy pandas scikit-learn tqdm

# 如果要 tensorboard 可视化
# RUN pip install tensorboard

# 拷贝代码
WORKDIR /app
COPY . .

# 暴露端口
EXPOSE 5000

# 启动命令
CMD ["gunicorn", "-b", "0.0.0.0:5000", "--chdir", "serving", "app:app"]