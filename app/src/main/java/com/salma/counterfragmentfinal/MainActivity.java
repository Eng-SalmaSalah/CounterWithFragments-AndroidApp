package com.salma.counterfragmentfinal;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {
    FragmentManager fragmentManager;
    CounterButtonFragment counterButtonFragment;
    CounterValueFragment counterValueFragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (savedInstanceState == null) {
            counterButtonFragment = new CounterButtonFragment();
            counterValueFragment = new CounterValueFragment();
            fragmentTransaction.add(R.id.container_counterBtn, counterButtonFragment, "counterButtonFragment");
            fragmentTransaction.add(R.id.container_counterVal, counterValueFragment, "counterValueFragment");
            fragmentTransaction.commit();
        } else {
            counterValueFragment = (CounterValueFragment) fragmentManager.findFragmentByTag("counterValueFragment");
            counterButtonFragment = (CounterButtonFragment) fragmentManager.findFragmentByTag("counterButtonFragment");
        }
    }

    @Override
    public void manageCounter(int counterVal) {
        counterValueFragment = (CounterValueFragment) getSupportFragmentManager().findFragmentByTag("counterValueFragment");
        if (counterValueFragment != null)
            counterValueFragment.increaseCounter(counterVal);
    }
}
