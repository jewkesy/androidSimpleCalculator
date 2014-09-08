package com.daryljewkes.simplecalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends Activity implements View.OnClickListener {

    private EditText etNumber1, etNumber2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String operation = "";
        float number1, number2, result = 0;

        if (TextUtils.isEmpty(etNumber1.getText().toString()) || TextUtils.isEmpty(etNumber2.getText().toString())) {
            return;
        }

        number1 = Float.parseFloat(etNumber1.getText().toString());
        number2 = Float.parseFloat(etNumber2.getText().toString());

        switch ( (view.getId())) {
            case R.id.btnAdd:
                operation = " + ";
                result = number1 + number2;
                break;
            case R.id.btnSubtract:
                operation = " - ";
                result = number1 - number2;
                break;
            case R.id.btnMultiply:
                operation = " x ";
                result = number1 * number2;
                break;
            case R.id.btnDivide:
                operation = " / ";
                result = number1 / number2;
                break;
            default:
                break;
        }

        tvResult.setText(number1 + operation + number2 + " = " + result);
    }
}
