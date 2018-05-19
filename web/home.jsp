<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>PANIFICADORAPP</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="css/empleado.css">
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
                        <li><a href="/Panificadorapp/catalogo">Catalogo</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#">Perfíl</a></li>
                       
                    </ul>

                </nav>
            </div>
        </header>
        <div class="principal">
            <div class="perfil">
                <h1>Bienvenido ${usuario.username}</h1> 
                
                

            </div>
        </div>
    </body>
</html>
