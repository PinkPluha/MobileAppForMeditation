package com.example.dip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dip.R;
import com.example.dip.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categoties;

    public CategoryAdapter(Context context, List<Category> categoties) {
        this.context = context;
        this.categoties = categoties;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryTitle.setText(categoties.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categoties.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.category_title);
        }
    }
}
