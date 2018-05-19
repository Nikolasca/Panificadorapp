<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>PANIFICADORAPP</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="css/catalogo.css">
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="img/logo.jpeg" alt="Logo panificadorapp">
            </div>
            <div>
                <nav class="nav_principal">
                    <ul>
                        <li><a href="empleado.jsp">Registrar producto</a></li>
                        <li><a href="#">Catalogo</a></li>
                        <li><a href="#">Venta</a></li>
                        <li><a href="#">Perfíl</a></li>
                    </ul>

                </nav>
            </div>
        </header>
        <div class="principal">
            <h1>Catalogo</h1>
            <div class="tabla">
                <c:forEach items="${productos}" var="producto" varStatus="status">
                <div class="producto">
                    <div class="producto_img">
                        <img src="img/lafina.png">
                    </div>
                    <div class="producto_info">
                        <p><span${producto.nombreproducto}</p>  
                         <p>${producto.idproducto}</p>
                        <p>${producto.nmarca}</p>
                     
                        
                    </div>
                    
                </div>
            </c:forEach>
            </div>
        </div>
    </body>
</html>