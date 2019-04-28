package ucv.android.principal;

public class ProductoDAO {

    ProductoBean objProductoBean;

    public String calcularOperación(ProductoBean objProductoBean){
        String mensaje = "";
        int marca = objProductoBean.getMarca();
        int talla = objProductoBean.getTalla();
        int numPares = objProductoBean.getNumPares();

        this.objProductoBean = new ProductoBean();
        this.objProductoBean.setMarca(marca);
        this.objProductoBean.setTalla(talla);
        this.objProductoBean.setNumPares(numPares);

        int costo = calcularCostoZapatillas(this.objProductoBean);
        this.objProductoBean.setCosto(costo);
        int venta = calcularVenta(this.objProductoBean);
        this.objProductoBean.setVenta(venta);
        double descuento = calcularDescuento(this.objProductoBean);
        this.objProductoBean.setDescuento(descuento);
        double ventaNeta = calcularVentaNeta(this.objProductoBean);
        this.objProductoBean.setVentaNeta(ventaNeta);

        mensaje =   "El costo del par es -> "+ costo +"\n"+
                    "La venta de las zapatillas es -> "+ venta + "\n"+
                    "El descuento es -> " + descuento + "\n"+
                    "La venta neta es -> " + ventaNeta;

        return mensaje;
    }

    public int calcularCostoZapatillas(ProductoBean objProductoBean){
        int costo = 0;

        switch (objProductoBean.getMarca()){
            case 0:{
                switch (objProductoBean.getTalla()){
                    case 0:{ costo = 150;   break;}
                    case 1:{ costo = 160;   break;}
                    case 2:{ costo = 160;   break;}
                }break;
            }
            case 1:{
                switch (objProductoBean.getTalla()){
                    case 0:{ costo = 140;   break;}
                    case 1:{ costo = 150;   break;}
                    case 2:{ costo = 150;   break;}
                }break;
            }
            case 2:{
                switch (objProductoBean.getTalla()){
                    case 0:{ costo = 80;   break;}
                    case 1:{ costo = 85;   break;}
                    case 2:{ costo = 90;   break;}
                }break;
            }
        }

        return costo;
    }
    public int calcularVenta(ProductoBean objProductoBean){
        int venta = 0;

        venta = objProductoBean.getCosto() * objProductoBean.getNumPares();

        return venta;
    }

    public double calcularDescuento(ProductoBean objProductoBean){
        double descuento = 0;

        if (objProductoBean.getNumPares() >= 2 && objProductoBean.getNumPares() <= 5){
            descuento = objProductoBean.getVenta() * 0.05;
        }else if (objProductoBean.getNumPares() >= 6 && objProductoBean.getNumPares() <= 10){
            descuento = objProductoBean.getVenta() * 0.08;
        }else if (objProductoBean.getNumPares() >= 11 && objProductoBean.getNumPares() <= 20){
            descuento = objProductoBean.getVenta() * 0.10;
        }else if (objProductoBean.getNumPares() > 20){
            descuento = objProductoBean.getVenta() * 0.15;
        }

        return descuento;
    }

    public double calcularVentaNeta(ProductoBean objProductoBean){
        double ventaNeta = 0;

        ventaNeta = objProductoBean.getVenta() - objProductoBean.getDescuento();

        return ventaNeta;
    }
}
