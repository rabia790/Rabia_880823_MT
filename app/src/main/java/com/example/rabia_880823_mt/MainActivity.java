package com.example.rabia_880823_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{
    Spinner spinner;
    EditText dailyRent;
    double priceSelected, quantity, calamount;
    RadioButton radioButton1, radioButton2, radioButton3;
    RadioGroup radioGroup;
    EditText totalAmount, totalPay;
    Button viewDetails;
    SeekBar seekBar;
    String itemSelected;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.cars);
        spinner.setOnItemSelectedListener(this);
        dailyRent = findViewById(R.id.dailyrent);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        totalAmount = findViewById(R.id.amount);
        totalPay = findViewById(R.id.totalPay);
        viewDetails = findViewById(R.id.viewDetails);
        seekBar = findViewById(R.id.seekBar);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOrderSuccess();

                Intent intent = new Intent(MainActivity.this, ViewDetails.class);
                intent.putExtra("message", spinner.getSelectedItem().toString());
                intent.putExtra("amount", totalPay.getText().toString());
                startActivity(intent);
            }
        });





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
                    quantity = Double.parseDouble(String.valueOf(progress));
                    calamount= (quantity * priceSelected);
                    totalAmount.setText(String.valueOf(calamount));
                    totalPay.setText(String.valueOf(calamount - calamount*0.13));

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

    private void onOrderSuccess() {


        if (!(radioGroup.getCheckedRadioButtonId() != -1)){
            Toast.makeText(this, "Please select radioButton!", Toast.LENGTH_SHORT).show();
            return;
        }


    }


   public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

       switch(view.getId()) {
           case R.id.idCheckBox1:
               if (checked) {
                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount + 5));
                   totalPay.setText(String.valueOf((calamount + 5) - (calamount * 0.13)));
               }
               else {

                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount));
                   totalPay.setText(String.valueOf((calamount) - (calamount * 0.13)));
               }
               break;
           case R.id.idCheckBox2:
               if (checked) {
                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount + 7));
                   totalPay.setText(String.valueOf((calamount + 7) - (calamount * 0.13)));

               }
               else{
                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount));
                   totalPay.setText(String.valueOf((calamount) - (calamount * 0.13)));
               }
               break;
           case R.id.idCheckBox3:
               if (checked) {
                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount + 10));
                   totalPay.setText(String.valueOf((calamount + 10) - (calamount * 0.13)));
               }
               else{
                   calamount = (quantity * priceSelected);
                   totalAmount.setText(String.valueOf(calamount));
                   totalPay.setText(String.valueOf((calamount) - (calamount * 0.13)));
               }

               break;

       }
   }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (spinner.getSelectedItem().toString().equals("BMW")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 8.90;
            dailyRent.setText("8.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Audi")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 2.90;
            dailyRent.setText("2.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Cadilliac")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 8.10;
            dailyRent.setText("8.10");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("WolksWagon")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 9.90;
            dailyRent.setText("9.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Mercedes")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 2.90;
            dailyRent.setText("2.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Peugot")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 1.90;
            dailyRent.setText("1.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Ferrari")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 8.30;
            dailyRent.setText("8.30");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Tarzon")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 2.8;
            dailyRent.setText("2.8");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Car2")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 4.90;
            dailyRent.setText("4.90");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }else  if (spinner.getSelectedItem().toString().equals("Car10")) {
            itemSelected = spinner.getSelectedItem().toString();
            priceSelected = 2.50;
            dailyRent.setText("2.50");
            calamount= (quantity * priceSelected);
            totalAmount.setText(String.valueOf(calamount));
            totalPay.setText(String.valueOf(calamount - calamount*0.13));

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radioButton1:
                    calamount= (quantity * priceSelected);
                    totalAmount.setText(String.valueOf(calamount+5));
                    totalPay.setText(String.valueOf((calamount + 5) - (calamount * 0.13)));
                    break;

                case R.id.radioButton2:
                    calamount= (quantity * priceSelected);
                    totalAmount.setText(String.valueOf(calamount));
                    totalPay.setText(String.valueOf(calamount - calamount*0.13));
                    break;

                case R.id.radioButton3:
                    calamount= (quantity * priceSelected);
                    totalAmount.setText(String.valueOf(calamount-10));
                    totalPay.setText(String.valueOf(calamount - 10 - (calamount * 0.13)));
                    break;


            }
        }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}