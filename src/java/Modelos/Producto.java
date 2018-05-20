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
import java.io.Serializable;
public class Producto implements Serializable {
    private int Idproducto;
    private String Nombreproducto;
    private int Preciomayorista;
    private int Preciominorista;
    private int IdMarca;
    private String Nmarca;

    public Producto(String NombreProducto, int Precio_Mayorista, int Precio_Minorista, int IdMarca) {
        this.Nombreproducto = NombreProducto;
        this.Preciomayorista = Precio_Mayorista;
        this.Preciominorista = Precio_Minorista;
        this.IdMarca = IdMarca;
    }

    public Producto(int Idproducto, String Nombreproducto, int Preciomayorista, int Preciominorista, String Nmarca) {
        this.Idproducto = Idproducto;
        this.Nombreproducto = Nombreproducto;
        this.Preciomayorista = Preciomayorista;
        this.Preciominorista = Preciominorista;
        this.Nmarca = Nmarca;
    }

    public Producto() {
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

    public int getPreciomayorista() {
        return Preciomayorista;
    }

    public void setPreciomayorista(int Preciomayorista) {
        this.Preciomayorista = Preciomayorista;
    }

    public int getPreciominorista() {
        return Preciominorista;
    }

    public void setPreciominorista(int Preciominorista) {
        this.Preciominorista = Preciominorista;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    @Override
    public String toString() {
        return "Producto{" + "Idproducto=" + Idproducto + ", Nombreproducto=" + Nombreproducto + ", Preciomayorista=" + Preciomayorista + ", Preciominorista=" + Preciominorista + ", IdMarca=" + IdMarca + ", Nmarca=" + Nmarca + '}';
    }
    
            
}
