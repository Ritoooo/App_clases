package ucv.android.principal;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ucv.android.principal.HiddenFragment.TaskCallbacks;

public class MainActivity extends AppCompatActivity implements TaskCallbacks{

    Button cancelButton, sortButton;
    int[] numbers = {
            1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,15,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,
            4,1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,1,5,4,8,
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,
            1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2
    };
    int position = 2;
    TextView progressLabel;
    ProgressBar progressBar;
    HiddenFragment fragment;

    SimpleTask simpleTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        sortButton = (Button)findViewById(R.id.sortButton);
        progressLabel = (TextView)findViewById(R.id.progressLabel);
        fragment = (HiddenFragment)getSupportFragmentManager().findFragmentByTag("HIDDEN_FRAGMENT_TAG");
        if (position ==3 && fragment != null){
            if (fragment.progressBarTask.getStatus() == AsyncTask.Status.RUNNING){
                progressBar.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.VISIBLE);
                sortButton.setEnabled(false);
            }
        }

    }

    private void bubbleSort(int[] numbers)
    { int aux;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length -1; j++) {
                if (numbers[j] > numbers[j+1])
                { aux = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = aux;
                }
            }
        }
    }


    public void onClickSort(View v) {
        switch (position) {
            case 0: bubbleSort(numbers);
                Toast.makeText(getBaseContext(),"¡NúmerosOrdenados!",Toast.LENGTH_LONG).show();
                break;
            case 1:
                execWithThread();
                break;
            case 2:
                execWithAsyncTask();
                break;
            case 3:
                execWhithProgressBar();
                break;
        }
    }

    public void onClickCancel(View view){
        simpleTask.cancel(true);
    }

    /*
    *EXPERIMENTO 2
    */
    public void execWithThread(){
        new Thread(
                new Runnable()
                {
                    @Override
                    public void run() {
                        bubbleSort(numbers);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText( getBaseContext(),"¡Números Ordenados!",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
        ).start();
    }


    public void execWithAsyncTask(){
        simpleTask= new SimpleTask();
        simpleTask.execute();
    }

    private void execWhithProgressBar(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new HiddenFragment();
        transaction.add(R.id.container,fragment).commit();
    }

    private class SimpleTask extends AsyncTask<Void,Integer,Void>{
        /*
        Se hace visible el botón "Cancelar" y se desactiva el botón "Ordenar"
         */
        @Override
        protected void onPreExecute() {
            cancelButton.setVisibility(View.VISIBLE);
            sortButton.setEnabled(false);
        }

        /*
        EJECUCIÓN DEL ORDENAMIENTO Y TRANSMISIÓN de PROGRESO
         */
        @Override
        protected Void doInBackground(Void... params) {
            int aux;
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length -1; j++) {
                    if (numbers[j] > numbers[j+1])
                    {   aux = numbers[j];
                        numbers[j] = numbers[j+1];
                        numbers[j+1] = aux;
                    }
                }
                // Notifica a onProgressUpdate() del progreso actual
                if(!isCancelled())
                    publishProgress((int)(((i+1)/(float)(numbers.length-1))*100));
                else break;
            }

            return null;
        }
        /*
         Se informa en progressLabel que se canceló la tarea y
         se hace invisile el botón "Cancelar"
         */
        @Override
        protected void onCancelled() {
            super.onCancelled();
            progressLabel.setText("En la Espera");
            cancelButton.setVisibility(View.INVISIBLE);
            sortButton.setEnabled(true);
        }
        /*
        Impresión del progreso en tiempo real
        */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressLabel.setText(values[0] + "%");
        }
        /*
        Se notifica que se completó el ordenamiento y se habilita de nuevo el botón
       "Ordenar"
        */
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressLabel.setText("Completado");
            cancelButton.setVisibility(View.INVISIBLE);
            sortButton.setEnabled(true);
        }
    }


    @Override
    public void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        cancelButton.setVisibility(View.VISIBLE);
        sortButton.setEnabled(false);
    }

    @Override
    public void onProgressUpdate(int progress) {
        progressBar.setProgress(progress);
        progressLabel.setText(progress+"%");
    }

    @Override
    public void onCancelled() {
        progressBar.setVisibility(View.INVISIBLE);
        cancelButton.setVisibility(View.INVISIBLE);
        progressLabel.setText("En la espera");
        sortButton.setEnabled(true);
    }

    @Override
    public void onPostExecute() {
        progressBar.setVisibility(View.INVISIBLE);
        cancelButton.setVisibility(View.INVISIBLE);
        sortButton.setEnabled(true);
        progressLabel.setText("Completado");
    }

    }
