package com.example.tracomlab.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tracomlab.Adapters.Devices_Adapter;
import com.example.tracomlab.Model_Classes.Devices_Model;
import com.example.tracomlab.R;

import java.util.ArrayList;
import java.util.List;


public class DevicesFragment extends Fragment {

    RecyclerView recyclerView;
    List<Devices_Model> list;
    Devices_Model model;
    Devices_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view;


       view=  inflater.inflate(R.layout.fragment_devices, container, false);



        recyclerView=view.findViewById(R.id.devicesRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        list=new ArrayList<>();

        for (int i=0; i<20; i++){


            model=new Devices_Model("11097WL60001669","IWL220","IWL221-01T1515A","EQUITY BANK AGENCY","2019/10/21");
            list.add(model);



        }

        adapter=new Devices_Adapter(list, container.getContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);





        return view;
    }

}
