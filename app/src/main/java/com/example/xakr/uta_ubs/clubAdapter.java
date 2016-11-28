package com.example.xakr.uta_ubs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushil on 11/27/2016.
 */

public class clubAdapter extends BaseAdapter {

    private Context context;
    ArrayList<Club> clubs;
    private static LayoutInflater inflater=null;

    public clubAdapter(Context context,ArrayList<Club> clubs){
        this.context=context;
        this.clubs=clubs;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return clubs.size();
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

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listclub, null);

        TextView clubname = (TextView) convertView.findViewById(R.id.clubname);
        TextView admin = (TextView) convertView.findViewById(R.id.adminname);
        Button join=(Button) convertView.findViewById(R.id.join);
        Club e = new Club();
        e = clubs.get(position);
        clubname.setText(e.getCname());
        admin.setText("Admin: " + e.getAdmin());
        return convertView;
    }
}
