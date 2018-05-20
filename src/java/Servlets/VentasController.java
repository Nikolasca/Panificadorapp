/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikolas
 */
public class VentasController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String url;
    HttpSession session;
    ArrayList<Producto> Lista;
    Producto producto;
    PrintWriter out;
    protected void metget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
    }
    
    protected void metpost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    anadircarrito(request,response);
      // url = request.getServletPath();
      // if(url.equals("/VentasController")){
             
            
          
            
     //  }
       
        
    }
private void anadircarrito(HttpServletRequest request, HttpServletResponse response) throws IOException{
   session = request.getSession(false);
   Lista = (ArrayList<Producto>) session.getAttribute("carritocompras");
   if (Lista == null){
            Lista = new ArrayList<Producto>();
            session.setAttribute("carritocompras",Lista);
             
   } 
   producto = new Producto();
   producto.setIdproducto(Integer.parseInt(request.getParameter("id")));
   producto.setNombreProducto(request.getParameter("nombrep"));
   producto.setPreciomayorista(Integer.parseInt(request.getParameter("preciomay")));
   producto.setPreciominorista(Integer.parseInt(request.getParameter("preciomin")));
   int indice = -1;
   
   for(int i = 0;i<Lista.size();i++){
   Producto productoB = Lista.get(i);
   if(productoB.getIdproducto() == producto.getIdproducto()){
       indice=i;
       break;
   }
   }
   if(indice==-1){
          Lista.add(producto);
   } else {
   Lista.set(indice, producto);
   }
 

   
   session.setAttribute("carritocompras", Lista);
   
   out = response.getWriter();
   out.print("registrado correctamente!!"+producto);
   response.sendRedirect("Carrito.jsp");
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
        metget(request, response);
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
        metpost(request, response);
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
