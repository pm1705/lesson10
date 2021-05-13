package com.example.lesson10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    TextView answ;
    double num;
    double sign;
    double a,b,c;
    String value;
    double x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        answ = findViewById(R.id.answ);
    }

    public void rand_nums(View view) {
        num = Math.random();
        sign = Math.random();
        num = num * 100;
        num = (int) num;
        if (sign > 0.5) {
            num = num * -1;
        }
        et1.setText(String.valueOf(num));
        num = Math.random();
        sign = Math.random();
        num = num * 100;
        num = (int) num;
        if (sign > 0.5) {
            num = num * -1;
        }
        et2.setText(String.valueOf(num));
        num = Math.random();
        sign = Math.random();
        num = num * 100;
        num = (int) num;
        if (sign > 0.5) {
            num = num * -1;
        }
        et3.setText(String.valueOf(num));
    }

    public void solve(View view) {
        if (et1.getText().toString().matches("") || et2.getText().toString().matches("") || et3.getText().toString().matches("")) {
            Toast.makeText(this, "one or more input fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            value = et1.getText().toString();
            a = Double.parseDouble(value);
            value = et2.getText().toString();
            b = Double.parseDouble(value);
            value = et3.getText().toString();
            c = Double.parseDouble(value);
            if ((b * b - 4 * a * c) < 0) {
                Toast.makeText(this, "cant have negative a discriminant", Toast.LENGTH_SHORT).show();
            } else if (a == 0) {
                Toast.makeText(this, "A parameter cannot be zero", Toast.LENGTH_SHORT).show();
            } else {
                Intent si = new Intent(this, answers.class);
                si.putExtra("a", a);
                si.putExtra("b", b);
                si.putExtra("c", c);
                startActivityForResult(si,1);
            }
        }
    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            x1 = data_back.getDoubleExtra("x1", 0);
            x2 = data_back.getDoubleExtra("x2", 0);
            answ.setText("X1="+x1+"\nX2="+x2);
        }
    }
}