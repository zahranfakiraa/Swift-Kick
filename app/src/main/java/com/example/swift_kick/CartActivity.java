package com.example.swift_kick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    private int quantity = 1;
    private TextView quantityTextView;
    private RadioGroup variantGroup;
    private TextView totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        quantityTextView = findViewById(R.id.quantity);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnPlus = findViewById(R.id.btn_plus);
        variantGroup = findViewById(R.id.variant_group);
        totalAmount = findViewById(R.id.total_amount);
        Button btnAddToCart = findViewById(R.id.add_to_cart);

        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        btnPlus.setOnClickListener(v -> {
            quantity++;
            quantityTextView.setText(String.valueOf(quantity));
        });

        btnAddToCart.setOnClickListener(v -> {
            int selectedId = variantGroup.getCheckedRadioButtonId();
            RadioButton selectedVariant = findViewById(selectedId);
            String variant = selectedVariant != null ? selectedVariant.getText().toString() : "None";
        });
    }
}
