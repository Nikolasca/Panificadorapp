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
public class DetalleFactura {
   private int IdDetalleFactura;
   private int IdFactura;
   private int IdProdcto;
   private int cantidadfactura;

    public DetalleFactura(int IdFactura, int IdProdcto, int CantidadFactura) {
        this.IdFactura = IdFactura;
        this.IdProdcto = IdProdcto;
        this.cantidadfactura = CantidadFactura;
    }

    public DetalleFactura() {
    }

    public int getIdDetalleFactura() {
        return IdDetalleFactura;
    }

    public void setIdDetalleFactura(int IdDetalleFactura) {
        this.IdDetalleFactura = IdDetalleFactura;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public int getIdProdcto() {
        return IdProdcto;
    }

    public void setIdProdcto(int IdProdcto) {
        this.IdProdcto = IdProdcto;
    }

    public int getCantidadfactura() {
        return cantidadfactura;
    }

    public void setCantidadfactura(int cantidadfactura) {
        this.cantidadfactura = cantidadfactura;
    }
   
   
}
