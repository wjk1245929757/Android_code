package com.example.wjk;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity{
    private static final String TAG = "SecondActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"It is create!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button mybtn = findViewById(R.id.button_1);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Button has been clicked!");
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
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
