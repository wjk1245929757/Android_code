package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<User> arrayOfUsers;
    private UsersAdapter adapter;

    private ImageView myImg;
    private TextView myText1;
    private TextView myText2;

    private int mySrc [] = {
            R.drawable.warbear,
            R.drawable.fighter,
            R.drawable.aircraft_carrier,
            R.drawable.helicopter,
            R.drawable.pk,
            R.drawable.tank,
            R.drawable.jiangjun,
            R.drawable.tiangou
    };
    private String myName [] = {
            "战熊",
            "阿波罗战机",
            "航空母舰",
            "冷冻直升机",
            "维和步兵",
            "守护者坦克",
            "将军幕府战列舰",
            "天狗机器人"
    };
    private String myDesc [] = {
            "苏联-先进反步兵单位",
            "盟军-先进歼击机",
            "盟军-可发射一枚断电导弹",
            "盟军-特殊技能可缩小敌方单位",
            "盟军-先进反步兵，可使用防爆盾",
            "盟军-特殊技能可发现敌方装甲弱点",
            "帝国-可使用技能撞沉对方",
            "帝国-可变换为对空的天狗机甲"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        arrayOfUsers = new ArrayList<User>();
        adapter = new UsersAdapter(this, arrayOfUsers);
        listView.setAdapter(adapter);

        for (int i=0 ; i < 8 ; i++){
            User newUser = new User(mySrc[i],myName[i],myDesc[i]);
            adapter.add(newUser);
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int position = i;
                myImg = (ImageView)view.findViewById(R.id.img);
                myImg.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String temp = "图片---";
                        temp = temp +myName[position];
                        Toast toast = Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT);
////                        toast.setGravity(Gravity.CENTER,0,0);
//                        ImageView imageCodeProject = new ImageView(getApplicationContext());
//                        imageCodeProject.setImageResource(mySrc[position]);
                        toast.show();
                    }
                });
                myText1 = (TextView)view.findViewById(R.id.text1);
                myText1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(MainActivity.this, myText1.getText(), Toast.LENGTH_SHORT);
//                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                });
                myText2 = (TextView)view.findViewById(R.id.text2);
                myText2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(MainActivity.this, myText2.getText(), Toast.LENGTH_SHORT);
//                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                });
            }
        });

    }

}