package com.uncorkedstudios.findmyembassy;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EmbassyMapFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private GoogleMap mMap;

    private ListView listView;

    private InfoAdapter adapter;

    public static EmbassyMapFragment newInstance() {
        EmbassyMapFragment fragment = new EmbassyMapFragment();

        return fragment;
    }

    public EmbassyMapFragment() {
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

        View root = inflater.inflate(R.layout.fragment_map, container, false);

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mMap = map.getMap();
        mMap.setMyLocationEnabled(true);

        listView = (ListView) root.findViewById(R.id.list);

        adapter = new InfoAdapter(generateData());
        listView.setAdapter(adapter);

        return root;
    }


    private List<Info> generateData() {
        List<Info> infos = new ArrayList<Info>();

        Info info;
        info = new Info("French Consulate",
                "Portland State University\n1600 SW 4th Avenue, Suite 730\nPortland, Oregon 97201\nUnited States",
                "(+1) (503) 725 9976", 45.5120099, -122.679476);
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(info.latitude, info.longitude))
                .title(info.name));

        infos.add(info);
        for (int i = 0; i < 10; i++) {
            info = new Info("Name" + 1, "Address " + 1, "503-666-8888", 45.5120099, -122.679476);
            infos.add(info);
        }

        return infos;
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

        public void onFragmentInteraction(Uri uri);
    }

}
