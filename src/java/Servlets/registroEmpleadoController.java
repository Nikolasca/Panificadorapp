/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Empleado;
import Modelos.Marca;
import Modelos.Producto;
import Modelos.Usuario;
import SQL.DbConnection;
import SQL.UsuarioDao;
import SQL.productoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolasmoreno
 */
@WebServlet(name = "registroEmpleadoController", urlPatterns = {"/registroempleado"})
public class registroEmpleadoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreParam = request.getParameter("nombre");
        String telefonoParam = request.getParameter("telefono");
        String emailParam = request.getParameter("nombre");
        String ccParam = request.getParameter("email");
        String userParam = request.getParameter("username");
        String passParam = request.getParameter("password");
        String msg = "";

        // Precio p = new Precio(0);
        
        Usuario u = new Usuario(0);
        Empleado e = new Empleado(0);
        e.setNombre(nombreParam);
        e.setTelefono(telefonoParam);
        e.setEmail(emailParam);
        e.setCc(ccParam);
        u.setUsername(userParam);
        u.setPassword(passParam);
        //  pr.setUrl(imagenParam);

        DbConnection conn = new DbConnection();
        UsuarioDao ud = new UsuarioDao(conn);
        boolean status = ud.insert(u,e);

        if (status) {
            msg = "El usuario se creo correctamente";
            System.out.println(msg);
        } else {
            msg = "Ocurrio un error";
            System.out.println(msg);
        }
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("message", msg);
        rd = request.getRequestDispatcher("/registro.jsp");
        rd.forward(request, response);

    }

}
