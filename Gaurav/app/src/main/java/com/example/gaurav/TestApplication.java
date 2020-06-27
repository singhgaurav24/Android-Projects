package com.example.gaurav;

import android.app.Application;

import com.backendless.Backendless;

public class TestApplication extends Application
{
    public static final String APPLICATION_ID = "E171936F-C1C0-9364-FF85-A65EE3DA2400";
    public static final String API_KEY = "8816D830-F63D-46BE-80B5-9B270F983D1D";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();


        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );

    }
}
