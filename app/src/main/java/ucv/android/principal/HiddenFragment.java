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

//import ucv.android.principal.MainActivity.ProgressBarTask;

public class HiddenFragment extends Fragment {


        public static interface TaskCallbacks{
            void onPreExecute();
            void onProgressUpdate(int progress);
            void onCancelled();
            void onPostExecute();
        }
        private TaskCallbacks mCallbacks;
        ProgressBarTask progressVarTask;

    public HiddenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        progressVarTask = new ProgressBarTask();
        progressVarTask.execute();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (TaskCallbacks) activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (TaskCallbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    public class ProgressBarTask extends AsyncTask<Void,Integer,Long> {
        @Override
        protected void onPreExecute() {
            if (mCallbacks != null){
                mCallbacks.onPreExecute();
            }
        }

        @Override
        protected void onPostExecute(Long aLong) {
            //super.onPostExecute(aLong);
            if (mCallbacks != null){
                mCallbacks.onPostExecute();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //super.onProgressUpdate(values);
            if (mCallbacks != null){
                mCallbacks.onProgressUpdate(values[0]);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Long doInBackground(Void... params) {
            long t0 = System.currentTimeMillis();
            int aux;
            int numbers[] = ABTest.numbers;
            for (int i = 0; i < numbers.length -1 ; i++) {
                for (int j = 0; j < numbers.length -1 ; j++) {
                    if (numbers[j] > numbers[j+1]) {
                        aux = numbers[j];
                        numbers[j] = numbers[j+1];
                        numbers[j+1] = aux;
                    }
                }
                if (!isCancelled())
                    publishProgress((int)(((i+1)/(float)(numbers.length))*100));
                else break;
            }
            return t0;
        }
    }




}
