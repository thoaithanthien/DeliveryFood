package com.example.projectadvance1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectadvance1.adapter.AdapterCakes;
import com.example.projectadvance1.object.FragmentCakes;
import com.example.projectadvance1.R;

import java.util.ArrayList;


public class CakesFragment extends Fragment {

    private RecyclerView rcv_cakes;
    private ArrayList<FragmentCakes> arrayList;
    private AdapterCakes adapterCakes;
    private View mView;


    public CakesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cakes, container, false);
        rcv_cakes = mView.findViewById(R.id.rcv_cakes);
        arrayList = new ArrayList<>();

        // ListView Food
        arrayList.add(new FragmentCakes(R.drawable.banhkem,"Cheesecake",
                R.drawable.rating_orange_small, "Cream cheese cake made from milk"));
        arrayList.add(new FragmentCakes(R.drawable.banhhampuger,"Hamburger",
                R.drawable.rating_orange_small, "Made from many different materials"));
        arrayList.add(new FragmentCakes(R.drawable.banhbao,"Dumplings",
                R.drawable.rating_orange_small, "Made from cassava flour"));
        arrayList.add(new FragmentCakes(R.drawable.banhsocola,"Chocolate",
                R.drawable.rating_orange_small, "Made from cocoa"));

        arrayList.add(new FragmentCakes(R.drawable.banhkem,"Cheesecake",
                R.drawable.rating_orange_small, "Cream cheese cake made from milk"));
        arrayList.add(new FragmentCakes(R.drawable.banhhampuger,"Hamburger",
                R.drawable.rating_orange_small, "Made from many different materials"));
        arrayList.add(new FragmentCakes(R.drawable.banhbao,"Dumplings",
                R.drawable.rating_orange_small, "Made from cassava flour"));
        arrayList.add(new FragmentCakes(R.drawable.banhsocola,"Chocolate",
                R.drawable.rating_orange_small, "Made from cocoa"));

        arrayList.add(new FragmentCakes(R.drawable.banhkem,"Cheesecake",
                R.drawable.rating_orange_small, "Cream cheese cake made from milk"));
        arrayList.add(new FragmentCakes(R.drawable.banhhampuger,"Hamburger",
                R.drawable.rating_orange_small, "Made from many different materials"));
        arrayList.add(new FragmentCakes(R.drawable.banhbao,"Dumplings",
                R.drawable.rating_orange_small, "Made from cassava flour"));
        arrayList.add(new FragmentCakes(R.drawable.banhsocola,"Chocolate",
                R.drawable.rating_orange_small, "Made from cocoa"));

        adapterCakes = new AdapterCakes(getContext(), arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                RecyclerView.VERTICAL, false);
        rcv_cakes.setLayoutManager(linearLayoutManager);

        rcv_cakes.setAdapter(adapterCakes);


        return mView;
    }
}