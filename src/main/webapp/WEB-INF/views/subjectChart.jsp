<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>과목 차트 뿌리기</title>
</head>
<%--다른 폴더 안에 들어가면 인클루드 된 파일 경로 앞에 .을 붙여야함--%>
<%@ include file="./header.jsp" %>
<body>

<div class="page-body">
    <div class="container-fluid">
        <div class="page-header">
            <div class="row">
                <div class="col-sm-6">
                    <h3>이름</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                        <li class="breadcrumb-item">중분류</li>
                        <li class="breadcrumb-item active">소분류</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <h5>Content</h5>
                <div style="width: 500px; height: 500px;">
                    <input type="hidden" id="subNum" value="20220523SUB101">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
        </div>
        <!-- Container-fluid Ends-->
    </div>

</div>
</div>
<%@include file="./footer.jsp" %>
<script type="text/javascript">
    var subNum = $("#subNum").val();
    $(document).ready(function () {
        $.ajax({
            url: "./getSubjectChart.do",
            type: "post",
            dataType: 'json',
            data:{"sub_num":subNum},
            success: function (json) {
                console.log(json);
                var data = {
                    labels: [
                        '소통',
                        '커리큘럼',
                        '교재와 자료',
                        '실습',
                        '몰입도'
                    ],
                    datasets: [{
                        label: subNum,
                        data: [json.communicationTotal, json.curriculumTotal, json.bookTotal , json.practiceTotal, json.immersionTotal ],
                        fill: true,
                        backgroundColor: 'rgba(36, 105, 92, 0.2)',
                        borderColor: 'rgb(36, 105, 92)',
                        pointBackgroundColor: 'rgb(36, 105, 92)',
                        pointBorderColor: 'rgb(36, 105, 92)',
                        pointHoverBackgroundColor: 'rgb(36, 105, 92)',
                        pointHoverBorderColor: 'rgb(36, 105, 92)',
                        borderWidth: 1,
                        pointBorderWidth: 0
                    }]
                }
                const config = {
                    type: 'radar',
                    data: data,
                    options: {
                        elements: {
                            line: {
                                borderWidth: 2
                            }
                        },
                        plugins: {
                            legend: {
                                display: true
                            }

                        },
                        scales: {
                            r: {
                                min: 0,
                                max: 100,
                                pointLabels: {
                                    display: true,
                                    font: {
                                        size: 12
                                    }
                                }
                            }
                        },
                        ticks: {
                            maxTicksLimit: 5
                        }, layout: {
                            padding: {
                                left: 40,
                                right: 40,
                                top: 40,
                                bottom: 40
                            }
                        }
                    }
                }
                const myChart = new Chart(
                    document.getElementById('myChart'),
                    config
                );
            },
            error: function () {
                console.log("통신실패");
            }
        });
    });


</script>

</body>
</html>