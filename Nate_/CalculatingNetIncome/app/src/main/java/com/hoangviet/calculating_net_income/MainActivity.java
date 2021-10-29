package com.hoangviet.calculating_net_income;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText gross_income_edit_text;
    RadioButton radio_high, radio_medium, radio_low;
    SwitchMaterial switchMaterial;
    Button button_calculate;
    TextView text_net_income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gross_income_edit_text = findViewById(R.id.gross_income_edit_text);
        radio_high = findViewById(R.id.radio_high);
        radio_medium = findViewById(R.id.radio_medium);
        radio_low = findViewById(R.id.radio_low);
        switchMaterial = findViewById(R.id.switchMaterial);
        button_calculate = findViewById(R.id.button_calculate);
        text_net_income = findViewById(R.id.text_net_income);

        button_calculate.setOnClickListener((view) -> updateNetIncome());

        updateNetIncome();
    }

    private void updateNetIncome() {
        double gross_income = (gross_income_edit_text.length() == 0)
          ? 0
          : Double.parseDouble(gross_income_edit_text.getText().toString());

        double tax_rate;
        if (radio_high.isChecked()) {
            tax_rate = .25d;
        } else if (radio_medium.isChecked()) {
            tax_rate = .2d;
        } else {
            tax_rate = .15d;
        }

        double net_income = gross_income * (1 - tax_rate);
        if (switchMaterial.isChecked()) {
            net_income = Math.round(net_income);
        }

        String formattedNetIncome = NumberFormat.getCurrencyInstance().format(net_income);
        text_net_income.setText(getString(R.string.text_net_income, formattedNetIncome));
    }
}