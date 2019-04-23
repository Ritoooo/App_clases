package ucv.android.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Principal extends AppCompatActivity  {

    Spinner spnMarca,spnTalla;
    EditText txtNumPares, txtResultados;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

    }


}
