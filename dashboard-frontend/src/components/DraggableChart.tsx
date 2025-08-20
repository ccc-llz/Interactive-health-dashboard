import {
    Chart,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    LineController,
    Title,
    Tooltip,
    Legend,
    Filler,
    type ChartItem
} from 'chart.js';
import 'chartjs-plugin-dragdata';
import { useState, useEffect, useRef, type CanvasHTMLAttributes } from 'react';

const DraggableChart = ({
    initialData,
    xAxisLabel,
    yAxisLabel,
    datasetLabel,
    title,
    onDragEnd,
    ...props
}) => {
    // 注册 Chart.js 组件
    Chart.register(
        CategoryScale,
        LinearScale,
        PointElement,
        LineController,
        LineElement,
        Title,
        Tooltip,
        Legend,
        Filler
    );

    const canvasRef = useRef<ChartItem>(null);
    const chartRef = useRef<Chart>(null);

    const [yAxisRange, setYAxisRange] = useState({ min: 0, max: 100 });
    const [dragIndex, setDragIndex] = useState(-1);
    const [showTooltipOnDrag, setShowTooltipOnDrag] = useState(true);
    const [tension, setTension] = useState(0.4);
    const [chartData, setChartData] = useState(initialData);

    const dragOptions = { dragX: false, dragY: true };

    const getChartConfig = () => {
        if (!canvasRef.current) return null;

        const context = canvasRef.current.getContext('2d');
        if (!context) return null;

        const gradient = context.createLinearGradient(0, 0, 0, 400);
        gradient.addColorStop(0, 'rgba(75, 192, 192, 0.5)');
        gradient.addColorStop(1, 'rgba(75, 192, 192, 0.2)');

        return {
            type: 'line',
            data: {
                labels: chartData.map((_, index) => `Point ${index + 1}`),
                datasets: [{
                    label: datasetLabel,
                    data: chartData,
                    backgroundColor: gradient,
                    fill: true,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    tension: tension,
                    pointRadius: 5,
                    pointHoverRadius: 7
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: true,
                plugins: {
                    title: {
                        display: !!title,
                        text: title || ''
                    },
                    legend: {
                        display: true,
                        onClick: (e) => { e.stopPropagation(); },
                    },
                    tooltip: {
                        enabled: true
                    },
                    dragData: {
                        round: 0,
                        showTooltip: showTooltipOnDrag,
                        dragX: dragOptions.dragX,
                        dragY: dragOptions.dragY,
                        onDragStart: (e, datasetIndex, index) => {
                            // console.log('Drag Start:', { datasetIndex, index });
                            // setDragIndex(index);
                        },
                        onDrag: (e, datasetIndex, index, value) => {
                            // console.log('Dragging:', { datasetIndex, index, value });
                            // // 处理可能的 null 值
                            // const numericValue = value != null ? Number(value) : 0;
                            // setChartData(prev => {
                            //     const newData = [...prev];
                            //     newData[index] = Math.max(yAxisRange.min, Math.min(yAxisRange.max, numericValue));
                            //     return newData;
                            // });
                        },
                        onDragEnd: (e, datasetIndex, index, value) => {
                            // console.log('Drag End:', { index, value });
                            // setDragIndex(-1);

                            const numericValue = value != null ? Number(value) : 0;

                            if (onDragEnd) {
                                onDragEnd({
                                    index: index,
                                    value: numericValue,
                                    fulldata: [...chartData]
                                });
                            }
                        }
                    }
                },
                scales: {
                    x: {
                        type: 'category',
                        title: {
                            display: true,
                            text: xAxisLabel
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: yAxisLabel
                        },
                        min: yAxisRange.min,
                        max: yAxisRange.max,
                    }
                },
                interaction: {
                    mode: 'index',
                    intersect: false
                },
                elements: {
                    point: {
                        hoverRadius: 7
                    }
                }
            }
        };
    };

    const createChart = () => {
        if (canvasRef.current && !chartRef.current) {
            // 计算 Y 轴范围
            const maxValue = Math.max(...chartData);
            const minValue = Math.min(...chartData);
            setYAxisRange({
                min: Math.min(minValue, 0),
                max: Math.round(maxValue / 10) * 10 + 10
            });

            const config = getChartConfig();
            if (config) {
                chartRef.current = new Chart(canvasRef.current, config);
            }
        }
    };

    // const updateChart = () => {
    //     if (chartRef.current) {
    //         chartRef.current.data.datasets[0].data = chartData;
    //         chartRef.current.update('none');
    //     }
    // };

    // 初始化图表
    useEffect(() => {
        createChart();

        return () => {
            if (chartRef.current) {
                chartRef.current.destroy();
                chartRef.current = null;
            }
        };
    }, []);

    // // 当数据变化时更新图表
    // useEffect(() => {
    //     updateChart();
    // }, [chartData]);

    // 当初始数据变化时重置图表数据
    useEffect(() => {
        console.log('detected');
        setChartData(initialData);
        const maxValue = Math.max(...chartData);
        const minValue = Math.min(...chartData);
        setYAxisRange({
            min: Math.min(minValue, 0),
            max: Math.round(maxValue / 10) * 10 + 10
        });
        const config = getChartConfig();
        config.options.scales.y.min = Math.min(minValue, 0);
        config.options.scales.y.max = Math.round(maxValue / 10) * 10 + 10;
        if (!chartRef.current || !canvasRef.current) return; 
        
        chartRef.current.destroy();
        chartRef.current = new Chart(canvasRef.current, config);
    }, [initialData]);

    return (
        <div className="w-full flex justify-center">
            <canvas
                ref={canvasRef}
                className="max-w-200 max-h-100 aspect-auto"
            />
        </div>
    );
};

export default DraggableChart;