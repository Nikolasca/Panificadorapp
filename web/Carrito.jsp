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
                <% ArrayList<Producto> Lista= (ArrayList<Producto>)sesion.getAttribute("carritocompras"); 
                    for (int i=0;i<Lista.size();i++){%>
            <tr>
                <td><%=Lista.get(i).getIdproducto()  %></td>
                <td><%=Lista.get(i).getNombreproducto()  %> </td>
                <td><%=Lista.get(i).getPreciomayorista() %></td>
                <td><input type="text" class="campos" name="cantidad" placeholder="insertecantidad"/></td>
               
            </tr>
            
                    <%} %>
        <%}%>
        </table>
         <li><a href="home.jsp">Volver</a></li>
         <input type="submit" id="boton1" value="Confirmar Compra" class="btn"/>
    </body>
</html>
