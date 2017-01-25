package com.example.sergey.lesson13_asynctask;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private final Handler handler = new Handler();

    public SecondActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.textView2);

    }

    public void onClick(View view) {
        Thread thread=new Thread();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 30; i++) {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                                textView.setText(i+"");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                    }

            }
        });
thread.start();
    }



    private class MyAsyncTask extends AsyncTask<String, Integer, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

    }
}
