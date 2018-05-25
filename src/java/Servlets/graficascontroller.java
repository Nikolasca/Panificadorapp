/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Producto;
import Modelos.estadistica;
import SQL.DbConnection;
import SQL.graficaDao;
import SQL.productoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolasmoreno
 */
public class graficascontroller extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher rd;
        DbConnection conn = new DbConnection();
        productoDao pd = new productoDao(conn);
        graficaDao gd = new graficaDao(conn);
        List<estadistica> empleados = new ArrayList();
        List<estadistica> mes = new ArrayList();
        List<estadistica> productos = new ArrayList();
         String mejor = gd.getMejorVendedor();
         empleados = gd.getVentas();
         productos=gd.getproductos();
         mes=gd.ventapormes();
        System.out.print("productos cargados");
        conn.disconnect();
        request.setAttribute("mejor", mejor);
        request.setAttribute("ventas", empleados);
        request.setAttribute("productos", productos);
        request.setAttribute("datos", mes);
        
       
        rd = request.getRequestDispatcher("/graficas.jsp");
        rd.forward(request, response);
    }

  

}
