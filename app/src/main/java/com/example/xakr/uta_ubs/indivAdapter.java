package com.example.xakr.uta_ubs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushil on 11/28/2016.
 */

public class indivAdapter extends BaseAdapter {
    private Context context;
    ArrayList<User> users;
    private static LayoutInflater inflater=null;

    public indivAdapter(Context context,ArrayList<User> users){
        this.context=context;
        this.users=users;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listuser, null);

        TextView name = (TextView) convertView.findViewById(R.id.user);
        Button button=(Button) convertView.findViewById(R.id.emailButton);

        User e = new User();
        e = users.get(position);
        name.setText(e.get_fisrtName());
        return convertView;
    }
}
