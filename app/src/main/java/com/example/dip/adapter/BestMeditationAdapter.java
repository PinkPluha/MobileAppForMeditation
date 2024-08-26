package com.example.dip.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dip.R;
import com.example.dip.best_meditation.Meditations;
import com.example.dip.model.CategoryTopMeditation;

import java.util.ArrayList;
import java.util.List;

public class BestMeditationAdapter extends RecyclerView.Adapter<BestMeditationAdapter.BestMeditationViewHolder> {

    Context context;
    List<CategoryTopMeditation> bestMeditations;

    public BestMeditationAdapter(Context context, List<CategoryTopMeditation> bestMeditations) {
        this.bestMeditations = bestMeditations;
        this.context = context;
    }

    @NonNull
    @Override
    public BestMeditationAdapter.BestMeditationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bestMeditationItems = LayoutInflater.from(context).inflate(R.layout.viewholder_best_meditation, parent, false);
        return new BestMeditationAdapter.BestMeditationViewHolder(bestMeditationItems);
    }

    @Override
    public void onBindViewHolder(@NonNull BestMeditationAdapter.BestMeditationViewHolder holder, int position) {
        holder.meditationBg.setCardBackgroundColor(Color.parseColor(bestMeditations.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(bestMeditations.get(position).getImg(), "drawable", context.getPackageName());
        holder.pic.setImageResource(imageId);

        holder.titleTxt.setText(bestMeditations.get(position).getName());
        holder.timeTxt.setText(bestMeditations.get(position).getTime()+" минут");
        holder.categoryTxt.setText(bestMeditations.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return bestMeditations.size();
    }

    public static final class BestMeditationViewHolder extends RecyclerView.ViewHolder {
        CardView meditationBg;
        TextView titleTxt, timeTxt, categoryTxt;
        ImageView pic;

        public BestMeditationViewHolder(@NonNull View itemView) {
            super(itemView);
            meditationBg = itemView.findViewById(R.id.meditationBg);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            categoryTxt=itemView.findViewById(R.id.categoryTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
