<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PANIFICADORAPP</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
    <header>
        <a href="index.html"><img src="img/logo.jpeg" alt="Logo panificadorapp"></a>
    </header>
        <div class="formulario">
            <h1>Editar producto</h1>
            <form action="editarproducto" id="iniciar" method="POST">
                <input type="text" name="nombre" value="${producto.nombreproducto}">
                <input type="text" name="preciomi" placeholder="precio Minorista" value="${producto.preciominorista}">
                <input type="text" name="precioma" placeholder="precio Mayorista" value="${producto.preciomayorista}">
                <input type="text" name="marca" placeholder="" value="${producto.nmarca}" >  
                <input type="submit">
            </form>
        </div>
    </div>
</body>
</html>
