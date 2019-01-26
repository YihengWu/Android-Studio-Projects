package edu.purdue.wu1271.cs180;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkBox;
    private EditText editText;
    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate(Bundle) is where you initialize your activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use findViewById(int) to retrieve the widgets in that UI that you need to interact with programmatically.
        checkBox = (CheckBox)findViewById(R.id.checkbox);
        textView = (TextView)findViewById(R.id.textview);
        editText = (EditText)findViewById(R.id.edittext);
        button = (Button)findViewById(R.id.button);
        spinner = (Spinner)findViewById(R.id.spinner);

        // Use ArrayAdapter to provide choices to the Spinner.
        List<String> spinnerList = new ArrayList<String>(Arrays.asList("Item1","Item2","Item3"));
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerList);
        spinner.setAdapter(spinnerArrayAdapter);

        // Bind a OnClickListener to the button, which is similar to what you do in Java Swing application.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input, selection, ... from the widgets and update the TextView
                String s = String.format("Checkbox:%s \nEditText:%s \nSpinner:%s",
                        checkBox.isChecked(),editText.getText().toString(),spinner.getSelectedItem().toString());
                textView.setText(s);
            }
        });
    }
}
