package edu.purdue.wu1271.lab13;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private Spinner categorySelector;
    private TodoListAdapter tdAdapter;
    public static List<Item> data = new ArrayList<>();
    public static List<String> categories = new ArrayList<>(Arrays.asList("All","Life","Work"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Actionbar
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        //Initialize List
        listView = (ListView)findViewById(R.id.item_list);
        tdAdapter = new TodoListAdapter(MainActivity.this,data);
        listView.setAdapter(tdAdapter);

        //Initialize Spinner
        categorySelector = (Spinner)findViewById(R.id.category_spinner);
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                categories);
        categorySelector.setAdapter(spinnerArrayAdapter);

        //Set Listener to ItemSelected event
        categorySelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                List<Item> newData;
                if(selectedItem.equals(categories.get(0))){
                    // Selected "All". newData should contain all items from data
                    newData = data;
                }
                else {
                    newData = new ArrayList<>();
                    //TODO: If selected other options, newData should contain only items from that category.
                    //      Copy those items from data to newData
                    if (selectedItem.equals(categories.get(1))) {
                        for (Item i : data) {
                            if (i.getCategory().equals("Life")) {
                                newData.add(i);
                            }
                        }
                    }
                    else{
                        for (Item i : data) {
                            if (i.getCategory().equals("Work")) {
                                newData.add(i);
                            }
                        }
                    }
                }
                tdAdapter.setData(newData);
                tdAdapter.notifyDataSetChanged();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                //Use Intent to open another activity
                Intent intent = new Intent(MainActivity.this,ItemActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
