package com.salma.counterfragmentfinal;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CounterValueFragment extends Fragment {
    View view;
    TextView counter;
    int counterValue = 0;

    public CounterValueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState!=null)
        {
            counterValue=savedInstanceState.getInt("counterValue");
        }
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_counter_value, container, false);
        counter = view.findViewById(R.id.counterValue);
        if(savedInstanceState!=null)
        {
            counterValue=savedInstanceState.getInt("counterValue");
            counter.setText(String.valueOf(counterValue));
        }
        return view;
    }

    public void increaseCounter(int counterVal) {
        counterValue = counterVal;
        counter.setText(String.valueOf(counterValue));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counterValue", counterValue);
    }
}
