package ucv.android.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private PersonaDAO objPersonaDAO;
    EditText txtnombre,txtapellido,txtdni;
    ArrayList<Persona> lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtnombre = (EditText)findViewById(R.id.txtNombre);
        txtapellido = (EditText)findViewById(R.id.txtApellido);
        txtdni = (EditText)findViewById(R.id.txtDni);
        objPersonaDAO = new PersonaDAO(this);
        objPersonaDAO.open();
    }

    public void grabar(View v){
        String nom = txtnombre.getText().toString();
        String ape = txtapellido.getText().toString();
        String dni = txtdni.getText().toString();

        long i = 0;
        i = objPersonaDAO.insertar(nom,ape,dni);
        if (i==0){
            Toast.makeText(getApplicationContext(),"Registro NO Insertado",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Registro Insertado",Toast.LENGTH_LONG).show();
            txtnombre.setText("");
            txtapellido.setText("");
            txtdni.setText("");
        }
    }

    public void cargarTabla(View v){
        String acum = "";
        try {
            lista = objPersonaDAO.listadoGeneral();
            for (Persona obj:lista){
                acum += obj.getNombre() + " " + obj.getApellido() + " " + obj.getDni() + "\n";
            }
            Toast.makeText(getApplicationContext(),acum,Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }
    }

}
