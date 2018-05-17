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
public class Usuario {
    private String Nombre;
    private String Telefono;
    private String Email;
    private String CC;

    public Usuario(String Nombre, String Telefono, String Email, String CC) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Email = Email;
        this.CC = CC;
    }

    public Usuario(String Nombre, String Telefono, String Email) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public Usuario(String Nombre) {
        this.Nombre = Nombre;
    }
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Usuario(String Nombre, String Telefono) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }


    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }
    
}
