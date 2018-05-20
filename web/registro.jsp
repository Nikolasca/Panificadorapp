<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://file.myfontastic.com/B8bxDJcDnx8MCD8qdH35BD/icons.css" rel="stylesheet">
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
            
            <p class="message">${message}</p>
            <div class="formulario">
                <h1><span class="icon-user"></span>Registrate</h1>
                <form action = "registroempleado" method="post" class="form">
                    <div class="campo">
                        <label for="nombreempresa">Nombre</label>
                        <input type="text" class="campos" name="nombre" required="" />
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Teléfono</label>
                        <input type="text" class="campos" name="telefono" required=""/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Email</label>
                        <input type="email" class="campos" name="email" required=""/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">cc</label>
                        <input type="text" class="campos" name="cc" required=""/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">username</label>
                        <input type="text" class="campos" name="username" required=""/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Password</label>
                        <input type="password" class="campos" name="password" required=""/>
                    </div>
                    <input id="boton1" type="submit" class="btn" value="Registrarse"/>
                </form>  
            </div>
        </div>
    </body>
</html>
