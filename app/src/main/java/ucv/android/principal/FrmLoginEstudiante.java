package ucv.android.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ucv.android.bean.UsuarioBean;
import ucv.android.dao.UsuarioDAO;

public class FrmLoginEstudiante extends AppCompatActivity {

    Button btnIngresar;
    EditText txtusu, txtpass;

    UsuarioDAO objUsuarioDAO;
    UsuarioBean objUsuarioBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_login_estudiante);
        txtusu = (EditText)findViewById(R.id.txtUsuario);
    }

    public void ingresar(View v){
        if(v == btnIngresar){
            validar();
        }
    }

    public void validar(){
        String usu = txtusu.getText().toString();
        String pass = txtpass.getText().toString();

        objUsuarioBean = new UsuarioBean();
        objUsuarioBean.setUsuario(usu);
        objUsuarioBean.setPassword(pass);

        objUsuarioDAO = new UsuarioDAO();
        boolean res = objUsuarioDAO.validarEstudiante(objUsuarioBean);
        if (res == true){
            Intent objIntent = new Intent(FrmLoginEstudiante.this,ContentFrmPrincipalEstudiante.class);
            startActivity(objIntent);
        }
    }

}
