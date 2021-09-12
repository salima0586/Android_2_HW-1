package com.example.android_2hw_1;

import android.app.Application;

import com.example.android_2hw_1.board.Prefs;

public
class App extends Application {

    public static
    Prefs prefs;

    @Override
    public
    void onCreate() {
        super.onCreate();
        prefs = new Prefs( this );
    }
}
