package com.example.demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.entity.Person;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context context;
    private List<Person> data;

    public MyAdapter(Context context, List<Person> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.itemlist,parent,false);
        TextView nameTv = view.findViewById(R.id.name_tv);
        TextView messageTv = view.findViewById(R.id.message_tv);
        nameTv.setText(data.get(position).getName());
        messageTv.setText(data.get(position).getMessage());
        return view;
    }
}
