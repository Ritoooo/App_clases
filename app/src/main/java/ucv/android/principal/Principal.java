package ucv.android.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Principal extends AppCompatActivity implements View.OnClickListener {

    Spinner spnMarca,spnTalla;
    EditText txtNumPares, txtResultados;
    Button btnCalcular;

    ProductoBean objProductoBean;
    ProductoDAO objProductoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        spnMarca = (Spinner)findViewById(R.id.spnMarca);
        spnTalla = (Spinner)findViewById(R.id.spnTalla);
        txtNumPares = (EditText)findViewById(R.id.txtNumPares);
        txtResultados = (EditText)findViewById(R.id.txtResultados);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    public void calcular(){
        int marca = spnMarca.getSelectedItemPosition();
        int talla = spnTalla.getSelectedItemPosition();
        String numParesCad = txtNumPares.getText().toString();
        int numPares = Integer.parseInt(numParesCad);

        objProductoBean = new ProductoBean();
        objProductoBean.setMarca(marca);
        objProductoBean.setTalla(talla);
        objProductoBean.setNumPares(numPares);
        //Toast.makeText(getApplication(),"Marca->"+marca+" Talla->"+talla+" Y Pares->"+numPares,Toast.LENGTH_LONG).show();
        objProductoDao = new ProductoDAO();
        String mensaje = objProductoDao.calcularOperación(objProductoBean);
        txtResultados.setText(mensaje);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCalcular){


            txtResultados.setEnabled(false);
            this.calcular();
        }
    }
}
