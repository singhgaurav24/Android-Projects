package com.example.login;

import android.app.Application;

import com.backendless.Backendless;

public class LoginApplication extends Application
{


public static final String APPLICATION_ID = "8A140B8E-69C4-7B24-FF97-2071FCED8000";
    public static final String API_KEY = "13B9F27D-5B84-4E2C-B8E3-DF179597D748";
    public static final String SERVER_URL = "https://api.backendless.com";
    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(),
                APPLICATION_ID,
                API_KEY);
    }

}

