/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;

/**
 *
 * @author Nikolas
 */
public class Factura {
    private int Idfactura;
    private  int Cliente_idcliente;
    private Date Fecha;
    private  int Preciototal;

    public Factura() {
    }

    public int getIdfactura() {
        return Idfactura;
    }

    public void setIdfactura(int Idfactura) {
        this.Idfactura = Idfactura;
    }

    public int getCliente_idcliente() {
        return Cliente_idcliente;
    }

    public void setCliente_idcliente(int Cliente_idcliente) {
        this.Cliente_idcliente = Cliente_idcliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getPreciototal() {
        return Preciototal;
    }

    public void setPreciototal(int Preciototal) {
        this.Preciototal = Preciototal;
    }
    
    
    
}
