package com.example.projectadvance1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectadvance1.adapter.AdapterFruits;
import com.example.projectadvance1.object.FragmentFruits;
import com.example.projectadvance1.R;

import java.util.ArrayList;


public class FruitFragment extends Fragment {
    private RecyclerView rcv_fruits;
    private ArrayList<FragmentFruits> arrayList;
    private AdapterFruits adapterFruits;
    private View mView;

    public FruitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fruit, container, false);
        rcv_fruits = mView.findViewById(R.id.rcv_fruits);
        arrayList = new ArrayList<>();

        // ListView Food
        arrayList.add(new FragmentFruits(R.drawable.trainho,"Grape",
                R.drawable.rating_orange_small, "Imported from Japan"));
        arrayList.add(new FragmentFruits(R.drawable.dautay,"Strawberry",
                R.drawable.rating_orange_small, "Imported from Korea"));
        arrayList.add(new FragmentFruits(R.drawable.traicheerry,"Cherry",
                R.drawable.rating_orange_small, "Imported from the US"));
        arrayList.add(new FragmentFruits(R.drawable.traicam,"Orange",
                R.drawable.rating_orange_small, "Imported from China"));

        arrayList.add(new FragmentFruits(R.drawable.trainho,"Grape",
                R.drawable.rating_orange_small, "Imported from Japan"));
        arrayList.add(new FragmentFruits(R.drawable.dautay,"Strawberry",
                R.drawable.rating_orange_small, "Imported from Korea"));
        arrayList.add(new FragmentFruits(R.drawable.traicheerry,"Cherry",
                R.drawable.rating_orange_small, "Imported from the US"));
        arrayList.add(new FragmentFruits(R.drawable.traicam,"Orange",
                R.drawable.rating_orange_small, "Imported from China"));

        arrayList.add(new FragmentFruits(R.drawable.trainho,"Grape",
                R.drawable.rating_orange_small, "Imported from Japan"));
        arrayList.add(new FragmentFruits(R.drawable.dautay,"Strawberry",
                R.drawable.rating_orange_small, "Imported from Korea"));
        arrayList.add(new FragmentFruits(R.drawable.traicheerry,"Cherry",
                R.drawable.rating_orange_small, "Imported from the US"));
        arrayList.add(new FragmentFruits(R.drawable.traicam,"Orange",
                R.drawable.rating_orange_small, "Imported from China"));


        adapterFruits = new AdapterFruits(getContext(), arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                RecyclerView.VERTICAL, false);
        rcv_fruits.setLayoutManager(linearLayoutManager);

        rcv_fruits.setAdapter(adapterFruits);


        return mView;
    }
}