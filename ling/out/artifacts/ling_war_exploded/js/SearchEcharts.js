
getProductSellDailyList();
function getProductSellDailyList() {
    // 获取该店铺商品7天销量的URL
    var listProductSellDailyUrl = '/SearchEchartsServlet';
    // 访问后台，该店铺商品7天销量的URL
    $.getJSON(listProductSellDailyUrl, function(data) {
        if (true) {
            var myChart = echarts.init(document.getElementById('chart'));
            // 生成静态的Echart信息的部分
            var option = generateStaticEchartPart();
            // 遍历销量统计列表,动态设定echarts的值

            option.series = [
                {
                    name: '搜索关键词',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '50%'],
                    data: data,
                    roseType: 'radius',
                    label: {
                        color: 'rgba(255, 255, 255, 0.3)'
                    },
                    labelLine: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    },
                    itemStyle: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    },

                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ];
            myChart.setOption(option);
        }
    });
}
/**
 * 生成静态的Echart信息的部分
 */
function generateStaticEchartPart() {
    /** echarts逻辑部分 * */
    var option = {
        backgroundColor: '#2c343c',

        title: {
            text: '搜索关键词',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },

    };
    return option;
}



