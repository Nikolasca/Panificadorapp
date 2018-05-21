<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PANIFICADORAPP</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
    <header>
        <img src="img/logo.jpeg" alt="Logo panificadorapp">
    </header>
        <div class="formulario">
            <h1>Registrar producto</h1>
            <form action="productoController" id="iniciar" method="post" enctype="multipart/form-data">
                <input type="text" name="nombre" placeholder="Nombre">
                <input type="text" name="preciomi" placeholder="precio Minorista">
                <input type="text" name="precioma" placeholder="precio Mayorista">
                <input type="text" name="marca" placeholder="Marca">
                <input type="file" name="imagen" >
                <input type="submit">
            </form>
        </div>
    </div>
</body>
</html>
