package com.example.android.automatic_sliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RelativeLayout myLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLay = (RelativeLayout) findViewById(R.id.mylay);

        Timer m = new Timer();
        MyTimer mt = new MyTimer();

        m.schedule(mt,4000,4000);

    }

    class MyTimer extends TimerTask
    {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                Random r  = new Random();

                public void run()
                {
                    int Images[] = { R.drawable.i, R.drawable.b,R.drawable.c, R.drawable.d,R.drawable.a, R.drawable.f };
                    myLay.setBackgroundResource(Images[getRandomNumber()]);
                }

                private int getRandomNumber()
                {
                    return new Random().nextInt(5);
                }

            });

        }
    }

}
