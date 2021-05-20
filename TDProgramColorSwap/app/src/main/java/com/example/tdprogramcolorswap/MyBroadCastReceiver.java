package com.example.tdprogramcolorswap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("message");
        //A message from both the Sender and the receiver
        Toast.makeText(context,""+ msg + "is received here by TDProgram Color Swap",Toast.LENGTH_SHORT).show();


    }
}
