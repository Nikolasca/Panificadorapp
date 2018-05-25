/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelos.Producto;
import Modelos.Tipos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nikolas
 */
public class TipoDao {
     DbConnection conn;
     
     public TipoDao ( DbConnection conn){
          this.conn=conn;
}
      public List<Tipos> getTipoPago() {

        try {
            String sql = "select idtipopago, nombretipopago from tipopago";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tipos> list = new LinkedList<>();

            Tipos tipopago ;
            while (rs.next()) {
                tipopago = new Tipos(rs.getInt("idtipopago"),"");
                tipopago.setNombretipo(rs.getString("nombretipopago"));
                
                

                list.add(tipopago);
                System.out.println(tipopago.getNombretipo());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
      public List<Tipos> getTipoEntrega() {

        try {
            String sql = "select idtipoentrega, nombretipoentrega from tipoentrega";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tipos> list = new LinkedList<>();

            Tipos tipopago ;
            while (rs.next()) {
                tipopago = new Tipos(rs.getInt("idtipoentrega"),"");
                tipopago.setNombretipo(rs.getString("nombretipoentrega"));
                
                

                list.add(tipopago);
                System.out.println(tipopago.getNombretipo());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
}
