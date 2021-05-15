package com.example.scientificcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation=findViewById(R.id.previousCalculation);
        display=findViewById(R.id.displayText);

        display.setShowSoftInputOnFocus(false); //keyboard doesn't show up
    }

    public void zeroButtonPush(View view)
    {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneButtonPush(View view)
    {
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoButtonPush(View view)
    {
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeButtonPush(View view)
    {
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourButtonPush(View view)
    {
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveButtonPush(View view)
    {
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixButtonPush(View view)
    {
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenButtonPush(View view)
    {
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightButtonPush(View view)
    {
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineButtonPush(View view)
    {
        updateText(getResources().getString(R.string.nineText));
    }

    public void AddButtonPush(View view)
    {
        updateText(getResources().getString(R.string.addText));
    }

    public void MinusButtonPush(View view)
    {
        updateText(getResources().getString(R.string.subtractText));
    }
    public void divideButtonPush(View view)
    {
        updateText(getResources().getString(R.string.divideText));
    }
    public void multiplyButtonPush(View view)
    {
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void decimalButtonPush(View view)
    {
        updateText(getResources().getString(R.string.decimalText));
    }
    public void openBracketButtonPush(View view)
    {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void closeBracketButtonPush(View view)
    {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void clearButtonPush(View view)
    {
        display.setText("");
    }
    public void EqualButtonPush(View view)
    {
        String userExpression=display.getText().toString();

        userExpression=userExpression.replaceAll(getResources().getString(R.string.divideText),"/");
        userExpression=userExpression.replaceAll(getResources().getString(R.string.multiplyText),"*");
        Expression exp=new Expression((userExpression));

        String result=String.valueOf((exp.calculate()));
        display.setText(result);
        previousCalculation.setText(userExpression);
        display.setSelection(result.length());
    }

    public void BackspaceButtonPush(View view)
    {
        int cursorPos=display.getSelectionStart();
        int textLength=display.getText().length();

        if(cursorPos!=0 && textLength!=0)
        {
            SpannableStringBuilder selection=(SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);

        }
    }

    public void SinButtonPush(View view)
    {
        updateText("sin(");
    }

    public void CosButtonPush(View view)
    {
        updateText("cos(");
    }
    public void TanButtonPush(View view)
    {
        updateText("tan(");
    }
    public void ArcSinButtonPush(View view)
    {
        updateText("arcsin(");
    }
    public void ArcCosButtonPush(View view)
    {
        updateText("arccos(");
    }
    public void ArcTanButtonPush(View view)
    {
        updateText("arctan(");
    }
    public void LogButtonPush(View view)
    {
        updateText("log10(");
    }
    public void NaturalLogButtonPush(View view)
    {
        updateText("ln(");
    }
    public void SquareRootButtonPush(View view)
    {
        updateText("sqrt(");;
    }
    public void EButtonPush(View view)
    {
        updateText("e");;
    }
    public void PiButtonPush(View view)
    {
        updateText("pi");
    }
    public void AbsoluteButtonPush(View view)
    {
        updateText("abs(");
    }
    public void PrimeButtonPush(View view)
    {
        updateText("ispr(");
    }
    public void SquareButtonPush(View view)
    {
        updateText("^(2)");
    }
    public void PowerButtonPush(View view)
    {
        updateText("^(");
    }

    private void updateText(String stringToAdd)
    {
        String current=display.getText().toString();
        int cursorPosition=display.getSelectionStart();

        String leftStr=current.substring(0,cursorPosition);
        String RightStr=current.substring(cursorPosition);


        display.setText(leftStr+stringToAdd+RightStr);
        display.setSelection(cursorPosition+stringToAdd.length());

    }
}