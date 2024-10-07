package com.example.lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private EditText editTextInput;
    private Spinner spinnerCountOption;
    private Button buttonCount;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextInput = findViewById(R.id.editTextInput);
        spinnerCountOption = findViewById(R.id.spinnerCountOption);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the Spinner (dropdown)
        setupSpinner();
// cart
        // Handle Button click event
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter some text", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get the selected option from the Spinner
                String selectedOption = spinnerCountOption.getSelectedItem().toString();

                int result = 0;

                // Perform counting based on the selected option
                if (selectedOption.equals("Count Words")) {
                    result = WordCharCounter.countWords(inputText);
                    textViewResult.setText("Words: " + result);
                } else if (selectedOption.equals("Count Characters")) {
                    result = WordCharCounter.countCharacters(inputText);
                    textViewResult.setText("Characters: " + result);
                }
            }
        });
    }

    // Function to set up the Spinner
    private void setupSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the Spinner
        spinnerCountOption.setAdapter(adapter);

        // Handle the Spinner's selection event
        spinnerCountOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // This will trigger when the user selects an item in the Spinner
                // No need to handle anything here for now
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case where nothing is selected, but this is not required in most cases
            }
        });
    }
}
