package com.example.patrick.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCounter = 0;
    int clickValue= 1;
    TextView tv_clicks;
    Button b_clickbutton, b_buybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_clicks = (TextView) findViewById(R.id.clicks);
        b_clickbutton = (Button) findViewById(R.id.clickbutton);
        b_clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter = clickCounter + clickValue;
                tv_clicks.setText("Clicks: " + clickCounter);

                if(clickCounter >= 10){
                    b_buybutton.setEnabled(true);

                }
            }
        });

            b_buybutton.setEnabled(false);



        b_buybutton = (Button) findViewById(R.id.buybutton);
        b_buybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickValue = clickValue + 2;
                clickCounter = clickCounter - 10;
                b_buybutton.setEnabled(false);
            }
        });
    }
}
