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
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.Marca;

import Modelos.Producto;

/**
 *
 * @author nicolasmoreno
 */
public class productoController extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nombreParam = request.getParameter("nombre");
            int precioMinParam = Integer.parseInt(request.getParameter("preciomi"));
            int precioMayParam = Integer.parseInt(request.getParameter("precioma"));
            String marcaParam = request.getParameter("marca");
            String imagenParam = request.getParameter("imagen");
            
           
           // Precio p = new Precio(0);
            Marca m=new Marca(0);
            Producto pr = new Producto(0);
            pr.setNombreProducto(nombreParam);
            pr.setPreciominorista(precioMinParam);
            pr.setPreciomayorista(precioMayParam);
            m.setNombreMarca(marcaParam);
            pr.setNmarca(marcaParam);
          //  pr.setUrl(imagenParam);
            
            DbConnection conn = new DbConnection();
            productoDao pd = new productoDao(conn);
            boolean status = pd.insert(pr,m);
            
            String msg="";
            if (status) {
                msg="El producto se creo correctamente";
                System.out.println(msg);
            }else{
                msg="Ocurrio un error";
                System.out.println(msg);
            }
            conn.disconnect();
            RequestDispatcher rd;
            request.setAttribute("Message", msg);
            rd = request.getRequestDispatcher("/mensaje.jsp");
            rd.forward(request, response);
                    
    }


}
