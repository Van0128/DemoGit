package com.example.anhchan.taskone;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.anhchan.taskone.R.id.SpnCtgrExp;

public class Hello_World extends AppCompatActivity {
    ImageButton ImgbtnMenuBar;
    ImageButton ImgbtnUser;
    Spinner SpnCtgrExp;
    Spinner SpnCtgrAcc;
    Spinner SpnCtgrHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello__world);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_action_bar);
        ImgbtnMenuBar = (ImageButton) findViewById(R.id.ImgbtnMenuBar);
        ImgbtnUser = (ImageButton) findViewById(R.id.ImgbtnUser);
        SpnCtgrExp = (Spinner) findViewById(R.id.SpnCtgrExp);
        SpnCtgrAcc = (Spinner) findViewById(R.id.SpnCtgrAcc);
        SpnCtgrHeading = (Spinner) findViewById(R.id.SpnCtgrHeading);
        ArrayAdapter<CharSequence> headingAdapter = ArrayAdapter
                .createFromResource(this, R.array.Heading,
                        android.R.layout.simple_spinner_item);
        headingAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpnCtgrHeading.setAdapter(headingAdapter);

        ImgbtnMenuBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hello_World.this, "Menu", Toast.LENGTH_LONG).show();
            }
        });
        ImgbtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hello_World.this, "User", Toast.LENGTH_LONG).show();
            }
        });
        ArrayAdapter<CharSequence> expenseAdapter = ArrayAdapter
                .createFromResource(this, R.array.Category_Expenses,
                        android.R.layout.simple_spinner_item);
        expenseAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpnCtgrExp.setAdapter(expenseAdapter);

        ArrayAdapter<CharSequence> accountAdapter = ArrayAdapter
                .createFromResource(this, R.array.Account,
                        android.R.layout.simple_spinner_item);
        accountAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpnCtgrAcc.setAdapter(accountAdapter);
    }


}
