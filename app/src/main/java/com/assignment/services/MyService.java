package com.assignment.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Careena on 10/31/16.
**/
public class MyService extends Service {

    final class MyThreadClass implements Runnable {

        int SERVICE_ID;

        public MyThreadClass(int serviceID) {
            this.SERVICE_ID = serviceID;
        }

        @Override
        public void run() {

            int i = 0;

            synchronized (this) {
                while (i < 10) {
                    try {
                        System.out.println("399 My Service i " + i);
                        Intent intent = new Intent();
                        intent.putExtra(MainActivity.MY_MSG, i);
                        intent.setAction(MainActivity.MY_FILTER);
                        sendBroadcast(intent);
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(SERVICE_ID); //stop service after 15s
            }
        }

    }

    //initial set up for service
    @Override
    public void onCreate() {
        super.onCreate();
    }


    //for start service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

      //  Toast.makeText(this, "Service is started", Toast.LENGTH_SHORT).show();

        System.out.println("399 Service started .....");
        // create the thread and pass Service id
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();
        return START_STICKY;    //constant value of service class
    }


    //will be called before service is destroyed
    @Override
    public void onDestroy() {
        //Toast.makeText(this, "Service Destroyed .....", Toast.LENGTH_SHORT).show();
        System.out.println("399 Service Destroyed .....");
    }

    //since this is start service, return null (used for bind service)
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

