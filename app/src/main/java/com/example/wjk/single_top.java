package com.example.wjk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class single_top extends AppCompatActivity {

    private static final String TAG = "single_top";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"It is create!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top);

        String myprocessname = getApplicationInfo().processName;
        String activityinfo = this.toString();
        long currentid = Thread.currentThread().getId();
        TextView mytext = findViewById(R.id.text_1);
        mytext.append("getApplicationInfo().processName = " + myprocessname);
        mytext.append("\nActivity.toString = "+ activityinfo);
        mytext.append("\nThread.currentThread().getId() = "+ currentid);

        Button mybtn = findViewById(R.id.button_1);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(single_top.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button mybtn1 = findViewById(R.id.button_2);
        mybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(single_top.this,single_top.class);
                startActivity(intent);
            }
        });
        Button mybtn2 = findViewById(R.id.button_3);
        mybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
//                setContentView(R.layout.second_activity);
                Intent intent = new Intent(single_top.this,single_top2.class);
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
