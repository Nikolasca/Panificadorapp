<%-- 
    Document   : detalles
    Created on : 18/05/2018, 11:14:54 PM
    Author     : Nikolas
--%>

<%-- 
    Document   : detalles
    Created on : 18/05/2018, 11:14:54 PM
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <div class="producto_info">
                        <p>Nombre del producto: ${producto.nombreproducto}</p>  
                        <p>Marca: ${producto.nmarca}</p>
                        <p>Precio para mayoristas: ${producto.preciomayorista}.000  </p>
                         <p>Precio para minoristas: ${producto.preciominorista}.000</p>
                        <form action = "ProductDetail" method="get">
                           
                        <button type="submit">Comprar</button>
                        </form>
    </body>
</html>