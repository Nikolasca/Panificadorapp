/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nicolasmoreno
 */
public class DbConnection {
    static String bd="panificadorapp";
    static String login="root";
    static String password="root1234";
    static String url="jdbc:mysql://localhost/" + bd;
    
    Connection conn=null;

    public DbConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login,password);
            if (conn != null) {
                System.out.println("Connecting database ["+ conn+"] Ok");
            }
        }catch (SQLException e){
            System.out.println("Exception conexion: "+ e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Excepcion Driver: "+e.getMessage());
        }
        
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void disconnect(){
        System.out.println("Closing database: ["+ conn +"] OK");
        if (conn != null) {
            try{
                conn.close();
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
    
    
}
