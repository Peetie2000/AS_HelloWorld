package com.example.patrick.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCounter = 0;
    int clickValue= 1;
    boolean item1 = false;
    TextView tv_clicks;
    Button b_clickButton, b_buyButton, b_shopButton;
    ProgressBar pb_progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_clicks = (TextView) findViewById(R.id.clicks);
        b_clickButton = (Button) findViewById(R.id.clickButton);
        b_buyButton = (Button) findViewById(R.id.buyButton);
        b_shopButton = (Button) findViewById(R.id.shopButton);
        pb_progressBar =(ProgressBar) findViewById(R.id.progressBar);
        pb_progressBar.setMax(100);
        pb_progressBar.setProgress(0);

        b_buyButton.setEnabled(false);

        b_clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter = clickCounter + clickValue;
                tv_clicks.setText("Clicks: " + clickCounter);
                pb_progressBar.setProgress(clickCounter);
                if(clickCounter >= 100){
                    pb_progressBar.setProgress(0);
                    //andere functie bij volle bar
                }
                if(clickCounter >= 10){
                    if(!item1) {
                        b_buyButton.setEnabled(true);
                        item1 = true;

                    }
                }
            }
        });

        b_buyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickValue = clickValue + 2;
                clickCounter = clickCounter - 10;
                tv_clicks.setText("Clicks: " + clickCounter);
                pb_progressBar.setProgress(clickCounter);
                b_buyButton.setText("Max upgrade");
                b_buyButton.setEnabled(false);
            }
        });

        b_shopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Activity2.class));
            }
        });
    }
}
