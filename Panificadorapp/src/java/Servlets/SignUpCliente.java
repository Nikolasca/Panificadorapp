/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Cliente;
import Modelos.PersonaContacto;
import SQL.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikolas
 */
public class SignUpCliente extends HttpServlet {

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
        String NombrePC = request.getParameter("nombrepersonacontacto");
        String ApellidoPC = request.getParameter("apellidopersonacontacto");
        NombrePC = (NombrePC+" "+ApellidoPC);
        String TelefonoPC = request.getParameter("telefonopersonacontacto");
        String EmailPC = request.getParameter("emailpersonacontacto");
        String DocumentoPC = request.getParameter("documentopersonacontacto");
        String NombreEmpresa = request.getParameter("nombreempresa");
        String TelefonoEmpresa = request.getParameter("telefonoempresa");
        String prueba =(NombrePC+TelefonoPC+EmailPC+DocumentoPC+NombreEmpresa+TelefonoEmpresa);
        
        PersonaContacto PC = new PersonaContacto(NombrePC,TelefonoPC,EmailPC,DocumentoPC);
        PC.AñadirPersonaContacto(PC);
         Cliente cliente = new Cliente (NombreEmpresa,TelefonoEmpresa);
        int[] id = new int[1];
         try {
            Conexion con = new Conexion();
            Connection cn = con.conectar();

            ResultSet rs = con.ObtenerTodoUltimo("idpersonaContacto", "personacontacto");
            
            while (rs.next()) {
                id[0] = rs.getInt(1);//ID
            }
            
             } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Verifique ID y/o Contraseña");
           

        }
         cliente.setIdPersonaContacto(id[0]);
         cliente.AñadirCliente(cliente);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(PC.isEstado());
            out.println(cliente.isEstado());
            out.println(id[0]);
            out.println("</body>");
            out.println("</html>");
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
