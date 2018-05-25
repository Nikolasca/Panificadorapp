<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://file.myfontastic.com/K8ZRXnffeDcYDqYZdgCNRG/icons.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="css/graficas.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="img/logo.jpeg" alt="Logo panificadorapp">
            </div>
            <div>
                <nav class="nav_principal">
                    <ul>
                        <li><a href="empleado.jsp" class="pan-chart-bar">Registrar producto</a></li>
                        <li><a href="admin?action=crear">Catalogo</a></li>
                        <li><a href="#">Venta</a></li>
                        <li><a href="#">Perfíl</a></li>
                    </ul>

                </nav>
            </div>
        </header>
        <div class="principal">
            <div class="general">
                <h1 class="pan-chart-bar">Estadísticas Generales</h1>
                <div class="general-item-cuadro">
                    <div class="general-item">
                        <div>
                            <canvas id="chart1" width="400" height="400"></canvas>
                        </div>   

                        <script>





                            var nombre = [];
                            var valor = [];
                            var color = [];
                            var temp;
                            <c:forEach items="${ventas}" var="venta" varStatus="status">

                            nombre.push("${venta.nombre}");
                            valor.push(${venta.valor});
                            </c:forEach>

                            console.log(nombre);
                            function numeroRandom(min, max) {
                                return Math.round(Math.random() * (max - min) + min);
                            }
                            function colorRandom(min, max) {
                                var c1 = numeroRandom(min, max);
                                var c2 = numeroRandom(min, max);
                                var c3 = numeroRandom(min, max);
                                var color = ["rgba(" + c1, c2, c3, 0.2 + ")"].join(',');
                                return color;
                            }
                            <c:forEach items="${ventas}" var="venta" varStatus="status">
                            color.push(colorRandom(0, 255));
                            console.log(colorRandom(0, 255));
                            </c:forEach>
                            console.log(color);


                            var ctx = document.getElementById("chart1").getContext('2d');
                            var myChart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: nombre,
                                    datasets: [{
                                            label: 'Precio',
                                            data: valor,
                                            backgroundColor: color,
                                            borderColor: color,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>
                    </div>
                    <div class="general-item">
                        <div>
                            <canvas id="chart2" width="400" height="400"></canvas>
                        </div>   

                        <script>





                            var nombre = [];
                            var valor = [];
                            var color = [];
                            var temp;
                            <c:forEach items="${productos}" var="produ" varStatus="status">

                            nombre.push("${produ.nombre}");
                            valor.push(${produ.valor});
                            </c:forEach>

                            console.log(nombre);
                            function numeroRandom(min, max) {
                                return Math.round(Math.random() * (max - min) + min);
                            }
                            function colorRandom(min, max) {
                                var c1 = numeroRandom(min, max);
                                var c2 = numeroRandom(min, max);
                                var c3 = numeroRandom(min, max);
                                var color = ["rgba(" + c1, c2, c3, 0.2 + ")"].join(',');
                                return color;
                            }
                            <c:forEach items="${productos}" var="produ" varStatus="status">
                            color.push(colorRandom(0, 255));
                            console.log(colorRandom(0, 255));
                            </c:forEach>
                            console.log(color);


                            var ctx = document.getElementById("chart2").getContext('2d');
                            var myChart = new Chart(ctx, {
                                type: 'pie',
                                data: {
                                    labels: nombre,
                                    datasets: [{
                                            label: nombre,
                                            data: valor,
                                            backgroundColor: color,
                                            borderColor: color,
                                            borderWidth: 1
                                        }]
                                },
                                options: {

                                }
                            });
                        </script>
                    </div>
                    <div class="general-item">
                        <div>
                            <canvas id="chart3" width="400" height="400"></canvas>
                        </div>   

                        <script>





                            var nombre = [];
                            var valor = [];
                            var color = [];
                            var temp;
                            <c:forEach items="${datos}" var="dato" varStatus="status">

                            nombre.push("${dato.nombre}");
                            valor.push(${dato.valor});
                            </c:forEach>

                            console.log(valor);
                            function numeroRandom(min, max) {
                                return Math.round(Math.random() * (max - min) + min);
                            }
                            function colorRandom(min, max) {
                                var c1 = numeroRandom(min, max);
                                var c2 = numeroRandom(min, max);
                                var c3 = numeroRandom(min, max);
                                var color = ["rgba(" + c1, c2, c3, 0.2 + ")"].join(',');
                                return color;
                            }
                            <c:forEach items="${datos}" var="produ" varStatus="status">
                            color.push(colorRandom(0, 255));
                            console.log(colorRandom(0, 255));
                            </c:forEach>
                            console.log(color);


                            var ctx = document.getElementById("chart3").getContext('2d');
                            new Chart(ctx, {
                                type: 'line',
                                data: [10,20,30]],
                                options: {
                                    elements: {
                                        line: {
                                            tension: 0, // disables bezier curves
                                        }
                                    }
                                }
                            });

                        </script>
                    </div>
                    <div class="general-item">
                        <div>
                            <canvas id="chart4" width="400" height="400"></canvas>
                        </div>   

                        <script>





                            var nombre = [];
                            var precio = [];
                            var color = [];
                            var temp;
                            <c:forEach items="${productos}" var="produ" varStatus="status">

                            nombre.push("${produ.nombre}");
                            precio.push(${produ.valor});
                            </c:forEach>

                            console.log(nombre);
                            function numeroRandom(min, max) {
                                return Math.round(Math.random() * (max - min) + min);
                            }
                            function colorRandom(min, max) {
                                var c1 = numeroRandom(min, max);
                                var c2 = numeroRandom(min, max);
                                var c3 = numeroRandom(min, max);
                                var color = ["rgba(" + c1, c2, c3, 0.2 + ")"].join(',');
                                return color;
                            }
                            <c:forEach items="${productos}" var="produ" varStatus="status">
                            color.push(colorRandom(0, 255));
                            console.log(colorRandom(0, 255));
                            </c:forEach>
                            console.log(color);


                            var ctx = document.getElementById("chart4").getContext('2d');
                            var myChart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: nombre,
                                    datasets: [{
                                            label: 'Precio',
                                            data: precio,
                                            backgroundColor: color,
                                            borderColor: color,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>
                    </div>
                </div>

            </div>
            <div class="especifico">
                <h1>Estadísticas Especificas</h1>
                <div class="especifico-cuadro">
                    <div class="especifico-item">
                        <p>Mejor vendedor:${mejor}</p>
                    </div>
                    <div class="especifico-item">
                        <p>Mejor vendedor:${mejor}</p>
                    </div>
                    <div class="especifico-item">
                        <p>Mejor vendedor:${mejor}</p>
                    </div>
                    <div class="especifico-item">
                        <p>Mejor vendedor:${mejor}</p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
