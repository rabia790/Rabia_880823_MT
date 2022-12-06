package com.example.rabia_880823_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        TextView textView = findViewById(R.id.selectedCar);
        TextView amountTax = findViewById(R.id.amountTax);

        Intent intent = getIntent();
        String message = intent.getExtras().getString("message");
        textView.setText(message);
        String amount = intent.getExtras().getString("amount");
        amountTax.setText(amount);
    }
}