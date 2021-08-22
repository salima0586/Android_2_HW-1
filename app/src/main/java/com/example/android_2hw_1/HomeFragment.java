package com.example.android_2hw_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public
class HomeFragment extends Fragment {

    private
    RecyclerView recyclerView;
    private
    FloatingActionButton fab;
    private Adapter adapter;

    private
    TextView time;

    @Override
    public
    void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        adapter = new Adapter();
    }

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_home, container, false );
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        recyclerView = view.findViewById( R.id.recycler );
        fab = view.findViewById( R.id.btn_fab );
        time = view.findViewById( R.id.txt_time );


        recyclerView.setAdapter( adapter );

        fab.setOnClickListener( v -> {
            NavController navController = Navigation.findNavController( requireActivity(), R.id.nav_host_fragment );
            navController.navigate( R.id.taskFragment );
        } );

        getParentFragmentManager().setFragmentResultListener( "task", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public
            void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {


                String text = result.getString( "text" );
                Model model = new Model( text );
                adapter.addItem( model );


            }
        } );


    }
}