<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PV数据展示</title>
    <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
    <script src="js/echarts.min.js" type="text/javascript"></script>
</head>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: '用户PV量数据分析',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            // data: ['ChinaMap.jsp', 'deptfangwen.jsp', 'index.jsp', 'insert.jsp', 'login.jsp']
            data: []
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    // {value: 335, name: 'ChinaMap.jsp'},
                    // {value: 310, name: 'deptfangwen.jsp'},
                    // {value: 234, name: 'index.jsp'},
                    // {value: 135, name: 'insert.jsp'},
                    // {value: 1548, name: 'login.jsp'}
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
    var names = [];
    var str = [];
    $.getJSON("PvEchartsServlet").done(function (result) {
        // if(result){
        //     for (var i=0;i < result.length;i++){
        //         names.push(result[i].pV);
        //     }
        //     for(var i=0;i < result.length;i++){
        //         num.push(result[i].count);
        //     }
        // }
        if(result){
            for(var i=0;i<result.length;i++){
                names.push(result[i].pV);
                var str1=new Object();
                str1.name=result[i].name;
                str1.value=result[i].value;
                str.push(str1);
            }
            // option.series.data=str;
            // option.legend.data=names;
        };

        myChart.setOption({
            legend:{
                data:names
            },
            series: [{
                data:str
            }]
        });
        console.log(num)
    })

</script>

</body>
</html>
