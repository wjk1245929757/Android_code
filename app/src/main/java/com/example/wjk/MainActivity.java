package com.example.wjk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"It is create!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String processname = getApplicationInfo().processName;
        String activityinfo = this.toString();
        long currentid = Thread.currentThread().getId();
        TextView mytext = findViewById(R.id.text_1);
        mytext.setText("getApplicationInfo().processName = " + processname);
        mytext.append("\nActivity.toString = "+ activityinfo);
        mytext.append("\nThread.currentThread().getId() = "+ currentid);

        Button mybtn = findViewById(R.id.button_1);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        Button mybtn2 = findViewById(R.id.button_2);
        mybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,standard_mode.class);
                startActivity(intent);
            }
        });

        Button mybtn3 = findViewById(R.id.button_3);
        mybtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,single_top.class);
                startActivity(intent);
            }
        });

        Button mybtn4 = findViewById(R.id.button_4);
        mybtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,single_task.class);
                startActivity(intent);
            }
        });

        Button mybtn5 = findViewById(R.id.button_5);
        mybtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,single_instance.class);
                startActivity(intent);
            }
        });

        Button mybtn6 = findViewById(R.id.button_6);
        mybtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        Log.d(TAG,"It is start!");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"It is stop!");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"It is destory!");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"It is pause!");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"It is resume!");
        super.onResume();
    }
}