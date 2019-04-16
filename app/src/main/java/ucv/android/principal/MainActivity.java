package ucv.android.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View v){
        Intent objIntent = new Intent(MainActivity.this, Reporte.class);
        startActivity(objIntent);
        finish();
        //Toast.makeText(getApplication(), "HOLA MUNDO", Toast.LENGTH_LONG).show();
    }


}
