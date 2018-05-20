/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import SQL.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Marca;
import Modelos.Producto;

/**
 *
 * @author nicolasmoreno
 */
public class productoDao {

    DbConnection conn;

    public productoDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(Producto p, Marca m) {
        String sqlm = "insert into marca (nombreMarca) values(?)";
        String sqlpre = "insert into precio (preciominorista,preciomayorista) values(?,?)";
        String sqlp = "insert into producto (nombreProducto,precio_idprecio,marca_idmarca) values(?,(select idprecio from precio where preciominorista=?),(select idmarca from marca where nombreMarca=?))";
        try {
            PreparedStatement psm = conn.getConnection().prepareStatement(sqlm);
            PreparedStatement pspre = conn.getConnection().prepareStatement(sqlpre);
            PreparedStatement ps = conn.getConnection().prepareStatement(sqlp);
            psm.setString(1, m.getNombreMarca());
            pspre.setInt(1, 0);
            pspre.setInt(2, 0);
            System.out.println(p.getNombreproducto());
            ps.setString(1, p.getNombreproducto());
            ps.setInt(2,0);
            System.out.println(p.getNmarca());
            ps.setString(3, p.getNmarca());
            psm.executeUpdate();
            pspre.executeUpdate();
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Producto> getProductos() {

        try {
            String sql = "select idproducto,nombreProducto,nombreMarca,preciominorista,preciomayorista from marca inner join producto on marca.idmarca=marca_idmarca inner join precio on precio.idprecio=precio_idprecio";
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
                

                list.add(produ);
                System.out.println(produ.getNombreproducto());
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
