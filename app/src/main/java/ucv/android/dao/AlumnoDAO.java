package ucv.android.dao;

import ucv.android.model.AlumnoBean;

public class AlumnoDAO {
    AlumnoBean objAlumnoBean;

    public String calcularOperacion(AlumnoBean objAlumnoBean){
        String mensaje = "";

        String categoria = objAlumnoBean.getCategoria();
        String tipo = objAlumnoBean.getTipo();
        int promedio = objAlumnoBean.getPromedio();

        this.objAlumnoBean = new AlumnoBean();
        this.objAlumnoBean.setCategoria(categoria);
        this.objAlumnoBean.setTipo(tipo);
        this.objAlumnoBean.setPromedio(promedio);

        int pension = this.calcularPension(this.objAlumnoBean);
        this.objAlumnoBean.setPension(pension);
        double descuento = this.calcularDescuento(this.objAlumnoBean);
        this.objAlumnoBean.setDescuento(descuento);
        double nuevaPension = this.calcularPensionFinal(this.objAlumnoBean);
        this.objAlumnoBean.setNuevaPension(nuevaPension);

        mensaje =   "La pensión es->"+pension+"\n"+
                    "Tu descuento es->"+descuento+"\n"+
                    "Tu nueva pensión será"+nuevaPension+"\n";

        return mensaje;
    }

    private int calcularPension(AlumnoBean objAlumnoBean) {
        int pension = 0;

        switch (objAlumnoBean.getCategoria()){
            case "A":{
                switch (objAlumnoBean.getTipo()){
                    case "Interno":{    pension = 600;  }break;
                    case "Externo":{    pension = 550;  }break;
                }break;
            }
            case "B":{
                switch (objAlumnoBean.getTipo()){
                    case "Interno":{    pension = 550;  }break;
                    case "Externo":{    pension = 500;  }break;
                }break;
            }
            case "C":{
                switch (objAlumnoBean.getTipo()){
                    case "Interno":{    pension = 500;  }break;
                    case "Externo":{    pension = 460;  }break;
                }break;
            }
            case "D":{
                switch (objAlumnoBean.getTipo()){
                    case "Interno":{    pension = 450;  }break;
                    case "Externo":{    pension = 400;  }break;
                }break;
            }
        }

        return pension;
    }

    private double calcularDescuento(AlumnoBean objAlumnoBean) {
        double descuento = 0;

        if (objAlumnoBean.getPromedio() >= 14 && objAlumnoBean.getPromedio() < 16){
            descuento = objAlumnoBean.getPension() * 0.10;
        }else if (objAlumnoBean.getPromedio() >= 16 && objAlumnoBean.getPromedio() < 18){
            descuento = objAlumnoBean.getPension() * 0.12;
        }else if (objAlumnoBean.getPromedio() >= 18 && objAlumnoBean.getPromedio() <= 20){
            descuento = objAlumnoBean.getPension() * 0.15;
        }

        return descuento;
    }

    private double calcularPensionFinal(AlumnoBean objAlumnoBean) {
        double nuevaPension = 0;

        nuevaPension = objAlumnoBean.getPension() - objAlumnoBean.getDescuento();

        return nuevaPension;
    }

}
