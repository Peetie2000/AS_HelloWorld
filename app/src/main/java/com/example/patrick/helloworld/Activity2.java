package com.example.patrick.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.patrick.helloworld.R.id.clickButton;
import static com.example.patrick.helloworld.R.id.none;
import static com.example.patrick.helloworld.R.id.returnButton;

public class Activity2 extends AppCompatActivity {

    Button b_returnButton, b_buyButton1, b_buyButton2, b_buyButton3, b_buyButton4, b_buyButton5, b_buyButton6, b_buyButton7, b_buyButton8;
    TextView tv_textBalance, tv_textDPS;
    int clickCounter;
    int clickValue;
    boolean balancecheck;
    int buttonCheck1;
    int buttonCheck2;
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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            String clickCounterText = (intent.getStringExtra("clickCounter"));
            String clickValueText = (intent.getStringExtra("clickValue"));
            String buttonCheckValue1 = (intent.getStringExtra("buttonCheck1"));
            String buttonCheckValue2 = (intent.getStringExtra("buttonCheck2"));
            clickCounter = Integer.parseInt(clickCounterText);
            clickValue = Integer.parseInt(clickValueText);
            buttonCheck1 = Integer.parseInt(buttonCheckValue1);
            buttonCheck2 = Integer.parseInt(buttonCheckValue2);
        }

        b_returnButton = (Button) findViewById(returnButton);
        tv_textBalance = (TextView) findViewById(R.id.textBalance);
        tv_textDPS = (TextView) findViewById(R.id.textDPS);

        b_buyButton1 = (Button) findViewById(R.id.buyButton1);
        b_buyButton2 = (Button) findViewById(R.id.buyButton2);
        b_buyButton3 = (Button) findViewById(R.id.buyButton3);
        b_buyButton4 = (Button) findViewById(R.id.buyButton4);
        b_buyButton5 = (Button) findViewById(R.id.buyButton5);
        b_buyButton6 = (Button) findViewById(R.id.buyButton6);
        b_buyButton7 = (Button) findViewById(R.id.buyButton7);
        b_buyButton8 = (Button) findViewById(R.id.buyButton8);

        b_buyButton1.setEnabled(false);
        b_buyButton2.setEnabled(false);
        b_buyButton3.setEnabled(false);
        b_buyButton4.setEnabled(false);
        b_buyButton5.setVisibility(View.GONE);
        b_buyButton6.setVisibility(View.GONE);
        b_buyButton7.setVisibility(View.GONE);
        b_buyButton8.setVisibility(View.GONE);

        tv_textBalance.setText("" + clickCounter + "");
        tv_textDPS.setText("DPS: " + clickValue + "");
    if (buttonCheck1 == 1){
        b_buyButton1.setVisibility(View.GONE);
    }

        if (buttonCheck2 == 1){
            b_buyButton2.setVisibility(View.GONE);
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
                buttonCheck1 = 1;

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
                    buttonCheck2 = 1;
                }
            });
        }

        if (clickCounter >=30) {
            b_buyButton3.setEnabled(true);
            b_buyButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickValue = clickValue + 2;
                    clickCounter = clickCounter - 10;
                    b_buyButton3.setVisibility(View.GONE);
                    b_buyButton3.setEnabled(false);
                    tv_textBalance.setText("" + clickCounter + "");
                    tv_textDPS.setText("DPS: " + clickValue + "");
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
                startActivity(intent);

            }
        });
    }
}
