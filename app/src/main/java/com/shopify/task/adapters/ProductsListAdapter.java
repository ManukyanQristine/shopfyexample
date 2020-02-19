package com.shopify.task.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopify.task.R;
import com.shopify.task.model.Product;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.RecyclerViewHolder> {

    private List<Product> productList = new ArrayList<>();

    public interface OnItemClickListener {
        void onClick(Product product);
    }

    private OnItemClickListener onItemClickListener;

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.itemProductTitle.setText(product.getTitle());
        holder.itemProductType.setText(product.getProductType());
        holder.itemProductPrice.setText(product.getVariants().get(0).getPrice() + " $");
        holder.itemView.setTag(product);
        if (product.getImage() != null && product.getImage().getSrc() != null) {
            Glide.with(holder.imageView.getContext())
                    .load(product.getImage().getSrc())
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void addItems(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemProductTitle;
        private TextView itemProductType;
        private TextView itemProductPrice;
        private Button addFavorivebtn;
        private ImageView imageView;

        RecyclerViewHolder(View view) {
            super(view);
            itemProductTitle = view.findViewById(R.id.item_product_title);
            itemProductType = view.findViewById(R.id.item_product_type);
            itemProductPrice = view.findViewById(R.id.item_produc_price);
            addFavorivebtn = view.findViewById(R.id.add_favorite_btn);
            imageView = view.findViewById(R.id.item_image);
            addFavorivebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null)
                        onItemClickListener.onClick(productList.get(getAdapterPosition()));
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}