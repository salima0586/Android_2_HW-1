package com.example.android_2hw_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toolbar;

import com.example.android_2hw_1.board.Prefs;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public
class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ArrayList<Integer> list = new ArrayList<>();


    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main );
        BottomNavigationView navView = findViewById( R.id.nav_view );


        navController = Navigation.findNavController( this,R.id.nav_host_fragment );
        NavigationUI.setupWithNavController( navView, navController );

        if (!Prefs.isShown()) navController.navigate(R.id.boardFragment);

    }

    @Override
    public
    boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.clear_data,menu );
        return super.onCreateOptionsMenu( menu );
    }
}