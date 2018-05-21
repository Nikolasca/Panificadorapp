/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SQL.DbConnection;
import SQL.productoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.Marca;

import Modelos.Producto;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
@WebServlet("/upload")
@MultipartConfig
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
            Part filePart = request.getPart("imagen");
            String fileName =  Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            
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
            
          //  String path="/archivos/";
            String path="/Users/Nikolas/Documents/NetBeansProjects/Panificadorapp/web/USER-PICS/";
            File uploads = new File(path);
            uploads.mkdirs();
            File file = File.createTempFile("cod"+"1203"+"XX","XX"+fileName,uploads);
            
            try(InputStream input = filePart.getInputStream()){
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        
          String[] Parts = (file.getPath().split("XX"));
          //System.out.print(file.getPath());
          
          String ruta =("cod1203XX"+Parts[1]+"XX"+fileName);
          pr.setRutaimg(ruta);
         
           
         
            System.out.print(pr.getRutaimg()); 
          DbConnection conn = new DbConnection();
            productoDao pd = new productoDao(conn);
            pd.insertProducto(pr, m);
            
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
