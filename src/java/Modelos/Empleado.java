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
public class Empleado extends Usuario {
 private int idcargo;
 private int idempleado;
 private String nombre;
 private String telefono;
 private String email;
 private String cc;
    public Empleado(String nombre, String telefono, String email,String cc,String username,String password, String perfil,String estatus) {
        super(username,password,perfil,estatus);
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.cc=cc;
        
    }

    public Empleado() {
    }

    public Empleado(int idempleado) {
        this.idempleado = idempleado;
    }

  
    

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

   
    
    
}
