/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Nikolas
 */
public class Proveedor extends Usuario {
  private int IdProveedor;
  private int IdPersonaContacto;
    public Proveedor(String Nombre, int idproveedor, int idpersonacontacto) {
        super();
        IdProveedor = idproveedor;
        IdPersonaContacto =  idpersonacontacto;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public int getIdPersonaContacto() {
        return IdPersonaContacto;
    }

    public void setIdPersonaContacto(int IdPersonaContacto) {
        this.IdPersonaContacto = IdPersonaContacto;
    }
    
}
