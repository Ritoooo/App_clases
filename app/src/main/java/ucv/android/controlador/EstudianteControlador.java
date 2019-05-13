package ucv.android.controlador;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import ucv.android.principal.FrmLoginEstudiante;

public class EstudianteControlador extends Service {
    public EstudianteControlador() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent objIntent = new Intent(EstudianteControlador.this, FrmLoginEstudiante.class);
        objIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(objIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
