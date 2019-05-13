package ucv.android.dao;

import ucv.android.bean.UsuarioBean;

public class UsuarioDAO {
    String usuarioestu[] = {"Diego","Anthony","Roberto","Ivan"};
    String passwordestu[] = {"123","1234","12345","123456"};

    String usuarioadmin[] = {"admin1","admin2","admin3","admin4"};
    String passwordadmmin[] = {"123","1234","12345","123456"};

    String usuariodocente[] = {"docente1","docente2","docente3","docente4"};
    String passworddocente[] = {"123","1234","12345","123456"};

    String usuariopersonal[] = {"personal1","personal2","personal3","personal4"};
    String passwordpersonal[] = {"123","1234","12345","123456"};

    public boolean validarDocente(UsuarioBean objUsuarioBean){
        boolean estado = false;

        int op = Integer.parseInt(objUsuarioBean.getTipo());
        try {
            switch (op){
                case 1:{
                    for (int i = 0; i < usuarioadmin.length; i++) {
                        if (objUsuarioBean.getUsuario().equals(usuarioadmin[i]) &&
                            objUsuarioBean.getPassword().equals(passwordadmmin[i]) )
                                {   estado = true;  break;}
                    }break;
                }
                case 2:{
                    for (int i = 0; i < usuariodocente.length; i++) {
                        if (objUsuarioBean.getUsuario().equals(usuariodocente[i]) &&
                                objUsuarioBean.getPassword().equals(passworddocente[i]) )
                        {   estado = true;  break;}
                    }break;
                }
                case 3:{
                    for (int i = 0; i < usuarioestu.length; i++) {
                        if (objUsuarioBean.getUsuario().equals(usuarioestu[i]) &&
                                objUsuarioBean.getPassword().equals(passwordestu[i]) )
                        {   estado = true;  break;}
                    }break;
                }
            }
        }catch (Exception e){
            estado = false;
        }

        return estado;
    }

    public boolean validarEstudiante(UsuarioBean objUsuarioBean){
        boolean estado = false;
        for (int i = 0; i < usuarioestu.length; i++) {
            if (objUsuarioBean.getUsuario().equals(usuarioestu[i]) &&
                    objUsuarioBean.getPassword().equals(passwordestu[i]) )
            {   estado = true;  }
        }
        return estado;
    }

    public boolean validarPersonal(UsuarioBean objUsuarioBean){
        boolean estado = false;
        for (int i = 0; i < usuariopersonal.length; i++) {
            if (objUsuarioBean.getUsuario().equals(usuariopersonal[i]) &&
                    objUsuarioBean.getPassword().equals(passwordpersonal[i]) )
            {   estado = true;  }
        }
        return estado;
    }

}
