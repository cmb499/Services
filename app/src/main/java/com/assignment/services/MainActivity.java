package com.assignment.services;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String MY_FILTER = "broadcastReceiver";
    public static final String MY_MSG = "_message";
    IntentFilter filter;
    TextView myTextView;

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                int iVal = bundle.getInt(MY_MSG);
                myTextView.setText(Integer.toString(iVal));
                System.out.println("299 text : " + Integer.toString(iVal));
            }


        }
    };

    //remember to make changes in manifest
    //dont run service on main GUI thread - create separate thread
    //if not created, application not responding error will be issued since thread is being used by service

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);

        //intent filter is a unique string that becomes a channel between
        filter = new IntentFilter();
        filter.addAction(MY_FILTER);
        registerReceiver(myReceiver, filter); //broadcast receiver gets registered with activity


    }


    public void startService(View view){

        Intent intent = new Intent(this, MyService.class);
        startService(intent); // to start service, call this


    }

    public void stopService(View view){
      //  Intent intent = new Intent(this, MyService.class);

        int i =0;
        synchronized (this) {
            while (i < 10) {
                try {
                    System.out.println("399 My Activity i " + i);
                    wait(1500);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

      //  stopService(intent); // to stop service, call this

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    //    public void downloadClick(View view) {
//        final String link = "699 hello world";
//
//        Intent intent = new Intent(this, MyService.class);
//        intent.putExtra("link",link);
//
//        new DownloadTask().execute(link);
//
//
//
//        //startService(intent);
//
//    }
//
//    private class DownloadTask extends AsyncTask<String, Integer, Void> {
//
//        @Override
//        protected Void doInBackground(String... links) {
//            String link = links[0]; // Access the array parameter from doInBackground
//            System.out.println("link 699" + link);
//
//            for (int i = 0; i<5; i++){
//                try {
//                    Thread.sleep(i*1000);
//                    publishProgress(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//
//            Integer i = values[0];
//            if(i!= null) {
//
//                System.out.println("699 " + i);
//            }
//
//
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            System.out.println("699 Finished");
//        }
//    }
//
//
//
//
//
//
//
//    private class DownloadBroadcast extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            Intent backgroundService = new Intent(context, MyService.class);
//            context.startService(backgroundService);
//           System.out.println("699 -- Download Finished!");
//
//
//
//        }
//    }


}
