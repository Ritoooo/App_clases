package ucv.android.principal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import ucv.android.principal.index.ProgressBarTask;

public class HiddenFragment extends Fragment {

    /*
    Interfaz para la comunicación con la actividad ABTest.
     */
    static interface TaskCallbacks {
        void onPreExecute();
        void onProgressUpdate(int progress);
        void onCancelled();
        void onPostExecute();
    }

    private TaskCallbacks mCallbacks;
    ProgressBarTask progressBarTask;

    public HiddenFragment() {}

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //Obtener la instancia de ABTest

        mCallbacks = (TaskCallbacks) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Retener el fragmento creado
        setRetainInstance(true);

        //Una vez creado el fragmento se inicia la tarea asincrona
        progressBarTask = new ProgressBarTask();
        progressBarTask.execute();
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallbacks = null;
    }


    public class ProgressBarTask extends AsyncTask<Void, Integer, Long> {

        @Override
        protected void onPreExecute() {
            if (mCallbacks != null) {
                mCallbacks.onPreExecute();
            }
        }

        @Override
        protected Long doInBackground(Void... params) {
            long t0 = System.currentTimeMillis();

            int aux;
            int numbers[] = ABTest.numbers;

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length -1; j++) {
                    if (numbers[j] > numbers[j+1])
                    {
                        aux          = numbers[j];
                        numbers[j]   = numbers[j+1];
                        numbers[j+1] = aux;
                    }
                }
                if(!isCancelled())
                    publishProgress((int)(((i+1)/(float)(numbers.length-1))*100));
                else break;

            }

            return t0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            if (mCallbacks != null) {
                mCallbacks.onProgressUpdate(values[0]);
            }
        }

        @Override
        protected void onPostExecute(Long aLong) {
            if (mCallbacks != null) {
                mCallbacks.onPostExecute();
            }
        }


    }

}
