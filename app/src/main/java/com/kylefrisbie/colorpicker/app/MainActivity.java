package com.kylefrisbie.colorpicker.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;


public class MainActivity extends Activity {

    private NumberPicker mRedButton, mBlueButton, mGreenButton;
    private ImageView mColorBox;
    private Button mSubmitColorButton;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 255;
    private int red, green, blue = 0;
    private final String RED = "Red";
    private final String GREEN = "Green";
    private final String BLUE = "Blue";

    protected void initializeNumberPicker(NumberPicker picker) {
        picker.setMinValue(MIN_VALUE);
        picker.setMaxValue(MAX_VALUE);
    }

    protected void resetBackgroundColor() {
        mColorBox.setBackgroundColor(Color.rgb(red, green, blue));
    }

    private void setColorPickResult() {
        Intent data = new Intent();
        data.putExtra(RED, red);
        data.putExtra(GREEN, green);
        data.putExtra(BLUE, blue);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBox = (ImageView)findViewById(R.id.imageView);
        resetBackgroundColor();

        mRedButton = (NumberPicker)findViewById(R.id.numberPicker_Red);
        initializeNumberPicker(mRedButton);

        mRedButton.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                red = newVal;
                resetBackgroundColor();
            }
        });

        mGreenButton = (NumberPicker)findViewById(R.id.numberPicker_Green);
        initializeNumberPicker(mGreenButton);

        mGreenButton.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                green = newVal;
                resetBackgroundColor();
            }
        });

        mBlueButton = (NumberPicker)findViewById(R.id.numberPicker_Blue);
        initializeNumberPicker(mBlueButton);

        mBlueButton.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                blue = newVal;
                resetBackgroundColor();
            }
        });

        mSubmitColorButton = (Button) findViewById(R.id.submit_color_button);
        mSubmitColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColorPickResult();
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
