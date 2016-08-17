package com.calc.lcollins.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    double firstNumber, secondNumber, result;
    public EditText textbox;
    String operation;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textbox = (EditText)findViewById(R.id.editText);
        firstNumber = 3;
        secondNumber = 1;
    }

    public void buttonPress(View view)
    {
        firstNumber = Double.parseDouble(textbox.getText().toString());
        switch(view.getId())
        {
            case R.id.plusButton:addClicked(); break;
            case R.id.minusButton: subClicked(); break;
            case R.id.multButton: multClicked(); break;
            case R.id.divButton: divClicked(); break;
        }
    }

    public void addClicked()
    {
        operation = "add";
        textbox.setText("");
    }

    public void subClicked()
    {
        operation = "sub";
        textbox.setText("");
    }

    public void multClicked()
    {
        operation = "mult";
        textbox.setText("");
    }

    public void divClicked()
    {
        operation = "div";
        textbox.setText("");
    }

    public void equal(View view)
    {
        secondNumber = Double.parseDouble(textbox.getText().toString());

        if(operation.equals("add"))
            add(firstNumber, secondNumber);
        else
        {
            if (operation.equals("sub"))
                subtract(firstNumber, secondNumber);
            else
            {
                if (operation.equals("mult"))
                    multiply(firstNumber, secondNumber);
                else
                {
                    if(operation.equals("div") && secondNumber == 0)
                    {
                        Toast divZero = Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_LONG);
                        divZero.setGravity(Gravity.TOP, 0, 500);
                        divZero.show();
                        result = 0;
                    }
                    else
                    {
                        divide(firstNumber, secondNumber);

                    }
                }
            }
        }

    }

    public double add(double a, double b)
    {
        result = a + b;
        textbox.setText(String.valueOf(result));
        return result;
    }

    public double subtract(double a, double b)
    {
        result = a - b;
        textbox.setText("" + result);
        return result;
    }

    public double multiply(double a, double b)
    {
        result = a * b;
        textbox.setText("" + result);
        return result;
    }

    public double divide(double a, double b)
    {
        result = a / b;
        textbox.setText("" + result);
        return result;
    }

    public void clear(View view)
    {
        textbox.setText("");
        firstNumber = 0;
        secondNumber = 0;
    }



}
