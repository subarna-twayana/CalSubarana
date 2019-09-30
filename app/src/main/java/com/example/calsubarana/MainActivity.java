package com.example.calsubarana;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calsubarana.action.MathCal;
import com.example.calsubarana.model.Numbers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    Button but_1, but_2, but_3, but_4, but_5, but_6, but_7, but_8, but_9, but_p, but_s, but_m, but_d, but_e, but_dot, but_0, but_c,but_del;
    int count = 0;
    String doa;
    Numbers numbers = new Numbers();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_del=findViewById(R.id.delete);
        but_del.setOnClickListener(this);
        result = findViewById(R.id.result);
        result.setShowSoftInputOnFocus(false);
        but_0 = findViewById(R.id.but0);
        but_0.setOnClickListener(this);
        but_1 = findViewById(R.id.but1);
        but_1.setOnClickListener(this);
        but_2 = findViewById(R.id.but2);
        but_2.setOnClickListener(this);
        but_3 = findViewById(R.id.but3);
        but_3.setOnClickListener(this);
        but_4 = findViewById(R.id.but4);
        but_4.setOnClickListener(this);
        but_5 = findViewById(R.id.but5);
        but_5.setOnClickListener(this);
        but_6 = findViewById(R.id.but6);
        but_6.setOnClickListener(this);
        but_7 = findViewById(R.id.but7);
        but_7.setOnClickListener(this);
        but_8 = findViewById(R.id.but8);
        but_8.setOnClickListener(this);
        but_9 = findViewById(R.id.but9);
        but_9.setOnClickListener(this);
        but_p = findViewById(R.id.butadd);
        but_p.setOnClickListener(this);
        but_s = findViewById(R.id.butsub);
        but_s.setOnClickListener(this);
        but_m = findViewById(R.id.butx);
        but_m.setOnClickListener(this);
        but_d = findViewById(R.id.butdi);
        but_d.setOnClickListener(this);
        but_e = findViewById(R.id.butequal);
        but_e.setOnClickListener(this);
        but_dot = findViewById(R.id.butdot);
        but_dot.setOnClickListener(this);
        but_c = findViewById(R.id.clear);
        but_c.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.but0:
                result.append("0");
                break;
            case R.id.but1:
                result.append("1");
                break;
            case R.id.but2:
                result.append("2");
                break;
            case R.id.but3:
                result.append("3");
                break;
            case R.id.but4:
                result.append("4");
                break;
            case R.id.but5:
                result.append("5");
                break;
            case R.id.but6:
                result.append("6");
                break;
            case R.id.but7:
                result.append("7");
                break;
            case R.id.but8:
                result.append("8");
                break;
            case R.id.but9:
                result.append("9");
                break;
            case R.id.butdot:
                if ((result.getText().toString()).contains(".")) {

                } else {
                    result.append(".");
                }
                break;
            case R.id.clear:
                try {
                    String NumberEntered = result.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 1);
                    String word = (NumberEntered);
                    result.setText(word);

                    return;

                } catch (Exception e) {

                    result.setError("please first enter value");
                }
                break;
            case R.id.butadd:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "plus";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.butsub:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "sub";}
                else{
                    result.setError("only two time");
                }
                break;
            case R.id.butdi:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "di";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.butx:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "mul";}
                else{
                    result.setError("only two time");
                }

                break;
            case R.id.butequal:
                MathCal mathCal = new MathCal();
                count++;
                SetData(count);
                if (doa.equalsIgnoreCase("plus")) {
                    result.setText(mathCal.add(numbers));

                } else if (doa.equalsIgnoreCase("sub")) {
                    result.setText(mathCal.sub(numbers));

                } else if (doa.equalsIgnoreCase("di")) {
                    result.setText(mathCal.divide(numbers));

                } else if (doa.equalsIgnoreCase("mul")) {
                    result.setText(mathCal.mul(numbers));

                }

                break;
            case R.id.delete:
                result.setText("");
                count=0;
        }
    }

    public void SetData(int cou) {

        if (!result.getText().toString().isEmpty()) {
            if (cou == 1) {
                numbers.setFirstNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            } else if (cou == 2) {
                numbers.setSecondNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            } else {
                result.setError("only two time");
                return;
            }
        } else {
            result.setError("please enter the number first");
            count--;
            return;

        }

    }
}
