package com.shopify.task.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopify.task.R;
import com.shopify.task.helpers.TaskApplication;
import com.shopify.task.model.FavoriteArticleModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class FavoriteProductAdapter extends RecyclerView.Adapter<FavoriteProductAdapter.RecyclerViewHolder> {

    private List<FavoriteArticleModel> borrowModelList;

    public FavoriteProductAdapter(List<FavoriteArticleModel> borrowModelList) {
        this.borrowModelList = borrowModelList;
    }

    public interface OnItemDeleteListener{
        void onClick(FavoriteArticleModel borrowModel);
    }

    private OnItemDeleteListener onItemDeleteListener;

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final FavoriteArticleModel borrowModel = borrowModelList.get(position);
        holder.itemProductTitle.setText(borrowModel.getProductPrice());
        holder.itemProductType.setText(borrowModel.getProductType());
        holder.itemProductPrice.setText(String.format("%s$", borrowModel.getProductPrice()));
        holder.itemView.setTag(borrowModel);
        holder.addFavorivebtn.setText(TaskApplication.getContext().getString(R.string.delete_favorite));
        if (borrowModel.getImageUrl() != null) {
            Glide.with(holder.itemArticleImage.getContext())
                    .load(borrowModel.getImageUrl())
                    .into(holder.itemArticleImage);
        }
    }

    @Override
    public int getItemCount() {
        return borrowModelList.size();
    }

    public void addItems(List<FavoriteArticleModel> borrowModelList) {
        this.borrowModelList = borrowModelList;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemProductTitle;
        private TextView itemProductType;
        private TextView itemProductPrice;
        private ImageView itemArticleImage;
        private Button addFavorivebtn;

        RecyclerViewHolder(View view) {
            super(view);
            itemProductTitle = view.findViewById(R.id.item_product_title);
            itemProductType = view.findViewById(R.id.item_product_type);
            itemProductPrice = view.findViewById(R.id.item_product_description);
            itemArticleImage = view.findViewById(R.id.item_image);
            addFavorivebtn = view.findViewById(R.id.add_favorite_btn);
            addFavorivebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemDeleteListener != null)
                        onItemDeleteListener.onClick(borrowModelList.get(getAdapterPosition()));
                }
            });
        }
    }

    public void setOnItemDeleteListener(OnItemDeleteListener onItemDeleteListener) {
        this.onItemDeleteListener = onItemDeleteListener;
    }
}