package com.example.sergey.lesson13_asynctask;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {
    private TextView textStart, textTest;
    private Handler handler;
    private Button buttonStart, buttonTest;
    private int testCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textStart = (TextView) findViewById(R.id.textViewStart);
        textTest = (TextView) findViewById(R.id.textViewTest);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonTest = (Button) findViewById(R.id.buttonTest);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                textStart.setText("Счетчик" + msg.what);
                if (msg.what == 30) {
                    buttonStart.setEnabled(true);
                    Toast.makeText(SecondActivity.this, "Готово", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart:
                buttonStart.setEnabled(false);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 30; i++) {
                            sleep(2);

                            handler.sendEmptyMessage(i);
                        }
                    }
                });
                thread.start();
                break;
            case R.id.buttonTest:
                Log.d("TAG", "test");
                textTest.setText("count test: " + testCount++);
                break;
            default:
                break;
        }

    }

    private void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
