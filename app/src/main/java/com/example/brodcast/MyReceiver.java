package com.example.brodcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

/*
public class MyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (checkNetwork(context)) {

            Toast.makeText(context, "conn is corect", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(context, "conn is wrong", Toast.LENGTH_SHORT).show();

        }

    }

    private boolean checkNetwork(Context mContext) {

        try {

            ConnectivityManager conManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = conManager.getActiveNetworkInfo();

            return (nInfo != null && nInfo.isConnected());

        } catch (NullPointerException e) {

            e.printStackTrace();
            return false;

        }

    }


}
*/
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

        if (isConnected) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning")
                    .setMessage("internt is not connect")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String phoneNumber = "09336880106";
                            String message = "internt  connection is true ";
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("ok")
                    .setMessage("internt is conn")
                    .setPositiveButton("ok", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
