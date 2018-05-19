/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Usuario;
import Modelos.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SQL.Conexion;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Nikolas
 */
public class LogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion con = new Conexion();
        Connection cn = con.conectar();
        String user = request.getParameter("username");
        String passw = request.getParameter("password");
        try {
            ResultSet rs = con.ObtenerTodo("nombreempleado,telefonoempleado,emailempleado ");
            String[] pass = new String[3];

            ArrayList<Empleado> usuarios = new ArrayList<Empleado>();
            ArrayList<String> otroarray = new ArrayList<String>();
            int i = 0;
            while (rs.next()) {
                pass[0] = rs.getString("nombreempleado");
                pass[1] = rs.getString("telefonoempleado");
                pass[2] = rs.getString("emailempleado");
                Empleado empleadolog = new Empleado(pass[0], pass[1], pass[2]);
                usuarios.add(i, empleadolog);
                i++;

            }
            boolean validador = false;
            for (int e = 0; e < usuarios.size(); e++) {
                if (user.equalsIgnoreCase(usuarios.get(e).getNombre())) {
                     
                    try (PrintWriter out = response.getWriter()) {

                        RequestDispatcher rd;
                        
                        request.setAttribute("usuario", usuarios.get(e));
                        
                        
                        rd = request.getRequestDispatcher("/home.jsp");
                        
                        rd.forward(request, response);
                       
                        validador = true;
                       
                    }
                }

            }
            if (validador == false) {
                try (PrintWriter out = response.getWriter()) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LogIn</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet LogIn at " + request.getContextPath() + "</h1>");
                    out.println("no se encontró usuario");
                    out.println("</body>");
                    out.println("</html>");
                    validador = true;
                }
            }

        } catch (Throwable e) {
            try (PrintWriter out = response.getWriter()) {

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LogIn</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet LogIn at " + request.getContextPath() + "</h1>");
                out.println("Error");
                out.println(e);
                out.println("</body>");
                out.println("</html>");

            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
