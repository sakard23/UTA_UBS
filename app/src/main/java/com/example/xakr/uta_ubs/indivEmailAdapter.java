package com.example.xakr.uta_ubs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sushil on 11/28/2016.
 */

public class indivEmailAdapter extends BaseAdapter {
    private Context context;
    ArrayList<User> users;
    User e=new User();
    private static LayoutInflater inflater=null;

    public indivEmailAdapter(Context context,ArrayList<User> users){
        this.context=context;
        this.users=users;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView=inflater.inflate(R.layout.listuser,null);

        TextView txtview=(TextView) convertView.findViewById(R.id.txtview);
        Button btn=(Button) convertView.findViewById(R.id.btn);
        e=users.get(position);
        txtview.setText(e.get_fisrtName());
        return convertView;
    }


}
