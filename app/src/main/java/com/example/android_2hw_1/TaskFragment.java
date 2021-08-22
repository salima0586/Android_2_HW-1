package com.example.android_2hw_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public
class TaskFragment extends Fragment {


    private
    EditText edText;


    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_task, container, false );
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        edText = view.findViewById( R.id.ed_text );

        view.findViewById( R.id.btn_save ).setOnClickListener( v -> {
            String text = edText.getText().toString();


            Bundle bundle = new Bundle();
            bundle.putString( "text", text );
            getParentFragmentManager().setFragmentResult( "task", bundle );
            NavController navController = Navigation.findNavController( requireActivity(), R.id.nav_host_fragment );
            navController.navigateUp();

        } );
    }
}