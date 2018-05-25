/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.Marca;
import Modelos.Producto;
import SQL.DbConnection;
import SQL.productoDao;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nicolasmoreno
 */
public class editProductController extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String nombreParam = request.getParameter("nombre");
            int precioMinParam = Integer.parseInt(request.getParameter("preciomi"));
            int precioMayParam = Integer.parseInt(request.getParameter("precioma"));
            String marcaParam = request.getParameter("marca");
            //-Part filePart = request.getPart("imagen");
            //-String fileName =  Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            
           // InputStream fileContent= filePart.getInputStream();
         //  System.out.print(fileName);
            
            
           
           // Precio p = new Precio(0);
            Marca m=new Marca(0);
            Producto pr = new Producto(0);
            pr.setNombreProducto(nombreParam);
            pr.setPreciominorista(precioMinParam);
            pr.setPreciomayorista(precioMayParam);
            m.setNombreMarca(marcaParam);
            pr.setNmarca(marcaParam);
            
     
          DbConnection conn = new DbConnection();
            productoDao pd = new productoDao(conn);
            pd.editProducto(pr, m);
            
           /*  boolean status = pd.insert(pr,m);
            
            String msg="";
            if (status) {
                msg="El producto se creo correctamente";
                System.out.println(msg);
            }else{
                msg="Ocurrio un error";
                System.out.println(msg);
            }
            conn.disconnect();*/
           String msg = "tal vez salio bien";
            RequestDispatcher rd;
            request.setAttribute("Message", msg);
            rd = request.getRequestDispatcher("/mensaje.jsp");
            rd.forward(request, response);
           
    }
}