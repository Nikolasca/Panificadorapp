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
public class Tipos {
    private int IdTipo;
    private  String Descripcion;
    private String Nombretipo;

    public Tipos(int IdTipo, String Descripcion) {
        this.IdTipo = IdTipo;
        this.Descripcion = Descripcion;
    }

    public int getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(int IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombretipo() {
        return Nombretipo;
    }

    public void setNombretipo(String Nombretipo) {
        this.Nombretipo = Nombretipo;
    }
    
}
