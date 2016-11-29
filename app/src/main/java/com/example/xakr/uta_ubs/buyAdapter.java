package com.example.xakr.uta_ubs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushil on 11/27/2016.
 */

public class buyAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Item> items;
    private static LayoutInflater inflater=null;



    public buyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return items.size();
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
            convertView = inflater.inflate(R.layout.griditem, null);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView email=(TextView) convertView.findViewById(R.id.email);

        Item e = new Item();
        e = items.get(position);
        image.setImageBitmap(getImage(e.getPhoto()));
        name.setText("Item: " + e.getItname());
        price.setText("Price: " + e.getPrice());
        description.setText("Details: " + e.getDetails());
        email.setText("Email: "+e.getEid());
        return convertView;
    }

    public static Bitmap getImage(byte[] image){
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
