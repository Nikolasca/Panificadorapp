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
    private int id;
    private String username;
    private String password;
    private String perfil;
    private String estatus="activo";

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario() {
    }


    public Usuario(String username, String password, String perfil,String estatus) {
        this.username = username;
        this.password = password;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", perfil=" + perfil + ", estatus=" + estatus + '}';
    }

    

   
    
}
