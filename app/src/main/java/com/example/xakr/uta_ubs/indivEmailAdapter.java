package com.example.xakr.uta_ubs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushil on 11/28/2016.
 */

public class indivEmailAdapter extends BaseAdapter {
    private Context context;
    ArrayList<User> users;
    private static LayoutInflater inflater=null;

    public indivEmailAdapter(Context context,ArrayList<User> users){
        this.context=context;
        this.users=users;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public indivEmailAdapter() {
        super();
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
        User e=new User();
        e=users.get(position);
        txtview.setText(e.get_fisrtName());
        return convertView;
    }
}
