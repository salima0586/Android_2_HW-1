package com.example.android_2hw_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public
class ProfileFragment extends Fragment {

    private ImageView person;

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {

        return inflater.inflate( R.layout.fragment_frofile, container, false );
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        person = view.findViewById( R.id.person );


        ActivityResultLauncher<Intent> launch = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Uri selected = data.getData();
                person.setImageURI( selected );
            }
        } );

        person.setOnClickListener( v -> {
            Intent intent = new Intent( Intent.ACTION_PICK );
            intent.setType( "image/" );
            launch.launch( intent );

        } );
    }


}