package com.example.android_2hw_1.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_2hw_1.R;

import java.util.ArrayList;

public
class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Model> list = new ArrayList<>();


    public void addItem(Model model){
        list.add(model );
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public
    ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_item,parent,false );
        return new ViewHolder( view );
    }

    @Override
    public
    void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get( position ));

        if (position%2==0){
            holder.itemView.setBackgroundColor( Color.WHITE );
        } else {
            holder.itemView.setBackgroundColor( Color.BLACK );
        }


        holder.itemView.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public
            boolean onLongClick(View v) {
                AlertDialog.Builder alerdialog = new AlertDialog.Builder( v.getContext() );
                alerdialog.setMessage( "Вы действительно хотите удалить?" );
                alerdialog.setTitle( "Внимание!" );
                alerdialog.setPositiveButton( "ДА", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialog, int which) {
                        list.remove( position );
                        notifyDataSetChanged();
                    }
                } );
                alerdialog.setNegativeButton( "НЕТ", new DialogInterface.OnClickListener() {
                    @Override
                    public
                    void onClick(DialogInterface dialog, int which) {

                    }
                } );
                alerdialog.show();
                return false;
            }
        } );
    }

    @Override
    public
    int getItemCount() {
        return list.size();
    }

    public
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView person;

        public
        ViewHolder(@NonNull View itemView) {
            super( itemView );

            person = itemView.findViewById( R.id.txt_text );
        }

        public
        void onBind(Model model) {
            person.setText( model.getPerson() );
        }
    }
}
