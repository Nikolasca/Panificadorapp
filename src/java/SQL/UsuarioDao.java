
package SQL;

import Modelos.Marca;
import Modelos.Empleado;
import Modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicolasmoreno
 */
public class UsuarioDao {
    DbConnection conn;
    
    public UsuarioDao(DbConnection conn){
        this.conn=conn;
    }
    
    public boolean insert(Usuario u,Empleado e) {
        String sqlm = "insert into usuario(username,password,perfil,estatus) Values(?,md5(?),?,?)";
        String sqle = "insert into empleado(nombreempleado,telefonoempleado,emailempleado,cargo_idcargo,idusuario) Values(?,?,?,?,(select idUsuario from usuario where username=?))";
        try {
            
            /*  */
            PreparedStatement pspre = conn.getConnection().prepareStatement(sqlm);
            PreparedStatement pse = conn.getConnection().prepareStatement(sqle);
            pspre.setString(1, u.getUsername());
            pspre.setString(2, u.getPassword());
            pspre.setString(3, "administrador");
            pspre.setString(4, "activo");
            pse.setString(1, e.getNombre());
            pse.setString(2, e.getTelefono());
            pse.setString(3, e.getEmail());
            pse.setInt(4, 1);
            pse.setString(5, u.getUsername());
            System.out.println(e.getNombre());
           
            
            pspre.executeUpdate();
            pse.executeUpdate();
            
 
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;

        }
    }
    
    public Usuario login(String user,String pass){
        try{
            String sql="select * from usuario where username=? and password=md5(?) and estatus='activo' limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            Usuario usuario = new Usuario(0);
            while(rs.next()){
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setEstatus(rs.getString("estatus"));
            }
            return usuario;
        }catch(SQLException ex){
            System.out.println("error"+ ex.getMessage());
            return null;
        }
        
    }
}
