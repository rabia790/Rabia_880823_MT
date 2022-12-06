package com.example.rabia_880823_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    EditText dailyRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.cars);
        spinner.setOnItemSelectedListener(this);
        dailyRent = findViewById(R.id.dailyrent);


        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textView = findViewById(R.id.seekText);

        Spinner spinner = (Spinner) findViewById(R.id.cars);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    textView.setText(String.valueOf(progress));
//                quantity = Double.parseDouble(String.valueOf(progress));
//                finalPInterest = (quantity * priceSelected) + tip + (0.13 * priceSelected);
//                finalPrice.setText(String.valueOf( finalPInterest));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

//    public void onCheckboxClicked(View view) {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        // Check which checkbox was clicked
//        switch(view.getId()) {
//            case R.id.idCheckBox1:
//
//                if (checked)
//                   checkk.setText("ff");
//            else
//                    checkk.setText("nn");
//                break;
//
//
//
//        }
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (spinner.getSelectedItem().toString().equals("BMW")) {
            dailyRent.setText("8.90");
        }else  if (spinner.getSelectedItem().toString().equals("Audi")) {
            dailyRent.setText("2.90");
        }else  if (spinner.getSelectedItem().toString().equals("Cadilliac")) {
            dailyRent.setText("8.10");
        }else  if (spinner.getSelectedItem().toString().equals("WolksWagon")) {
            dailyRent.setText("9.90");
        }else  if (spinner.getSelectedItem().toString().equals("Mercedes")) {
            dailyRent.setText("2.90");
        }else  if (spinner.getSelectedItem().toString().equals("Peugot")) {
            dailyRent.setText("1.90");
        }else  if (spinner.getSelectedItem().toString().equals("Ferrari")) {
            dailyRent.setText("8.30");
        }else  if (spinner.getSelectedItem().toString().equals("Tarzon")) {
            dailyRent.setText("2.8");
        }else  if (spinner.getSelectedItem().toString().equals("Car2")) {
            dailyRent.setText("4.90");
        }else  if (spinner.getSelectedItem().toString().equals("Car10")) {
            dailyRent.setText("2.50");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}