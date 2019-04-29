package ucv.android.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import ucv.android.dao.AlumnoDAO;
import ucv.android.model.AlumnoBean;

import ucv.android.model.AlumnoBean;

public class Principal extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    EditText txtPromedio, txtResultado;
    RadioGroup rgCategoria, rgTipo;
    RadioButton rdA,rdB,rdC,rdD,rdInterno,rdExterno;
    Button btnCalcular;

    String tipo, categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        txtPromedio = (EditText)findViewById(R.id.txtPromedio);
        txtResultado = (EditText)findViewById(R.id.txtResultado);

        rgCategoria = (RadioGroup)findViewById(R.id.rgdCategoria);
        rgCategoria.setOnCheckedChangeListener(this);
        rdA = (RadioButton)findViewById(R.id.rdA);
        rdB = (RadioButton)findViewById(R.id.rdB);
        rdC = (RadioButton)findViewById(R.id.rdC);
        rdD = (RadioButton)findViewById(R.id.rdD);

        rgTipo = (RadioGroup)findViewById(R.id.rgTipo);
        rgTipo.setOnCheckedChangeListener(this);
        rdInterno = (RadioButton)findViewById(R.id.rdInterno);
        rdExterno = (RadioButton)findViewById(R.id.rdExterno);

        txtResultado.setEnabled(false);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btnCalcular){
            try {
                calcular();
            }catch (Exception e){
                txtResultado.setText(e.getMessage());
            }
        }
    }

    private void calcular() {
        String cat = categoria;
        String tip = tipo;
        int promedio = Integer.parseInt(txtPromedio.getText().toString());

        AlumnoBean objAlumnoBean = new AlumnoBean();
        objAlumnoBean.setCategoria(cat);
        objAlumnoBean.setTipo(tipo);
        objAlumnoBean.setPromedio(promedio);

        AlumnoDAO objAlumnoDAO = new AlumnoDAO();
        txtResultado.setText(objAlumnoDAO.calcularOperacion(objAlumnoBean));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group == rgCategoria){
            if (rdA.isChecked())    {   categoria = rdA.getText().toString();   }
            if (rdB.isChecked())    {   categoria = rdB.getText().toString();   }
            if (rdC.isChecked())    {   categoria = rdC.getText().toString();   }
            if (rdD.isChecked())    {   categoria = rdD.getText().toString();   }
        }
        if (group == rgTipo){
            if (rdInterno.isChecked())  {   tipo = rdInterno.getText().toString();  }
            if (rdExterno.isChecked())  {   tipo = rdExterno.getText().toString();  }
        }
    }
}
