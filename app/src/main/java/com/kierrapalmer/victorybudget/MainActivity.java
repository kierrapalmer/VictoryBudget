package com.kierrapalmer.victorybudget;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private CreateBudgetFragment fragBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragCreateBudget, new CreateBudgetFragment(), "fragCreateBudget")
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        fragBudget = (CreateBudgetFragment) getSupportFragmentManager()
                .findFragmentByTag("fragCreateBudget");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause");
    }

}
