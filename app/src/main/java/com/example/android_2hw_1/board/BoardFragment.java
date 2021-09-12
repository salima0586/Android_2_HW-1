package com.example.android_2hw_1.board;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_2hw_1.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import org.jetbrains.annotations.NotNull;


public
class BoardFragment extends Fragment implements Finish{


    DotsIndicator dotsIndicator;
    ViewPager2 viewPager2;
    BoardAdapter boardAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dotsIndicator = getView().findViewById(R.id.dots_indicator);
        viewPager2 =  getView().findViewById(R.id.view_pager);
        boardAdapter = new BoardAdapter();
        viewPager2.setAdapter(boardAdapter);
        dotsIndicator.setViewPager2(viewPager2);


        boardAdapter.setOpenHome(this);


        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }


    private void navigate() {
        new Prefs(requireContext()).saveBoardsState();
        NavController navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment);
        navController.navigateUp();
    }

    @Override
    public void btnFinishClick() {
        navigate();
    }
}