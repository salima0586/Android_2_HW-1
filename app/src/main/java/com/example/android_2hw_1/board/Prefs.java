package com.example.android_2hw_1.board;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public
class Prefs {


    private static SharedPreferences preferences;

    public static void clearData(){
        preferences.edit().clear().apply();
    }

    public
    Prefs(Context context) {
        preferences = context.getSharedPreferences( "settings", Context.MODE_PRIVATE );
    }

    public static
    void saveBoardsState() {
        preferences.edit().putBoolean( "isShown", true ).apply();

    }

    public static
    boolean isShown() {
        return preferences.getBoolean( "isShown", false );
    }

    public static
    void saveProfilePhoto(String image) {
        preferences.edit().putString( "profilePhoto", image ).apply();
    }

    public static
    String getProfilePhoto() {
        return  preferences.getString( "profilePhoto", null ) ;
    }

    public static void saveUserName(String name){
        preferences.edit().putString( "userName",name ).apply();
    }

    public static String getUserName(){
        return preferences.getString( "userName",null );
    }



}
