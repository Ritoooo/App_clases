package ucv.android.principal;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cancelButton, sortButton;
    int[] numbers = {1,5,7,4,8};
    int position = 1;
    TextView progressLabel;

    SimpleTask simpleTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        sortButton = (Button)findViewById(R.id.sortButton);
        progressLabel = (TextView)findViewById(R.id.progressLabel);
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
                break;
        }
    }

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

    private class SimpleTask extends AsyncTask<Void,Integer,Void>{

        @Override
        protected void onPreExecute() {
            cancelButton.setVisibility(View.VISIBLE);
            sortButton.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int aux;
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length -1; j++) {
                    if (numbers[j] > numbers[j+1])
                    { aux = numbers[j];
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
            sortButton.setEnabled(true);
        }
    }

    }
