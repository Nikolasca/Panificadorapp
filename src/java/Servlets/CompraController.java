/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Cliente;
import Modelos.DetalleFactura;
import Modelos.Empleado;
import Modelos.Factura;
import Modelos.Producto;
import Modelos.Venta;
import SQL.CompraDao;
import SQL.DbConnection;
import SQL.productoDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikolas
 */
public class CompraController extends HttpServlet {

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
        String metodopago = request.getParameter("metodopago");
         String metodoenv = request.getParameter("metodoentrega");
       DbConnection conn = new DbConnection();
       
        CompraDao pd = new CompraDao(conn);
    int codigotipopago =    pd.getProductos("tipopago", "idtipopago", "nombretipopago", ((char)34+metodopago+(char)34));
    int codigotippenv =    pd.getProductos("tipoentrega", "idtipoentrega", "nombretipoentrega", ((char)34+metodoenv+(char)34));
      
       
       
        String obs = "Esto es un observación";
        ArrayList<Producto> comprados;
        comprados = (ArrayList<Producto>) request.getSession().getAttribute("comprados");
       Empleado e = new Empleado();
       DetalleFactura fd = new DetalleFactura();
       Factura f = new Factura();
       Venta v = new Venta();
       Cliente c = new Cliente();
       int cantidad = 0;
      for (int i = 0;i<comprados.size();i++){ 
          
           cantidad = Integer.parseInt(request.getParameter("cantidad"+comprados.get(i).getIdproducto()));
         //  System.out.print(cantidad);
          v.setIdTipoEntrega(codigotippenv);
          v.setIdTipoPago(codigotipopago);
       c.setId(5);
       e.setId(11);
      f.setPreciototal(comprados.get(i).getPreciominorista()*cantidad);
      fd.setCantidadfactura(cantidad);
      v.setObservacionVenta(obs);
      
           
            pd.insertCompra(comprados.get(i), e, fd, f, v,c);
            
      
      }
      RequestDispatcher rd;
            rd = request.getRequestDispatcher("/CompraRealizada.jsp");
            rd.forward(request, response);
        
        
       
               

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
