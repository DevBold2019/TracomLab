package com.example.tracomlab.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tracomlab.Adapters.Contacts_Adapter;
import com.example.tracomlab.Model_Classes.Contacts_Model;
import com.example.tracomlab.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment {

    RecyclerView recyclerView;
    List<Contacts_Model> list;
    Contacts_Adapter adapter;
    Contacts_Model model;
    BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;

        view = inflater.inflate(R.layout.fragment_communication, container, false);

        recyclerView=view.findViewById(R.id.contactRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);

        bottomSheetDialog=new BottomSheetDialog(getContext());
        View layout=LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout,container,false);
        bottomSheetDialog.setContentView(layout);



        list=new ArrayList<>();

        for (int i=0; i<10; i++){


            model=new Contacts_Model("0723451234","ephantus@tracom.co.ke");


            list.add(model);

        }


        adapter=new Contacts_Adapter(list,getContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

      adapter.setOnItemClickListener(new Contacts_Adapter.OnItemClickListener() {

          @Override
          public void onItemClick(CardView cardView, View view, final Contacts_Model model, int position) {



              bottomSheetDialog.show();
              TextView call=bottomSheetDialog.findViewById(R.id.callEng);
              TextView email=bottomSheetDialog.findViewById(R.id.emailEng);
              TextView sms=bottomSheetDialog.findViewById(R.id.smsEng);

              if (call != null){

                  call.setOnClickListener(new View.OnClickListener() {

                      @Override
                      public void onClick(View view) {
                          Toast.makeText(getContext(),"calling "+model.getPhoneNumber(),Toast.LENGTH_LONG).show();
                          bottomSheetDialog.dismiss();

                      }
                  });


              }

              if (email != null){

                  email.setOnClickListener(new View.OnClickListener() {

                      @Override
                      public void onClick(View view) {
                          Toast.makeText(getContext(),"You're about to email "+model.getEmailAddress(),Toast.LENGTH_LONG).show();
                          bottomSheetDialog.dismiss();

                      }
                  });


              }


              if (sms != null){

                  sms.setOnClickListener(new View.OnClickListener() {

                      @Override
                      public void onClick(View view) {
                          Toast.makeText(getContext(),"Sms to "+model.getPhoneNumber(),Toast.LENGTH_LONG).show();
                          bottomSheetDialog.dismiss();

                      }
                  });


              }




          }
      });








        return view;
    }

}
