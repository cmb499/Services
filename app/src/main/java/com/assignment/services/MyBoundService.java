//package com.assignment.services;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//
///**
// * Created by Careena on 10/31/16.
// */
//public class MyBoundService extends Service {
//
//    private final IBinder mBinder = new LocalService();
//
//    public class LocalService extends Binder{
//
//        MyBoundService getService(){
//            return MyBoundService.this;
//        }
//
//    }
//
//    public String getFirstMessage(){
//
//        return "First Message - Welcome";
//    }
//
//    public String getSecondMessage(){
//
//        return "Second Message";
//    }
//
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return mBinder;
//    }
//}
