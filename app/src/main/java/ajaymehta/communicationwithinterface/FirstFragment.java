package ajaymehta.communicationwithinterface;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private ListView listView;


    // other way to use array list....as interface
    List fruitList = new ArrayList() {{

        add("Banana");
        add("Mange");
        add("Pinapple");
        add("fish");
    }};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        init(v);
        return v;
    }

    private void init(View v) {


        listView = (ListView) v.findViewById(R.id.lv_fruits);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, fruitList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

// giving position to method of interface defined in main activity..


                try {
                    ((OnFruitsItemSelected) getActivity()).onFruitsItemPicked(position, fruitList);
                } catch (ClassCastException e) {

                    // This makes sure that the container activity has implemented
                    // the callback interface. If not, it throws an exception. ..but but but at the time of clicking on item..you can check when a fragment attach to an activity..exactly at onAttach method..
                    // google it if you wanna know how to use it with onAttach method..

                    throw new ClassCastException(getActivity().toString()
                            + " must implement OnFruitsItemSelected");
                }

            }
        });


    }

    // our interface...helps to communicate between activites and fragments

    public interface OnFruitsItemSelected {
        public void onFruitsItemPicked(int position, List fruitList);
    }


}
