package com.example.nzse;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.io.File;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Immobilie> listdata;


    // RecyclerView recyclerView;
    public RecyclerViewAdapter(ArrayList<Immobilie> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.searchrow, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Immobilie myData = listdata.get(position);
        holder.descriptionText.setText(listdata.get(position).getDescription());
        Resources res = holder.itemView.getContext().getResources();


        String pictureName ="p"+myData.getPicture();
        int id = res.getIdentifier(pictureName, "drawable", holder.itemView.getContext().getPackageName());
        holder.imageView.setImageResource(id);

        //holder.imageView.setImageDrawable();



        if (listdata.get(position).isIntrested())
            holder.relativeLayout.setBackgroundColor(Color.rgb(255, 255, 0));
        else
            holder.relativeLayout.setBackgroundColor(Color.rgb(255, 255, 255));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), Estate.class)
                        .putExtra("Estate0", listdata.get(position));
                v.getContext().startActivity(i);
            }
        });

        holder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(v.getContext(), "Long Clicked", Toast.LENGTH_SHORT).show();

                listdata.get(position).setIntrested(!listdata.get(position).isIntrested());
                RecyclerViewAdapter.this.notifyDataSetChanged();

                return true;
            }
        });


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView descriptionText;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);


            this.imageView = (ImageView) itemView.findViewById(R.id.pictureForRow);
            this.descriptionText = (TextView) itemView.findViewById(R.id.DescriptionTextRow);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.searchRowItem);
        }
    }
}

