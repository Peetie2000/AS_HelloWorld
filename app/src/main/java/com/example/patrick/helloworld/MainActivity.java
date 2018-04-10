package com.example.patrick.helloworld;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCounter;
    int clickValue;
    int buttonCheck1;
    int buttonCheck2;
    int buttonCheck3;
    int buttonCheck4;
    int progressbarProgress;

    boolean item1 = false;
    TextView tv_clicks;
    Button b_clickButton, b_shopButton;
    ProgressBar pb_progressBar;
    MediaPlayer mp_knopgeluid, mp_100geluid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp_knopgeluid = (MediaPlayer) MediaPlayer.create(this, R.raw.biem);
        mp_100geluid = (MediaPlayer) MediaPlayer.create(this, R.raw.biem2);
        tv_clicks = (TextView) findViewById(R.id.clicks);
        b_clickButton = (Button) findViewById(R.id.clickButton);
        b_shopButton = (Button) findViewById(R.id.shopButton);
        pb_progressBar =(ProgressBar) findViewById(R.id.progressBar);



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
            progressbarProgress = Integer.parseInt(progressbarProgressValue);
        }
        else{
            clickValue = 1;
        }

        pb_progressBar.setMax(100);

        pb_progressBar.setProgress(progressbarProgress);

        tv_clicks.setText("Clicks: " + clickCounter);


        b_clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickCounter = clickCounter + clickValue;
                progressbarProgress = progressbarProgress + 1;
                tv_clicks.setText("Clicks: " + clickCounter);

                pb_progressBar.setProgress(progressbarProgress);

                if(progressbarProgress == 100){
                    clickValue = clickValue + 1;
                    progressbarProgress = 0;
                    pb_progressBar.setProgress(progressbarProgress);
                    mp_100geluid.start();
                }





                mp_knopgeluid.start();

            }
        });

        b_shopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("clickCounter",Integer.toString(clickCounter));
                intent.putExtra("clickValue", Integer.toString(clickValue));
                intent.putExtra("buttonCheck1", Integer.toString(buttonCheck1));
                intent.putExtra("buttonCheck2", Integer.toString(buttonCheck2));
                intent.putExtra("buttonCheck3", Integer.toString(buttonCheck3));
                intent.putExtra("buttonCheck4", Integer.toString(buttonCheck4));
                intent.putExtra("progressbarProgress", Integer.toString(progressbarProgress));
                startActivity(intent);
            }
        });


    }
}
