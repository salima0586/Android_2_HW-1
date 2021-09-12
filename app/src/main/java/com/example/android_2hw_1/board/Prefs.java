package com.example.android_2hw_1.board;

import android.content.Context;
import android.content.SharedPreferences;

public
class Prefs {


    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveBoardsState() {
        preferences.edit().putBoolean("isShown", true).apply();

    }

    public
    boolean isShown() {
        return preferences.getBoolean( "isShown",false );
    }
}
