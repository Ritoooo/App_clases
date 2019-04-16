package ucv.android.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Reporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reporte);
    }

    public void regresar(View v){
        Intent objIntent = new Intent(Reporte.this, MainActivity.class);
        startActivity(objIntent);
        finish();
        //Toast.makeText(getApplication(), "HOLA MUNDO", Toast.LENGTH_LONG).show();
    }

}
