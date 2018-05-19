<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/registro.css">
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
            <p>${message}</p>
            <div formulario>
                <form action = "registroempleado" method="post">
                    <div class="campo">
                        <label for="nombreempresa">Nombre</label>
                        <input class="campos" name="nombre" />
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Teléfono</label>
                        <input class="campos" name="telefono"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Email</label>
                        <input class="campos" name="email"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">cc</label>
                        <input class="campos" name="cc"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">username</label>
                        <input class="campos" name="username"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Password</label>
                        <input class="campos" name="password"/>
                    </div>
                    <input id="boton1" type="submit" value="Sign In"/>
                </form>  
            </div>
        </div>
    </body>
</html>
