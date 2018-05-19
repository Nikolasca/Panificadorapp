/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nikolas
 */
public class PersonaContacto extends Usuario {
   private int IdPersonaContacto;
   private boolean estado;
    public PersonaContacto(String Nombre,  String Telefono, String Email, String CC) {
        super(Nombre,  Telefono, Email, CC);
    }
public void AñadirPersonaContacto(PersonaContacto cliente) {
        Conexion con = new Conexion();
        Connection cn = con.conectar();
        try {
            PreparedStatement pre = cn.prepareStatement("INSERT INTO PersonaContacto (nombrepersonacontacto,emailpersonacontacto,telpersonacontacto, documentopersonacontacto)" + "VALUES (?,?,?,?)");
            pre.setString(1, cliente.getNombre());
            pre.setString(2, cliente.getEmail());
            pre.setString(3, cliente.getTelefono());
            pre.setString(4, cliente.getCC());
            pre.executeUpdate();
            cliente.setEstado(true);
        } catch (Exception e) {
            System.err.println(e);

        }
    }


   
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public int getIdPersonaContacto() {
        return IdPersonaContacto;
    }

    public void setIdPersonaContacto(int IdPersonaContacto) {
        this.IdPersonaContacto = IdPersonaContacto;
    }
    
}
