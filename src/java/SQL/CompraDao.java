/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelos.Cliente;
import Modelos.DetalleFactura;
import Modelos.Empleado;
import Modelos.Factura;
import Modelos.Producto;
import Modelos.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nikolas
 */
public class CompraDao {
     DbConnection conn;
      
     
     public CompraDao ( DbConnection conn){
          this.conn=conn;
}
     public boolean insertCompra(Producto P,Empleado e,DetalleFactura FD,Factura F, Venta V,Cliente C) {
        String sqlm = "insert into factura (cliente_idcliente,fecha_factura,preciototal) Values(?,(SELECT CURDATE()),?)";
        String sqle = "insert into facturadetalle (factura_idfactura,producto_idproducto,producto_cantidad) Values((select idfactura from factura ORDER BY idfactura  DESC LIMIT 1),?,?)";
       String sqlv = "insert into venta (observacion,tipoentrega_idtipoentrega,empleado_idempleado,factura_idfactura,tipopago_idtipopago) Values(?,?,?,(select idfactura from factura ORDER BY idfactura  DESC LIMIT 1),?)";
        try {
            
            /*  */
            PreparedStatement pspre = conn.getConnection().prepareStatement(sqlm);
            PreparedStatement pse = conn.getConnection().prepareStatement(sqle);
             PreparedStatement psv = conn.getConnection().prepareStatement(sqlv);
            pspre.setInt(1, C.getId());
            pspre.setInt(2, F.getPreciototal());
            pse.setInt(1, P.getIdproducto());
            pse.setInt(2, FD.getCantidadfactura());
            psv.setString(1, V.getObservacionVenta());
            psv.setInt(2, V.getIdTipoEntrega());
            psv.setInt(3, e.getId());
            psv.setInt(4, V.getIdTipoPago());
            
            System.out.println(e.getNombre());
           
            
            pspre.executeUpdate();
            pse.executeUpdate();
            psv.executeUpdate();
            
 
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;

        }
    }
     public int getProductos(String Tabla, String columna , String Comparador, String Comparador2) {
         int codigo = 0;
        try {
            String sql = "select " + columna + " from "+ Tabla + " where " + Comparador+" = "+Comparador2;
            System.out.print(sql);
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Producto> list = new LinkedList<>();
            
           
            while (rs.next()) {
                codigo = (rs.getInt(columna));
                
                
            }
            return codigo;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return codigo;
        }

    }
    public void lalala (String g){
        System.out.print(g);
    
    }
}
