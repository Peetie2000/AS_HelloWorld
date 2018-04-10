package com.example.patrick.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.patrick.helloworld.R.id.clickButton;
import static com.example.patrick.helloworld.R.id.none;
import static com.example.patrick.helloworld.R.id.progressBar;
import static com.example.patrick.helloworld.R.id.returnButton;

public class Activity2 extends AppCompatActivity {

    Button b_returnButton, b_buyButton1, b_buyButton2, b_buyButton3, b_buyButton4, b_mysteryButton;
    TextView tv_textBalance, tv_textDPS;
    int clickCounter;
    int clickValue;
    boolean balancecheck;
    int buttonCheck1;
    int buttonCheck2;
    int buttonCheck3;
    int buttonCheck4;
    int progressBarProgress;
    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        if (buttonCheck1 != 1){
            buttonCheck1 = 0;
        }
        if (buttonCheck2 != 1){
            buttonCheck2 = 0;
        }
        if (buttonCheck3 != 1){
            buttonCheck3 = 0;
        }
        if (buttonCheck4 != 1){
            buttonCheck4 = 0;
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            String clickCounterText = (intent.getStringExtra("clickCounter"));
            String clickValueText = (intent.getStringExtra("clickValue"));
            String buttonCheckValue1 = (intent.getStringExtra("buttonCheck1"));
            String buttonCheckValue2 = (intent.getStringExtra("buttonCheck2"));
            String buttonCheckValue3 = (intent.getStringExtra("buttonCheck3"));
            String buttonCheckValue4 = (intent.getStringExtra("buttonCheck4"));
            String progressbarProgressValue = (intent.getStringExtra("progressbarProgress"));
            clickCounter = Integer.parseInt(clickCounterText);
            clickValue = Integer.parseInt(clickValueText);
            buttonCheck1 = Integer.parseInt(buttonCheckValue1);
            buttonCheck2 = Integer.parseInt(buttonCheckValue2);
            buttonCheck3 = Integer.parseInt(buttonCheckValue3);
            buttonCheck4 = Integer.parseInt(buttonCheckValue4);
            progressBarProgress = Integer.parseInt(progressbarProgressValue);
        }

        b_returnButton = (Button) findViewById(returnButton);
        tv_textBalance = (TextView) findViewById(R.id.textBalance);
        tv_textDPS = (TextView) findViewById(R.id.textDPS);

        b_buyButton1 = (Button) findViewById(R.id.buyButton1);
        b_buyButton2 = (Button) findViewById(R.id.buyButton2);
        b_buyButton3 = (Button) findViewById(R.id.buyButton3);
        b_buyButton4 = (Button) findViewById(R.id.buyButton4);
        b_mysteryButton = (Button) findViewById(R.id.mysteryButton);



        b_buyButton1.setEnabled(false);
        b_buyButton2.setEnabled(false);
        b_buyButton3.setEnabled(false);
        b_buyButton4.setEnabled(false);


        tv_textBalance.setText("" + clickCounter + "");
        tv_textDPS.setText("DPS: " + clickValue + "");

        if (buttonCheck1 == 1){
            b_buyButton1.setVisibility(View.GONE);
        }

        if (buttonCheck2 == 1){
            b_buyButton2.setVisibility(View.GONE);
        }

        if (buttonCheck3 == 1){
            b_buyButton3.setVisibility(View.GONE);
        }
        if (buttonCheck4 == 1){
            b_buyButton4.setVisibility(View.GONE);
        }

        if (clickCounter >= 1000){
            b_mysteryButton.setText("mystery? Cost: " + (clickCounter + 1));
        }


