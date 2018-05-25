<%-- 
    Document   : Carrito
    Created on : 19/05/2018, 07:25:59 PM
    Author     : Nikolas
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Producto"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Producto> comprados= new ArrayList();%>
<% HttpSession sesion; %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <%  sesion = request.getSession(false);
        if(sesion.getAttribute("carritocompras")!=null){%>
        <table> <tr><th>codigo</th><th>Nombre</th><th>Precio </th>
                
                <% ArrayList<Producto> Lista= (ArrayList<Producto>)sesion.getAttribute("carritocompras"); 
                    for (int i=0;i<Lista.size();i++){%>  
            <tr>
                <td><%=Lista.get(i).getIdproducto()  %></td>
                <td><%=Lista.get(i).getNombreproducto()  %> </td>
                <td><%=Lista.get(i).getPreciomayorista() %></td>
    <form action = "CompraController" method="post">  
                <td><input type="text" class="campos" name="cantidad<%=Lista.get(i).getIdproducto()%>" placeholder="insertecantidad<%=i%>"/></td>
                <td><a href="eliminarproducto?productoid=0"> ELIMINAR </a></td>
                   </tr>
                    
                    <%} %>
                  
                    
        <%}%>
        </table>
          
        
        <p> Seleccione método de pago </p>
         <select name="metodopago">
  <option value="Efectivo">${metodo.get(0).nombretipo}</option>
  <option value="Tarjeta Crédito">${metodo.get(1).nombretipo}</option>
  <option value="Tarjeta Débito">${metodo.get(2).nombretipo}</option>
  <option value="Cheque">${metodo.get(3).nombretipo}</option>
</select>
<p> Seleccione método de Entrega</p>
<select name="metodoentrega">
  <option value="Punto de venta">${metodoen.get(0).nombretipo}</option>
  <option value="Cliente">${metodoen.get(1).nombretipo}</option>
  <option value="Dirección Específica">${metodoen.get(2).nombretipo}</option>
  <option value="Enviado por segundo">${metodoen.get(3).nombretipo}</option>
</select>


        
        
              <% ArrayList<Producto> Lista= (ArrayList<Producto>)sesion.getAttribute("carritocompras"); %>
           <%  request.getSession().setAttribute("comprados", Lista);%>
                        <button type="submit"> Confirmar Compra </button>
         </form>
         <li><a href="home.jsp">Volver</a></li>
    </body>
</html>
