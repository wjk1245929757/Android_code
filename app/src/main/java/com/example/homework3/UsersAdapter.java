package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, 0 , users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        User user = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user,parent,false);
        }
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView text1 = (TextView) convertView.findViewById(R.id.text1);
        TextView text2 = (TextView) convertView.findViewById(R.id.text2);

        img.setImageResource(user.src);
        text1.setText(user.name);
        text2.setText(user.desc);

        return convertView;
    }

}
