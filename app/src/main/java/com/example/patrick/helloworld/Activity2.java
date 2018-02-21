package com.example.patrick.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.patrick.helloworld.R.id.clickButton;
import static com.example.patrick.helloworld.R.id.returnButton;

public class Activity2 extends AppCompatActivity {

    Button b_returnButton, b_buyButton;
    TextView tv_clickView;
    int clickCounter;
    int clickValue;
    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        b_returnButton = (Button) findViewById(returnButton);
        b_buyButton = (Button) findViewById(R.id.buyButton);
        tv_clickView = (TextView) findViewById(R.id.clickView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            String clickCounterText = (intent.getStringExtra("clickCounter"));
            String clickValueText = (intent.getStringExtra("clickValue"));
            clickCounter = Integer.parseInt(clickCounterText);
            clickValue = Integer.parseInt(clickValueText);
        }


        tv_clickView.setText("wow " + clickCounter + " " + clickValue);


        b_buyButton.setEnabled(false);
    if (clickCounter >=10) {
        b_buyButton.setEnabled(true);
        b_buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickValue = clickValue + 2;
                clickCounter = clickCounter - 10;

                b_buyButton.setText("Max upgrade");
                b_buyButton.setEnabled(false);
            }
        });
    }
        b_returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("clickCounter",Integer.toString(clickCounter));
                intent.putExtra("clickValue", Integer.toString(clickValue));
                startActivity(intent);

            }
        });
    }
}
