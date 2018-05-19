/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SQL.DbConnection;
import SQL.productoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.Producto;

public class catalogoController extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        DbConnection conn = new DbConnection();
        productoDao pd = new productoDao(conn);
        List<Producto> lista = pd.getProductos();
        System.out.print("productos cargados");
       
        conn.disconnect();
        request.setAttribute("productos", lista);
        rd = request.getRequestDispatcher("/productos.jsp");
        rd.forward(request, response);
    }

}
