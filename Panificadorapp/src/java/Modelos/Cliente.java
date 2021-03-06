/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Nikolas
 */
public class Cliente extends Usuario {
   private int IdPersonaContacto;
   private boolean Estado;

    public Cliente(String Nombre,  String Telefono, String CC, int idpersonacontacto) {
        super(Nombre, Telefono, CC);
        IdPersonaContacto = idpersonacontacto;
        
    }

    public Cliente(String Nombre, String Telefono) {
        super(Nombre, Telefono);
    }

    
    public void AñadirCliente(Cliente cliente) {
        Conexion con = new Conexion();
        Connection cn = con.conectar();
        try {
            PreparedStatement pre = cn.prepareStatement("INSERT INTO Cliente  (nombreciente,telefonocliente ,personaContacto_idpersonaContacto)" + "VALUES (?,?,?)");
            pre.setString(1, cliente.getNombre());
            pre.setString(2, cliente.getTelefono());
            pre.setInt(3, cliente.getIdPersonaContacto());
            pre.executeUpdate();
            cliente.setEstado(true);
        } catch (Exception e) {
            System.err.println(e);

        }
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
    public int getIdPersonaContacto() {
        return IdPersonaContacto;
    }

    public void setIdPersonaContacto(int IdPersonaContacto) {
        this.IdPersonaContacto = IdPersonaContacto;
    }
    
}
