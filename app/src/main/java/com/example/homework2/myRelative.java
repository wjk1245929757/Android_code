package com.example.homework2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myRelative extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myrelative);

        Button mybutton1 = findViewById(R.id.mybutton1);
        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(myRelative.this,myTable.class);
                startActivity(login);
            }
        });

    }

}
