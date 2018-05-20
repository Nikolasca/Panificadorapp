/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Usuario;
import SQL.DbConnection;
import SQL.UsuarioDao;
import SQL.productoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicolasmoreno
 */
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
                String action = request.getParameter("action");
                
                HttpSession session =request.getSession();
                RequestDispatcher rd;
                String msg="";
                
                switch (action){
                    case "login":
                        if (session.getAttribute("usuario")==null) {
                            request.setAttribute("message", msg);
                            rd = request.getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);
                        }else{
                            rd=request.getRequestDispatcher("/home.jsp");
                            rd.forward(request, response);
                        }
                        break;
                    case "logout":
                        session.invalidate();
                        response.sendRedirect(request.getContextPath()+ "/home");
                        break;
                    case "crear":
                        if (session.getAttribute("usuario") == null) {
                            msg="Acceso denegado";
                            request.setAttribute("message",msg );
                            rd = request.getRequestDispatcher("/index.jsp");
                            rd.forward(request, response);
                        }else{
                            rd=request.getRequestDispatcher("/empleado.jsp");
                            rd.forward(request, response);
                        }
                        break;    
                    case "eliminar":
                        if (session.getAttribute("usuario") == null) {
                            msg="Acceso denegado";
                            request.setAttribute("message",msg );
                            rd = request.getRequestDispatcher("/index.jsp");
                            rd.forward(request, response);
                        }else{
                            this.eliminarProducto(request,response);
                        }
                        break;
                }
        }
    
    
    
    
    
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userParam=request.getParameter("username");
        String passParam=request.getParameter("password");
        String msg="";
        
        HttpSession session =request.getSession();
        
        DbConnection conn = new DbConnection();
        UsuarioDao ud = new UsuarioDao(conn);
        
        
        Usuario u = ud.login(userParam, passParam);
        conn.disconnect();
        
        RequestDispatcher rd;
        if (u.getId()>0) {
            session.setAttribute("usuario", u);
            System.out.println(u.getUsername());
            rd= request.getRequestDispatcher("/home.jsp");
            rd.forward(request, response);
        }else{
            msg="Contraseña o usuario incorrectos";
            request.setAttribute("message", msg);
            rd=request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }


    private void eliminarProducto(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int idProductoParam = Integer.parseInt(request.getParameter("idProducto"));
        System.out.println(idProductoParam);
        DbConnection conn = new DbConnection();
        productoDao pd = new productoDao(conn);
        int respuesta = pd.delete(idProductoParam);
        String msg="";
        if (respuesta==1) {
            msg="El producto fue eliminado correctamente";
        }else{
            msg="Ocurrio un error";
        }
        conn.disconnect();
        request.setAttribute("message", msg);
        RequestDispatcher rd ;
        rd=request.getRequestDispatcher("/catalogo");
        rd.forward(request, response);
    } 
}
