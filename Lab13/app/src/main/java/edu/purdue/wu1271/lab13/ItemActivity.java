package edu.purdue.wu1271.lab13;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private Spinner categorySelector;
    private EditText dateEditText;
    private EditText contentEditText;
    private Button saveBtn;
    private Button cancelBtn;
    public static List<String> categories = new ArrayList<>(Arrays.asList("Life","Work"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //Initialize Category Spinner
        categorySelector = (Spinner)findViewById(R.id.category_spinner);
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                categories);
        categorySelector.setAdapter(spinnerArrayAdapter);

        //TODO:1. Initialize the two EditTexts
        // HINT: ... = (EditText)findViewByID(R.id.some_id)
        dateEditText = (EditText)findViewById(R.id.date_edittext);
        contentEditText = (EditText)findViewById(R.id.content_edittext);


        //Initialize Buttons
        cancelBtn = (Button)findViewById(R.id.cancel_btn);
        saveBtn = (Button)findViewById(R.id.save_btn);

        //Set action listener to buttons
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If clicked on Cancel, return to the MainActivity.
                onBackPressed();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dateEditText.getText().toString();
                String content = contentEditText.getText().toString();
                String category = categorySelector.getSelectedItem().toString();
                //TODO:2. Get text from contentEditText
                //TODO:3. Get text from categorySelector
                //HINT: For spinner, use getSelectedItem().toString()


                //TODO:4. Assign the boolean variable 'empty' with a boolean expression.
                //        So that, the alertDialog will popup when contentEditText or dateEidtText is empty
                boolean empty = false;
                if (date.equals("") || content.equals("")){
                    empty = true;
                }

                if(empty){
                    //Code to show an AlertBox if the field is empty
                    AlertDialog alertDialog = new AlertDialog.Builder(ItemActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Date and Note fields cannot be empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else{
                    //TODO:5. Create a new Item object with the Strings retrieved from the three widgets.
                    Item itemObject = new Item(category, content, date);
                    //TODO:6. Add the new item object to the list MainActivity.data
                    MainActivity.data.add(itemObject);
                    //TODO:7. Start the MainActivity using Intent.
                    //        If you don't know how to do it, look at the onOptionsItemSelected method in MainActivity
                    Intent intent = new Intent(ItemActivity.this,MainActivity.class);
                    startActivity(intent);

                }
            }
        });

    }
}

