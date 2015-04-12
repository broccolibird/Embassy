package com.uncorkedstudios.findmyembassy;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.uncorkedstudios.findmyembassy.R;

import java.util.ArrayList;
import java.util.List;

public class SelectFragment extends Fragment {

    private OnFragmentInteractionListener mListener;


    private Spinner spinner1;

    private Button OK;


    public static SelectFragment newInstance() {
        SelectFragment fragment = new SelectFragment();
        return fragment;
    }

    public SelectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_select, container, false);

        addItemsOnSpinner2(root);
        addListenerOnButton(root);
        addListenerOnSpinnerItemSelection(root);

        return root;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        public void onOkPressed();

    }


    // add items into spinner dynamically
    public void addItemsOnSpinner2(View root) {

        spinner1 = (Spinner) root.findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("USA");
        list.add("French");
        list.add("Italian");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection(View root) {
        spinner1 = (Spinner) root.findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }

        });
    }

    // get the selected dropdown list value
    public void addListenerOnButton(View root) {

        spinner1 = (Spinner) root.findViewById(R.id.spinner1);
        OK = (Button) root.findViewById(R.id.button1);

        OK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mListener!= null) {
                    mListener.onOkPressed();
                }

                Toast.makeText(SelectFragment.this.getActivity(),
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
