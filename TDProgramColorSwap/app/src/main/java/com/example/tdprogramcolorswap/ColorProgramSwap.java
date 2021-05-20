package com.example.tdprogramcolorswap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ColorProgramSwap extends Activity {
    //when this application is not open, the broadcast receiver (the toast) cant be seen
    MyBroadCastReceiver mybroad = new MyBroadCastReceiver();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadBroadcastReceiver();

        Button btn = new Button(this);
        btn.setText("Tap Me for my camoufrage!");

        TextView textView = new TextView(this);
        TextView textView1 = new TextView(this);
        textView.setText("Tap Many times to observe color Change");

        final Random random = new Random();

        btn.setOnClickListener((v) -> {
            float red = random.nextFloat();
            float green = random.nextFloat();
            float blue = random.nextFloat();
            // randomly gives different colors after mixture of rgb
            textView.setText("r" + String.valueOf(red) + "   g" + String.valueOf(green + " b" + String.valueOf(blue)));
            textView.setTextColor(Color.rgb(red, green, blue));

        });
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutparams.setMarginStart(40);
        layout.addView(textView);
        layout.addView(btn,layoutparams);
        setContentView(layout);

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
    public void loadBroadcastReceiver(){
        IntentFilter intentFilter= new IntentFilter("must.codes.td.java");
        registerReceiver(mybroad,intentFilter);

    }

}
