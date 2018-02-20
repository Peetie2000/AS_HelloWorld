package com.example.patrick.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickcounter = 0;
    TextView tv_clicks, toetje;
    Button b_clickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_clicks = (TextView) findViewById(R.id.clicks);
        b_clickbutton = (Button) findViewById(R.id.clickbutton);
        b_clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcounter++;
                tv_clicks.setText(clickcounter);
            }
        });
    }
}
