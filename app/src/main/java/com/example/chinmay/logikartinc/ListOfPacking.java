package com.example.chinmay.logikartinc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class ListOfPacking extends Activity {


    ListView listview;
    String[] ListViewItems = new String[]{
            "Double Bed",
            "Dining Table",
            "Chairs",
            "Sofa",
            "Refrigerator",
            "Television Set",
            "Wardrobe",
            "Study Table",
            "Industrial Machinery",
            "Air Conditioner",
            "Washing Machine",
            "Generator",
            "Kitchen-ware",
            "Mattress & Pillows",
            "Computer Desktop",
            "Vehicle"

    };
    SparseBooleanArray sparseBooleanArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofpacking);

        listview = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (ListOfPacking.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, ListViewItems);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                sparseBooleanArray = listview.getCheckedItemPositions();

                String ValueHolder = "" ;

                int i = 0 ;

                while (i < sparseBooleanArray.size()) {

                    if (sparseBooleanArray.valueAt(i)) {

                        ValueHolder += ListViewItems [ sparseBooleanArray.keyAt(i) ] + ",";
                    }

                    i++ ;
                }

                ValueHolder = ValueHolder.replaceAll("(,)*$", "");

                Toast.makeText(ListOfPacking.this, "ListView Selected Values = " + ValueHolder, Toast.LENGTH_LONG).show();

            }
        });

        Button sub = (Button) findViewById(R.id.submit);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfPacking.this, Confirmation.class);
                startActivity(intent);
            }
        });

    }
}



