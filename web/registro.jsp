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
            <div formulario>
                <form action = "SignUpEmpleado" method="post">
                    <div class="campo">
                        <label for="nombreempresa">Nombre de la empresa</label>
                        <input class="campos" name="nombreempresa" />
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Teléfono de la empresa</label>
                        <input class="campos" name="telefonoempresa"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Nombre de persona de contacto</label>
                        <input class="campos" name="nombrepersonacontacto"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Apellido persona de contacto</label>
                        <input class="campos" name="apellidopersonacontacto"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Teléfono persona de contacto </label>
                        <input class="campos" name="telefonopersonacontacto"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Email persona contacto</label>
                        <input class="campos" name="emailpersonacontacto"/>
                    </div>
                    <div class="campo">
                        <label for="nombreempresa">Documneto persona de contacto</label>
                        <input class="campos" name="documentopersonacontacto"/>
                    </div>
                    <input id="boton1" type="submit" value="Sign In"/>
                </form>  
            </div>
        </div>
    </body>
</html>
