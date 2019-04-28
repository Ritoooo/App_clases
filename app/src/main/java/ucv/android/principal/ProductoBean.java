package ucv.android.principal;

public class ProductoBean {
    int talla,numPares, costo, marca;
    double descuento,venta,ventaNeta;

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getNumPares() {
        return numPares;
    }

    public void setNumPares(int numPares) {
        this.numPares = numPares;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public double getVentaNeta() {
        return ventaNeta;
    }

    public void setVentaNeta(double ventaNeta) {
        this.ventaNeta = ventaNeta;
    }
}
