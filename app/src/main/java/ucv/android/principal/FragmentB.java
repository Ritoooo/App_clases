package ucv.android.principal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class FragmentB extends ListFragment {
    TextView mtext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        Intent objIntent = getActivity().getIntent();
        String color = objIntent.getStringExtra("color_type");
        View vista = (View) inflater.inflate(R.layout.detalle, container, false);
        mtext = (TextView) vista.findViewById(R.id.lblMensaje);
        actualizarColor(color);
        return vista;
    }

    private void actualizarColor(String color) {
        if (color != null) {
            if (color.equals("RED")) {
                mtext.setBackground(getResources().getDrawable(R.color.red));
            } else if (color.equals("BLUE")) {
                mtext.setBackground(getResources().getDrawable(R.color.blue));
            } else if (color.equals("GREEN")) {
                mtext.setBackground(getResources().getDrawable(R.color.green));
            }
        }
    }
}