package ucv.android.model;

public class AlumnoBean {
    String categoria, tipo;
    int promedio, pension;
    double nuevaPension, descuento;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }

    public double getNuevaPension() {
        return nuevaPension;
    }

    public void setNuevaPension(double nuevaPension) {
        this.nuevaPension = nuevaPension;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