    if (clickCounter >=10) {
        b_buyButton1.setEnabled(true);
        b_buyButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickValue = clickValue + 2;
                clickCounter = clickCounter - 10;
                b_buyButton1.setVisibility(View.GONE);
                b_buyButton1.setEnabled(false);
                tv_textBalance.setText("" + clickCounter + "");
                tv_textDPS.setText("DPS: " + clickValue + "");
                if (clickCounter >= 1000){
                    b_mysteryButton.setText("mystery? Cost: " + (clickCounter + 1));
                }
                buttonCheck1 = 1;
                if(clickCounter >= 10){
                    b_buyButton1.setEnabled(true);
                }
                else {
                    b_buyButton1.setEnabled(false);
                }
                if(clickCounter >= 20){
                    b_buyButton2.setEnabled(true);
                }
                else {
                    b_buyButton2.setEnabled(false);
                }
                if(clickCounter >= 30){
                    b_buyButton3.setEnabled(true);
                }
                else {
                    b_buyButton3.setEnabled(false);
                }
                if(clickCounter >= 40){
                    b_buyButton4.setEnabled(true);
                }
                else{
                    b_buyButton4.setEnabled(false);
                }

            }
        });
    }

        if (clickCounter >=20) {
            b_buyButton2.setEnabled(true);
            b_buyButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickValue = clickValue + 3;
                    clickCounter = clickCounter - 20;
                    b_buyButton2.setVisibility(View.GONE);
                    b_buyButton2.setEnabled(false);
                    tv_textBalance.setText("" + clickCounter + "");
                    tv_textDPS.setText("DPS: " + clickValue + "");
                    if (clickCounter >= 1000){
                        b_mysteryButton.setText("mystery? Cost: " + (clickCounter + 1));
                    }
                    buttonCheck2 = 1;
                    if(clickCounter >= 10){
                        b_buyButton1.setEnabled(true);
                    }
                    else {
                        b_buyButton1.setEnabled(false);
                    }
                    if(clickCounter >= 20){
                        b_buyButton2.setEnabled(true);
                    }
                    else {
                        b_buyButton2.setEnabled(false);
                    }
                    if(clickCounter >= 30){
                        b_buyButton3.setEnabled(true);
                    }
                    else {
                        b_buyButton3.setEnabled(false);
                    }
                    if(clickCounter >= 40){
                        b_buyButton4.setEnabled(true);
                    }
                    else{
                        b_buyButton4.setEnabled(false);
                    }
                }
            });
        }

        if (clickCounter >=30) {
            b_buyButton3.setEnabled(true);
            b_buyButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickValue = clickValue + 4;
                    clickCounter = clickCounter - 30;
                    b_buyButton3.setVisibility(View.GONE);
                    b_buyButton3.setEnabled(false);
                    tv_textBalance.setText("" + clickCounter + "");
                    tv_textDPS.setText("DPS: " + clickValue + "");
                    if (clickCounter >= 1000){
                        b_mysteryButton.setText("mystery? Cost: " + (clickCounter + 1));
                    }
                    buttonCheck3 = 1;
                    if(clickCounter >= 10){
                        b_buyButton1.setEnabled(true);
                    }
                    else {
                        b_buyButton1.setEnabled(false);
                    }
                    if(clickCounter >= 20){
                        b_buyButton2.setEnabled(true);
                    }
                    else {
                        b_buyButton2.setEnabled(false);
                    }
                    if(clickCounter >= 30){
                        b_buyButton3.setEnabled(true);
                    }
                    else {
                        b_buyButton3.setEnabled(false);
                    }
                    if(clickCounter >= 40){
                        b_buyButton4.setEnabled(true);
                    }
                    else{
                        b_buyButton4.setEnabled(false);
                    }
                }
            });
        }

        if (clickCounter >=40) {
            b_buyButton4.setEnabled(true);
            b_buyButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickValue = clickValue + 5;
                    clickCounter = clickCounter - 40;
                    b_buyButton4.setVisibility(View.GONE);
                    b_buyButton4.setEnabled(false);
                    tv_textBalance.setText("" + clickCounter + "");
                    tv_textDPS.setText("DPS: " + clickValue + "");
                    if (clickCounter >= 1000){
                        b_mysteryButton.setText("mystery? Cost: " + (clickCounter + 1));
                    }
                    buttonCheck4 = 1;
                    if(clickCounter >= 10){
                        b_buyButton1.setEnabled(true);
                    }
                    else {
                        b_buyButton1.setEnabled(false);
                    }
                    if(clickCounter >= 20){
                        b_buyButton2.setEnabled(true);
                    }
                    else {
                        b_buyButton2.setEnabled(false);
                    }
                    if(clickCounter >= 30){
                        b_buyButton3.setEnabled(true);
                    }
                    else {
                        b_buyButton3.setEnabled(false);
                    }
                    if(clickCounter >= 40){
                        b_buyButton4.setEnabled(true);
                    }
                    else{
                        b_buyButton4.setEnabled(false);
                    }
                }
            });
        }




        b_returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("clickCounter",Integer.toString(clickCounter));
                intent.putExtra("clickValue", Integer.toString(clickValue));
                intent.putExtra("buttonCheck1", Integer.toString(buttonCheck1));
                intent.putExtra("buttonCheck2", Integer.toString(buttonCheck2));
                intent.putExtra("buttonCheck3", Integer.toString(buttonCheck3));
                intent.putExtra("buttonCheck4", Integer.toString(buttonCheck4));
                intent.putExtra("progressbarProgress", Integer.toString(progressBarProgress));
                startActivity(intent);

            }
        });
    }
}
