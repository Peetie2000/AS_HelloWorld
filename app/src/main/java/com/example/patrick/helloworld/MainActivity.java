package com.example.patrick.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCounter;
    int clickValue;

    boolean item1 = false;
    TextView tv_clicks;
    Button b_clickButton, b_shopButton;
    ProgressBar pb_progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_clicks = (TextView) findViewById(R.id.clicks);
        b_clickButton = (Button) findViewById(R.id.clickButton);

        b_shopButton = (Button) findViewById(R.id.shopButton);
        pb_progressBar =(ProgressBar) findViewById(R.id.progressBar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            String clickCounterText = (intent.getStringExtra("clickCounter"));
            String clickValueText = (intent.getStringExtra("clickValue"));
            clickCounter = Integer.parseInt(clickCounterText);
            clickValue = Integer.parseInt(clickValueText);
        }
        else{
            clickValue = 1;
        }

        pb_progressBar.setMax(100);

        pb_progressBar.setProgress(clickCounter);
        tv_clicks.setText("Clicks: " + clickCounter);

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

            }
        });

        b_shopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("clickCounter",Integer.toString(clickCounter));
                intent.putExtra("clickValue", Integer.toString(clickValue));
                startActivity(intent);
            }
        });


    }
}
