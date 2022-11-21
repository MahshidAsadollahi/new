package com.example.helpmelogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    CardView D1, D2, D3, D4, D5, D6;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        D1 = view.findViewById(R.id.d1);
        D2 = view.findViewById(R.id.d2);
        D3 = view.findViewById(R.id.d3);
        D4= view.findViewById(R.id.d4);
        D5 = view.findViewById(R.id.d5);
        D6 = view.findViewById(R.id.d6);

        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment seventhFrag = new seventh();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, seventhFrag).commit();
            }
        });

        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment sixthFrag = new sixth();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, sixthFrag).commit();
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fifthFrag = new fifth();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, fifthFrag).commit();
            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment forthFrag = new forth();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, forthFrag).commit();
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment thirdFrag = new third();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, thirdFrag).commit();

            }
        });
        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new second();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentContainer, secondFrag).commit();
            }


        });



        return view;
    }}
