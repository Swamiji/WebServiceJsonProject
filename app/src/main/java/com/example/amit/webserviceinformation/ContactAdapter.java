package com.example.amit.webserviceinformation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit on 7/11/2017.
 */

public class ContactAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ContactAdapter( Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.row,parent,false);
            viewHolder.name=(TextView)convertView.findViewById(R.id.name_NN);
            viewHolder.email=(TextView)convertView.findViewById(R.id.email_ID);
            viewHolder.mobile=(TextView)convertView.findViewById(R.id.mobile_NO);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        Contacts contacts=(Contacts)this.getItem(position);
        viewHolder.name.setText(contacts.getName());
        viewHolder.email.setText(contacts.getEmail_id());
        viewHolder.mobile.setText(contacts.getMobile_number());


        return convertView;
    }
    static class ViewHolder{
        TextView name,email,mobile;

    }
}
