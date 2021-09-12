package com.example.android_2hw_1.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android_2hw_1.R;

public
class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private Finish finish;

    private String[] titles = new String[]{"Вас приветсвует Beaty studio", "Наши услуги", "Прайскурант"};
    private int[] imgLogo = new int[]{
//            R.drawable.barber, R.drawable.manicure, R.drawable.freeion
            R.raw.cofee, R.raw.makeup, R.raw.meditation
    };


    @NonNull
    @Override
    public
    ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.pager_board, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public
    void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind( position );


    }

    @Override
    public
    int getItemCount() {
        return titles.length;
    }

    public
    void setOpenHome(Finish finish) {
        this.finish = finish;
    }


    public
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        LottieAnimationView lottie_view;
        Button button, btn_skip;


        public
        ViewHolder(@NonNull View itemView) {
            super( itemView );
            txtTitle = itemView.findViewById( R.id.txt_title );
            lottie_view = itemView.findViewById( R.id.lottie_anim );
            button = itemView.findViewById( R.id.btn_finish );
            btn_skip = itemView.findViewById( R.id.btn_skip );

            btn_skip.setOnClickListener( v -> finish.btnFinishClick() );

            button.setOnClickListener( v -> finish.btnFinishClick() );
        }

        public void bind(int position) {
            txtTitle.setText( titles[position] );
            lottie_view.setAnimation( imgLogo[position] );

            if (position == 2) {
                btn_skip.setVisibility( View.GONE );
            } else {
                btn_skip.setVisibility( View.VISIBLE );
            }

            if (position == 2) {
                button.setVisibility( View.VISIBLE );
            } else {
                button.setVisibility( View.GONE );
            }

        }
    }
}

interface Finish {
    void btnFinishClick();
}
