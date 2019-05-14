package com.kierrapalmer.victorybudget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CreateBudgetFragment extends Fragment {
    private View rootview;
    private EditText edtEmergency, edtRetirement, edtOtherSavings, edtHousing,
            edtUtilities, edtFood, edtOtherShopping, edtTransportation, edtPhone,
            edtSubscription, edtMisc, edtAutoIns, edtHealthIns, edtAutoLoan,
            edtStudentLoan, edtOtherLoan, edtTuition, edtMaint, edtPet, edtOtherAnnual,
            edtVacation, edtPay, edtOtherIncome;

    private EditText edtMonthSaving, edtMonthExpense, edtMonthAnnual, edtMonthIncome,
            edtRemainingBudget;

    private int monthSaving, monthExpense, monthAnnual, monthIncome, budget;

    public CreateBudgetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_create_budget, container, false);

        TextWatcher watcherMonthSavings = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                addSavings();
                calculateBudget();
            }
        };
        TextWatcher watcherMonthExpense = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                addExpense();
                calculateBudget();
            }
        };
        TextWatcher watcherIncome = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                addIncome();
                calculateBudget();
            }
        };
        TextWatcher watcherAnnual = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                addAnnual();
                calculateBudget();
            }
        };
        TextWatcher watcherBudgetReview = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {     }
        };




        //Savings
        edtEmergency = (EditText) rootview.findViewById(R.id.edtEmergency);
        edtEmergency.addTextChangedListener(watcherMonthSavings);
        edtRetirement = (EditText) rootview.findViewById(R.id.edtRetirement);
        edtRetirement.addTextChangedListener(watcherMonthSavings);
        edtOtherSavings = (EditText) rootview.findViewById(R.id.edtOtherSavings);
        edtOtherSavings.addTextChangedListener(watcherMonthSavings);

        //Expenses
        edtHousing = (EditText) rootview.findViewById(R.id.edtHousing);
        edtHousing.addTextChangedListener(watcherMonthExpense);
        edtUtilities = (EditText) rootview.findViewById(R.id.edtUtilities);
        edtUtilities.addTextChangedListener(watcherMonthExpense);
        edtFood = (EditText) rootview.findViewById(R.id.edtFood);
        edtFood.addTextChangedListener(watcherMonthExpense);
        edtOtherShopping = (EditText) rootview.findViewById(R.id.edtOtherShopping);
        edtOtherShopping.addTextChangedListener(watcherMonthExpense);
        edtTransportation = (EditText) rootview.findViewById(R.id.edtTransportation);
        edtTransportation.addTextChangedListener(watcherMonthExpense);
        edtPhone = (EditText) rootview.findViewById(R.id.edtPhone);
        edtPhone.addTextChangedListener(watcherMonthExpense);
        edtSubscription = (EditText) rootview.findViewById(R.id.edtSubscriptions);
        edtSubscription.addTextChangedListener(watcherMonthExpense);
        edtMisc = (EditText) rootview.findViewById(R.id.edtMisc);
        edtMisc.addTextChangedListener(watcherMonthExpense);

        edtAutoIns = (EditText) rootview.findViewById(R.id.edtAutoInsurance);
        edtAutoIns.addTextChangedListener(watcherMonthExpense);
        edtHealthIns = (EditText) rootview.findViewById(R.id.edtHealth);
        edtHealthIns.addTextChangedListener(watcherMonthExpense);

        edtAutoLoan = (EditText) rootview.findViewById(R.id.edtAutoLoan);
        edtAutoLoan.addTextChangedListener(watcherMonthExpense);
        edtStudentLoan = (EditText) rootview.findViewById(R.id.edtStudentLoan);
        edtStudentLoan.addTextChangedListener(watcherMonthExpense);
        edtOtherLoan = (EditText) rootview.findViewById(R.id.edtOtherLoan);
        edtOtherLoan.addTextChangedListener(watcherMonthExpense);

        //Annual
        edtTuition = (EditText) rootview.findViewById(R.id.edtTuition);
        edtTuition.addTextChangedListener(watcherAnnual);
        edtMaint = (EditText) rootview.findViewById(R.id.edtMaintenance);
        edtMaint.addTextChangedListener(watcherAnnual);
        edtPet = (EditText) rootview.findViewById(R.id.edtPet);
        edtPet.addTextChangedListener(watcherAnnual);
        edtVacation = (EditText) rootview.findViewById(R.id.edtVacation);
        edtVacation.addTextChangedListener(watcherAnnual);
        edtOtherAnnual = (EditText) rootview.findViewById(R.id.edtOtherAnnual);
        edtOtherAnnual.addTextChangedListener(watcherAnnual);

        //Income
        edtPay = (EditText) rootview.findViewById(R.id.edtPay);
        edtPay.addTextChangedListener(watcherIncome);
        edtOtherIncome = (EditText) rootview.findViewById(R.id.edtOtherIncome);
        edtOtherIncome.addTextChangedListener(watcherIncome);

        //Budget Review
        edtMonthSaving = (EditText) rootview.findViewById(R.id.edtSavings);
        edtMonthSaving.addTextChangedListener(watcherBudgetReview);
        edtMonthExpense = (EditText) rootview.findViewById(R.id.edtExpenses);
        edtMonthExpense.addTextChangedListener(watcherBudgetReview);
        edtMonthAnnual = (EditText) rootview.findViewById(R.id.edtAnnual);
        edtMonthAnnual.addTextChangedListener(watcherBudgetReview);
        edtMonthIncome = (EditText) rootview.findViewById(R.id.edtIncome);
        edtMonthIncome.addTextChangedListener(watcherBudgetReview);
        edtRemainingBudget = (EditText) rootview.findViewById(R.id.edtRemainingBudget);
        edtRemainingBudget.addTextChangedListener(watcherBudgetReview);









        return rootview;
    }


    public void addSavings(){
        monthSaving = 0;
        monthSaving += tryParse(edtEmergency.getText().toString());
        monthSaving += tryParse(edtRetirement.getText().toString());
        monthSaving += tryParse(edtOtherSavings.getText().toString());
        edtMonthSaving.setText(Integer.toString(monthSaving));
    }
    public void addExpense(){
        monthExpense = 0;
        monthExpense += tryParse(edtHousing.getText().toString());
        monthExpense += tryParse(edtUtilities.getText().toString());
        monthExpense += tryParse(edtFood.getText().toString());
        monthExpense += tryParse(edtOtherShopping.getText().toString());
        monthExpense += tryParse(edtTransportation.getText().toString());
        monthExpense += tryParse(edtPhone.getText().toString());
        monthExpense += tryParse(edtSubscription.getText().toString());
        monthExpense += tryParse(edtMisc.getText().toString());
        monthExpense += tryParse(edtAutoIns.getText().toString());
        monthExpense += tryParse(edtHealthIns.getText().toString());
        monthExpense += tryParse(edtAutoLoan.getText().toString());
        monthExpense += tryParse(edtStudentLoan.getText().toString());
        monthExpense += tryParse(edtOtherLoan.getText().toString());

        edtMonthExpense.setText(Integer.toString(monthExpense));
    }
    public void addAnnual(){
        monthAnnual = 0;
        monthAnnual += tryParse(edtTuition.getText().toString());
        monthAnnual += tryParse(edtMaint.getText().toString());
        monthAnnual += tryParse(edtPet.getText().toString());
        monthAnnual += tryParse(edtVacation.getText().toString());
        monthAnnual += tryParse(edtOtherAnnual.getText().toString());

        int dividedAnnual = monthAnnual/12;
        edtMonthAnnual.setText(Integer.toString(dividedAnnual));
    }
    public void addIncome(){
        monthIncome = 0;
        monthIncome += tryParse(edtPay.getText().toString());
        monthIncome += tryParse(edtOtherIncome.getText().toString());
        edtMonthIncome.setText(Integer.toString(monthIncome));
    }

    public void calculateBudget(){
        budget= monthIncome - (monthSaving + monthExpense + (monthAnnual/12));
        edtRemainingBudget.setText(Integer.toString(budget));
    }


    public static int tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            Log.d("test", "Failed to parse: " + text);

            return 0;
        }
    }















    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp1 = getActivity().getPreferences(Context.MODE_PRIVATE);

        //retrieve the shared preferences for each of the editText boxes
        //and set box value
        String emergency = sp1.getString("emergency", "0");
        String retirement = sp1.getString("retirement", "0");
        String otherSavings = sp1.getString("otherSavings", "0");
        String housing = sp1.getString("housing", "0");
        String utilities = sp1.getString("utilities", "0");
        String food = sp1.getString("food", "0");
        String otherShopping = sp1.getString("otherShopping", "0");
        String transportation = sp1.getString("transportation", "0");
        String phone = sp1.getString("phone", "0");
        String autoIns = sp1.getString("autoIns", "0");
        String healthIns = sp1.getString("healthIns", "0");
        String autoLoan = sp1.getString("autoLoan", "0");
        String studentLoan = sp1.getString("studentLoan", "0");
        String otherLoan = sp1.getString("otherLoan", "0");
        String subscription = sp1.getString("subscription", "0");
        String misc = sp1.getString("misc", "0");
        String tuition = sp1.getString("tuition", "0");
        String maint = sp1.getString("maint", "0");
        String pet = sp1.getString("pet", "0");
        String vacation = sp1.getString("vacation", "0");
        String otherAnnual = sp1.getString("otherAnnual", "0");
        String pay = sp1.getString("pay", "0");
        String otherIncome = sp1.getString("otherIncome", "0");
        edtEmergency.setText(emergency);
        edtRetirement.setText(retirement);
        edtOtherSavings.setText(otherSavings);
        edtHousing.setText(housing);
        edtUtilities.setText(utilities);
        edtFood.setText(food);
        edtOtherShopping.setText(otherShopping);
        edtTransportation.setText(transportation);
        edtPhone.setText(phone);
        edtAutoIns.setText(autoIns);
        edtHealthIns.setText(healthIns);
        edtAutoLoan.setText(autoLoan);
        edtStudentLoan.setText(studentLoan);
        edtOtherLoan.setText(otherLoan);
        edtSubscription.setText(subscription);
        edtMisc.setText(misc);
        edtTuition.setText(tuition);
        edtMaint.setText(maint);
        edtPet.setText(pet);
        edtVacation.setText(vacation);
        edtOtherAnnual.setText(otherAnnual);
        edtPay.setText(pay);
        edtOtherIncome.setText(otherIncome);

    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sp1 = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor spEdit1 = sp1.edit();

        //Create shared preferences for  each editText box
        spEdit1.putString("emergency", edtEmergency.getText().toString());
        spEdit1.putString("retirement", edtRetirement.getText().toString());
        spEdit1.putString("otherSavings", edtOtherSavings.getText().toString());
        spEdit1.putString("housing", edtHousing.getText().toString());
        spEdit1.putString("utilities", edtUtilities.getText().toString());
        spEdit1.putString("food", edtFood.getText().toString());
        spEdit1.putString("otherShopping", edtOtherShopping.getText().toString());
        spEdit1.putString("transportation", edtTransportation.getText().toString());
        spEdit1.putString("phone", edtPhone.getText().toString());
        spEdit1.putString("autoIns", edtAutoIns.getText().toString());
        spEdit1.putString("healthIns", edtHealthIns.getText().toString());
        spEdit1.putString("studentLoan", edtStudentLoan.getText().toString());
        spEdit1.putString("autoLoan", edtAutoLoan.getText().toString());
        spEdit1.putString("otherLoan", edtOtherLoan.getText().toString());
        spEdit1.putString("subscription", edtSubscription.getText().toString());
        spEdit1.putString("misc", edtMisc.getText().toString());
        spEdit1.putString("tuition", edtTuition.getText().toString());
        spEdit1.putString("maint", edtMaint.getText().toString());
        spEdit1.putString("pet", edtPet.getText().toString());
        spEdit1.putString("vacation", edtVacation.getText().toString());
        spEdit1.putString("otherAnnual", edtOtherAnnual.getText().toString());
        spEdit1.putString("otherAnnual", edtOtherAnnual.getText().toString());
        spEdit1.putString("pay", edtPay.getText().toString());
        spEdit1.putString("otherIncome", edtOtherIncome.getText().toString());

        spEdit1.commit();
    }
}
