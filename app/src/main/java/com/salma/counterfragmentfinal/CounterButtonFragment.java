package com.salma.counterfragmentfinal;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CounterButtonFragment extends Fragment {
    View view;
    Button counterBtn;
    int counter = 0;
    Communicator communicator;

    public CounterButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null)
        {
            counter=savedInstanceState.getInt("counter");
        }
        communicator = (Communicator) getActivity();
        view = inflater.inflate(R.layout.fragment_counter_button, container, false);

        counterBtn = view.findViewById(R.id.BtnCounter);
        counterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                communicator.manageCounter(counter);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }
}
