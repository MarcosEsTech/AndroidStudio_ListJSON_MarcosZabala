package com.example.iniciojson;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Item> {
    Context myContext;
    int myLayoutResourceID;
    List<Item> myData;

    public ItemsAdapter(Context context, int layoutResourceID, ArrayList<Item> data){
        super(context,layoutResourceID,data);

        this.myContext = context;
        this.myLayoutResourceID = layoutResourceID;
        this.myData = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ItemHolder holder = null;

        if(row == null){
            LayoutInflater inflater =((Activity)myContext).getLayoutInflater();
            row = inflater.inflate(myLayoutResourceID,parent,false);

            holder = new ItemHolder();
            holder.textView = row.findViewById(R.id.texto);
            row.setTag(holder);

        }else{
            holder = (ItemHolder)row.getTag();

        }

        Item item = myData.get(position);
        holder.textView.setText( item.getTitle());

        return row;
    }

    static class ItemHolder{
        TextView textView;
    }
}
