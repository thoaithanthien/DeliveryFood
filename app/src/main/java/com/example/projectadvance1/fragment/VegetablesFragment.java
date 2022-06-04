package com.example.projectadvance1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectadvance1.adapter.AdapterVegetables;
import com.example.projectadvance1.object.FragmentVegetables;
import com.example.projectadvance1.R;

import java.util.ArrayList;


public class VegetablesFragment extends Fragment {

    private RecyclerView rcv_vegetables;
    private ArrayList<FragmentVegetables> arrayList;
    private AdapterVegetables adapterVegetables;
    private View mView;

    public VegetablesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_vegetables, container, false);
        rcv_vegetables = mView.findViewById(R.id.rcv_vegetables);
        arrayList = new ArrayList<>();

        // ListView Food
        arrayList.add(new FragmentVegetables(R.drawable.xalach,"Salad",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.khoaitay,"Potato",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bido,"Pumpkin",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bidao,"Squash",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.carot,"Carrot",
                R.drawable.rating_orange_small, "Vietnam"));

        arrayList.add(new FragmentVegetables(R.drawable.xalach,"Salad",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.khoaitay,"Potato",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bido,"Pumpkin",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bidao,"Squash",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.carot,"Carrot",
                R.drawable.rating_orange_small, "Vietnam"));

        arrayList.add(new FragmentVegetables(R.drawable.xalach,"Salad",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.khoaitay,"Potato",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bido,"Pumpkin",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.bidao,"Squash",
                R.drawable.rating_orange_small, "Vietnam"));
        arrayList.add(new FragmentVegetables(R.drawable.carot,"Carrot",
                R.drawable.rating_orange_small, "Vietnam"));

        adapterVegetables = new AdapterVegetables(getContext(), arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                RecyclerView.VERTICAL, false);
        rcv_vegetables.setLayoutManager(linearLayoutManager);

        rcv_vegetables.setAdapter(adapterVegetables);


        return mView;
    }
}