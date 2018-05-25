<%-- 
    Document   : Carrito
    Created on : 19/05/2018, 07:25:59 PM
    Author     : Nikolas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion; %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TU CARRITO MAMALÓN</h1>
        <%  sesion = request.getSession(false);
        if(sesion.getAttribute("carritocompras")!=null){%>
        <table> <tr><th>codigo</th><th>Nombre</th><th>Cantidad</th>
                <%}<% ArrayList<Producto> Lista = new ArrayList(); %>
                <% ArrayList<Producto> Lista= (ArrayList<Producto>)sesion.getAttribute("carritocompras"); 
                    for (int i=0;i<Lista.size();i++){%>
            <tr>
                <td><%=Lista.get(i).getIdproducto()  %></td>
                <td><%=Lista.get(i).getNombreproducto()  %> </td>
                <td><%=Lista.get(i).getPreciomayorista() %></td>
                <td><input type="text" class="campos" name="cantidad" placeholder="insertecantidad"/></td>
                <td><a href="eliminarproducto?productoid=0"> ELIMINAR </a></td>
                   </tr>
                    
                    <%} %>
                  
                    
        <%}%>
        </table>
          
          
        <p> Seleccione método de pago </p>
         <select>
  <option value="efectivo">${metodo.get(0).nombretipo}</option>
  <option value="debito">${metodo.get(1).nombretipo}</option>
  <option value="credito">${metodo.get(2).nombretipo}</option>
  <option value="cheque">${metodo.get(3).nombretipo}</option>
</select>
<p> Seleccione método de Entrega</p>
 <select>
  <option value="asdasd">${metodoen.get(0).nombretipo}</option>
  <option value="dasd">${metodoen.get(1).nombretipo}</option>
  <option value="asd">${metodoen.get(2).nombretipo}</option>
  <option value="ppp">${metodoen.get(3).nombretipo}</option>
</select>

         <li><a href="home.jsp">Volver</a></li>
         <form action = "CompraController?nombrep=${producto.nombreproducto}&id=${producto.idproducto}&preciomin=${producto.preciominorista}&preciomay=${producto.preciominorista}" method="post">
                           
                        <button type="submit"> Confirmar Compra </button>
         </form>
        
    </body>
</html>
