package ucv.android.principal;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ucv.android.principal.HiddenFragment.TaskCallbacks;

public class ABTest extends AppCompatActivity implements TaskCallbacks {

    static int[] numbers = {1,5,7,4,8,4,8,5,1,63,49,4,9,5,1,24,8,7,5,9,6,3,2,
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
            8,5,9,5,3,2,6,18,2,4,9,5,7,9,4,65,41,4,5,100,1,10,2,4,5,8,15};

    Button cancelButton, sortButton;
    int position = 3;
    TextView progressLabel;
    ProgressBar progressBar;
    HiddenFragment fragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abtest);
        cancelButton = (Button)findViewById(R.id.cancelButton2);
        sortButton = (Button)findViewById(R.id.sortButton2);
        progressLabel = (TextView)findViewById(R.id.progressLabel2);
        fragment = (HiddenFragment)getSupportFragmentManager().findFragmentByTag("HIDDEN_FRAGMENT_TAG");
        if (position ==3 && fragment != null){
            if (fragment.progressBarTask.getStatus() == Status.RUNNING){
                progressBar.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.VISIBLE);
                sortButton.setEnabled(false);
            }
        }
    }

    public void onClickSort(View view){
        execWhithProgressBar();
    }

    private void execWhithProgressBar(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = new HiddenFragment();
        transaction.add(R.id.container,fragment,"HIDDEN_FRAGMENT_TAG").commit();
        //transaction.commit();
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
