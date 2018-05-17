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
public class Venta {
    private int IdVenta;
    private String ObservacionVenta;
    private int IdTipoEntrega;
    private int IdEmpleado;
    private int idFactura;
    private int IdTipoPago;

    public Venta(String ObservacionVenta, int IdTipoEntrega, int IdEmpleado, int idFactura, int IdTipoPago) {
        this.ObservacionVenta = ObservacionVenta;
        this.IdTipoEntrega = IdTipoEntrega;
        this.IdEmpleado = IdEmpleado;
        this.idFactura = idFactura;
        this.IdTipoPago = IdTipoPago;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getObservacionVenta() {
        return ObservacionVenta;
    }

    public void setObservacionVenta(String ObservacionVenta) {
        this.ObservacionVenta = ObservacionVenta;
    }

    public int getIdTipoEntrega() {
        return IdTipoEntrega;
    }

    public void setIdTipoEntrega(int IdTipoEntrega) {
        this.IdTipoEntrega = IdTipoEntrega;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdTipoPago() {
        return IdTipoPago;
    }

    public void setIdTipoPago(int IdTipoPago) {
        this.IdTipoPago = IdTipoPago;
    }
    
    
    
}
