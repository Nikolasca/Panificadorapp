<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Log In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/home.css">
    </head>

    <body>
        <header>
            <img src="img/logo.jpeg" alt="Logo panificadorapp">
        </header>
        <div class="principal">
            <div class="info">
                <div class="filtro"></div>
            </div>
            <p>${message}</p>
            <div class="formulario">
                <h1>Registrar producto</h1>
                <form method="post" class="form" action="admin">
                    <input type="text" class="campos" name="username" placeholder="Usuario"/>
                    <input type="text" class="campos" name="password" placeholder="Contraseña"/>
                    <input type="submit" id="boton1" value="Log in" class="btn"/>
                    <a href="/check.html" class="link">¿Olvidó su contraseña?</a>
                    <a href="/Panificadorapp/signup.html" class="link">Registrarse <a/>
                </form>
            </div>
        </div>
    </body>
</html>