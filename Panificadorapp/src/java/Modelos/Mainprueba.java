/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Nikolas
 */
public class Mainprueba {
public static void main (String[] args){

  Conexion con = new Conexion();
            Connection cn = con.conectar();
            try{
             ResultSet rs = con.ObtenerTodo("nombreempleado");
             String[] pass = new String[2];
              while (rs.next()) {
               pass[0] = rs.getString(1);

            }
             System.out.print(pass[0]);
} 
            catch (Throwable e) {
            System.out.print(e);
}
}
}       
   

