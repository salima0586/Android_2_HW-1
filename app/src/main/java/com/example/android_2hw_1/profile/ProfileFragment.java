package com.example.android_2hw_1.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android_2hw_1.R;
import com.example.android_2hw_1.board.Prefs;
import com.google.android.material.textfield.TextInputEditText;


public
class ProfileFragment extends Fragment {

    private ImageView user_photo;
    private TextInputEditText et_userName;


    @Override
    public
    boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.clear_options) {
            Prefs.clearData();
        }
        return super.onOptionsItemSelected( item );
    }

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
        user_photo = view.findViewById( R.id.userimage );
        et_userName = view.findViewById( R.id.et_user_name );

        selectPhoto();
        etActions();

    }

    @Override
    public
    void onStart() {
        super.onStart();
        profileData();
    }

    private
    void profileData() {
        if (Prefs.getProfilePhoto() != null) {
            Glide.with( requireContext() )
                    .load( Prefs.getProfilePhoto() )
                    .circleCrop()
                    .into( user_photo );
        } else {
        }
        if (Prefs.getUserName() != null) {
            et_userName.setText( Prefs.getUserName() );
        } else {
        }
    }

    private
    void selectPhoto() {
        ActivityResultLauncher<Intent> launch = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Uri selected = data.getData();
//                user_photo.setImageURI( selected );

                Prefs.saveProfilePhoto( String.valueOf( selected ) );
                Glide.with( requireContext() )
                        .load( selected )
                        .circleCrop()
                        .into( user_photo );

            }
        } );

        user_photo.setOnClickListener( v -> {
            Intent intent = new Intent( Intent.ACTION_PICK );
            intent.setType( "image/" );
            launch.launch( intent );
        } );
    }

    @Override
    public
    void onDestroy() {
        super.onDestroy();
        etActions();
    }

    private
    void etActions() {
        et_userName.setOnEditorActionListener( (v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Prefs.saveUserName( et_userName.getText().toString() );
            }
            return false;
        } );
    }
}