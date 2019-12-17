package com.example.tracomlab.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tracomlab.Adapters.Drop_Off_Adapter;
import com.example.tracomlab.Model_Classes.Drop_Off_Model;
import com.example.tracomlab.R;

import java.util.ArrayList;
import java.util.List;


public class DeliveryFragment extends Fragment {

    RecyclerView recyclerView;
    List<Drop_Off_Model> list;
    Drop_Off_Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view= inflater.inflate(R.layout.fragment_delivery, container, false);



        recyclerView=view.findViewById(R.id.deliveryRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);


        list=new ArrayList<>();

        for (int i=0; i< 50; i++){

          Drop_Off_Model model=new Drop_Off_Model("12345678","Engineer Ephantus","500","12:00 PM");

            list.add(model);


        }

        adapter=new Drop_Off_Adapter(list,getContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);




        return view;
    }

}
