package ucv.android.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends ListFragment {
    private final  String[] lista = {"RED","GREEN","BLUE"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter(getActivity().
                getApplicationContext(),android.R.layout.simple_list_item_1,lista));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FragmentB vista = (FragmentB)getFragmentManager().findFragmentById(R.layout.detalle);
        if (vista == null || !vista.isInLayout()){
            Intent objIntent = new Intent(getActivity(),Detalle.class);
            objIntent.putExtra("color_type",lista[position]);
            startActivity(objIntent);
        }else {
            //vista.actualizarColor(lista[position]);
        }
    }
}
