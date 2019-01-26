package edu.purdue.wu1271.todolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CategoryActivity";
    private EditText categoryNameEditText;
    private Button addBtn;
    private Button cancelBtn;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //TODO: 1. Initialize all views using findViewById

        titleView = (TextView)findViewById(R.id.title);
        cancelBtn = (Button)findViewById(R.id.cancel_btn);
        addBtn = (Button)findViewById(R.id.add_btn);
        categoryNameEditText = (EditText)findViewById(R.id.category_edittext);

        //TODO: 2. Register OnClickListener for the two buttons

        cancelBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);

    }

    public boolean categoryAlreadyExist(String category){
        for(String i: MainActivity.categories){
            if (category.equals(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                //TODO: 3. When cancel button is clicked, go back to MainActivity
            case R.id.cancel_btn:
                onBackPressed();
                break;
                /*
                TODO: 4. When add is clicked, you need to check the following conditions
                      (1) If category is empty, popup a dialog says 'Category cannot be empty'
                      (2) If category already exists, popup a dialog says 'Category exists'
                      (3) If a valid category is input, add it to MainActivity.newCategories and go back to MainActivity using onBackPressed()
                */
            case R.id.add_btn:
                String categoryName = categoryNameEditText.getText().toString();

                if(categoryName.isEmpty()){
                    //Code to show an AlertBox if the field is empty
                    AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Category cannot be empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else if(categoryAlreadyExist(categoryName)){
                    AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Category exists");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    MainActivity.newCategories.add(categoryName);
                    onBackPressed();
                }
                break;

        }
    }
}
