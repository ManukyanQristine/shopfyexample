package com.shopify.task.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shopify.task.R;
import com.shopify.task.adapters.ProductsListAdapter;
import com.shopify.task.helpers.ApiManager;
import com.shopify.task.helpers.RoomRepo;
import com.shopify.task.model.Product;
import com.shopify.task.model.ResponseData;
import com.shopify.task.model.FavoriteArticleModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFragment extends Fragment {

    private ProductsListAdapter recyclerViewAdapter;
    private RoomRepo roomRepo;


    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        initView(view);
        getData();
        return view;
    }


    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new ProductsListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        roomRepo = new RoomRepo();

        recyclerViewAdapter.setOnItemClickListener(new ProductsListAdapter.OnItemClickListener() {
            @Override
            public void onClick(Product product) {
                addFavoriteArticle(product);
            }
        });
    }


    private void getData() {
        ApiManager.getInstance().provideProducts(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    recyclerViewAdapter.addItems(response.body().getProducts());
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addFavoriteArticle(Product product) {
        roomRepo.addBorrow(new FavoriteArticleModel(
                product.getId(),
                product.getTitle(),
                product.getProductType(),
                product.getVariants().get(0).getPrice(),
                product.getImage().getSrc()));
    }

}
