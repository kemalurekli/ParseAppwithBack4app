package com.kemalurekli.parseapp;

import android.app.Application;

import com.parse.Parse;

public class ParseStarter extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("***********")
                // if desired
                .clientKey("**********")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
