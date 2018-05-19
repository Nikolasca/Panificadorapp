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
public class Producto {
    private int Idproducto;
    private String Nombreproducto;
    private int Precio_Mayorista;
    private int Precio_Minorista;
    private int IdMarca;
    private String Nmarca;

    public Producto(String NombreProducto, int Precio_Mayorista, int Precio_Minorista, int IdMarca) {
        this.Nombreproducto = NombreProducto;
        this.Precio_Mayorista = Precio_Mayorista;
        this.Precio_Minorista = Precio_Minorista;
        this.IdMarca = IdMarca;
    }
public Producto (int id){
this.Idproducto = id;
}
    public String getNmarca() {
        return Nmarca;
    }

    public void setNmarca(String nMarca) {
        this.Nmarca = nMarca;
    }

    public int getIdproducto() {
        return Idproducto;
    }

    public void setIdproducto(int Idproducto) {
        this.Idproducto = Idproducto;
    }

    public String getNombreproducto() {
        return Nombreproducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.Nombreproducto = NombreProducto;
    }

    public int getPrecio_Mayorista() {
        return Precio_Mayorista;
    }

    public void setPrecio_Mayorista(int Precio_Mayorista) {
        this.Precio_Mayorista = Precio_Mayorista;
    }

    public int getPrecio_Minorista() {
        return Precio_Minorista;
    }

    public void setPrecio_Minorista(int Precio_Minorista) {
        this.Precio_Minorista = Precio_Minorista;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }
    
            
}
