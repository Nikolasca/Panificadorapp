/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelos.Marca;
import Modelos.Producto;
import Modelos.estadistica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nicolasmoreno
 */
public class graficaDao {
    DbConnection conn;

    public graficaDao(DbConnection conn) {
        this.conn = conn;
    }
    
    public String getMejorVendedor(){
        try {
            String sql = "select distinct e.nombreempleado, count(v.empleado_idempleado)ventas\n" +
"  from venta v inner join empleado e on v.empleado_idempleado=e.idempleado\n" +
"  where e.nombreempleado=\"carlos rodriguez\"\n" +
"  group by e.idempleado\n" +
"  having count(v.empleado_idempleado)=(select max(ventas) from (select e.nombreempleado, count(v.empleado_idempleado)ventas\n" +
"  from venta v inner join empleado e on v.empleado_idempleado=e.idempleado\n" +
"  group by e.idempleado\n" +
"  having count(v.empleado_idempleado))as t ) ";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String resp="";
            while (rs.next()) {
            
            resp = rs.getString("nombreempleado");
           
            System.out.println(resp);
            }

            
            
            return resp;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Producto> getProductos() {

        try {
            String sql = "select idproducto,nombreProducto,nombreMarca,preciominorista,preciomayorista,rutaimg from marca inner join producto on marca.idmarca=marca_idmarca inner join precio on precio.idprecio=precio_idprecio";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Producto> list = new LinkedList<>();

            Producto produ;
            while (rs.next()) {
                produ = new Producto(rs.getInt("idproducto"));
                produ.setNombreProducto(rs.getString("nombreProducto"));
                produ.setNmarca(rs.getString("nombreMarca"));
                produ.setPreciominorista(rs.getInt("preciominorista"));
                produ.setPreciomayorista(rs.getInt("preciomayorista"));
                produ.setRutaimg(rs.getString("rutaimg"));
                

                list.add(produ);
                System.out.println(produ.getNombreproducto());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public List<estadistica> getVentas() {

        try {
            String sql = "select e.nombreempleado ,count(v.idventa)ventas from empleado e inner join venta v on e.idempleado=v.empleado_idempleado group by e.idempleado ;";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<estadistica> list = new LinkedList<>();

            estadistica esta;
            while (rs.next()) {
                esta = new estadistica();
                esta.setNombre(rs.getString("nombreempleado"));
                esta.setValor(Integer.parseInt(rs.getString("ventas")));
                

                list.add(esta);
                System.out.println(esta.getNombre());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public List<estadistica> getproductos() {

        try {
            String sql = "select p.nombreProducto ,count(v.idventa)ventas from venta v inner join factura f on v.factura_idfactura=f.idfactura inner join facturadetalle d on d.factura_idfactura=f.idfactura inner join producto p on p.idproducto=d.producto_idproducto group by p.idproducto ;";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<estadistica> list = new LinkedList<>();

            estadistica esta;
            while (rs.next()) {
                esta = new estadistica();
                esta.setNombre(rs.getString("nombreProducto"));
                esta.setValor(Integer.parseInt(rs.getString("ventas")));
                

                list.add(esta);
                System.out.println(esta.getNombre());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public List<estadistica> ventapormes() {

        try {
            String sql = "select monthname(f.fecha_factura)fecha,count(v.idventa)numero from venta v INNER JOIN factura f ON v.factura_idfactura = f.idfactura GROUP BY idventa";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<estadistica> list = new LinkedList<>();

            estadistica esta;
            while (rs.next()) {
                esta = new estadistica();
                esta.setNombre(rs.getString("fecha"));
                esta.setValor(Integer.parseInt(rs.getString("numero")));
                

                list.add(esta);
                System.out.println(esta.getValor());
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public int delete(int idproducto) {
        try {
            String psql = "delete from facturadetalle where producto_idproducto=?";
            String sql = "delete from producto where idproducto=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            PreparedStatement pps = conn.getConnection().prepareStatement(psql);
            System.out.println(idproducto);
            pps.setInt(1, idproducto);
            ps.setInt(1, idproducto);
            pps.executeUpdate();
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
