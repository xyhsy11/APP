package com.example.demo1;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.entity.Person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {


    public static final String TAG = "ListViewActivity";
    private List<String> data;
    private ListView show;
    private ArrayAdapter adapter;
    private BaseAdapter baseAdapter;
    private List<Person> personList;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initView();
        initData();
        setAdapter();
        setListener();
    }

    private void setListener() {
        
        
        
        
        
        
        show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ListViewActivity.this,data.get(position), Toast.LENGTH_SHORT).show() ;
                Log.i(TAG, "onItemClick: -----------------");
            }
        });

        show.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
             /*   Toast.makeText(ListViewActivity.this,data.get(position), Toast.LENGTH_SHORT).show() ;*/

                Log.i(TAG, "onItemLongClick: ----------------");
                return true;
            }
        });
    }

    private void setAdapter() {
        baseAdapter = new MyAdapter(this,personList);

        show.setAdapter(baseAdapter);
    }

    private void initData() {
        personList = new ArrayList<Person>();
        for (int i = 0; i < 20; i++) {
            personList.add(new Person("张三"+i,System.currentTimeMillis()+i +""));

        }
    }

    private void initView() {
        show = findViewById(R.id.show_lv);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
