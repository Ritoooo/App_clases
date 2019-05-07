package ucv.android.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class index extends AppCompatActivity {

    ImageButton btnPersonal, btnEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_index);
        iniComponents();
    }
    private void iniComponents() {
        setContentView(R.layout.activity_index);
        btnPersonal = (ImageButton)findViewById(R.id.btnPersonal);
        btnPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPersonal();
            }
        });
        btnEstudiante = (ImageButton)findViewById(R.id.btnEstudiante);
        btnEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEstudiante();
            }
        });
    }

    public void goToPersonal(){
        Intent objIntentPersonal = new Intent(index.this, FrmLoginPersonal.class);
        startActivity(objIntentPersonal);
        finish();
    }

    public void goToEstudiante(){
        Intent objIntentEstudiante = new Intent(index.this, FrmLoginEstudiante.class);
        startActivity(objIntentEstudiante);
        finish();
    }

}
