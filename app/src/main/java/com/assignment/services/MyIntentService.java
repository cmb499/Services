//package com.assignment.services;
//
//import android.app.IntentService;
//import android.content.Intent;
//import android.widget.Toast;
//
///**
// * Created by Careena on 10/31/16.
// */
//public class MyIntentService extends IntentService {
//
//
//  //if you extend Intent Service no need to create new thread... you will be provided with  background worker thread
//    // no need to overide all the other methods
//
//    public MyIntentService() {
//        super("My Worker Thread");
//    }
//
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        Toast.makeText(this, "New Service started", Toast.LENGTH_SHORT).show();
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this, "New Service destroyed ...", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//
//
//        int i = 0;
//
//        synchronized (this) {
//            while (i < 10) {
//                try {
//                    wait(1500);
//                    i++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            // no need to stop Service when using IntentService.. it will be stopped when work is done
//            //  stopSelf(); //stop service after 15s
//        }
//
//
//
//    }
//}
