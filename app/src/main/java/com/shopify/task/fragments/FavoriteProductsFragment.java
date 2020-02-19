package com.shopify.task.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopify.task.R;
import com.shopify.task.adapters.FavoriteProductAdapter;
import com.shopify.task.helpers.RoomRepo;
import com.shopify.task.model.FavoriteArticleModel;
import com.shopify.task.viewmodels.FavoriteListViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductsFragment extends Fragment {

    private FavoriteListViewModel viewModel;
    private FavoriteProductAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    private RoomRepo roomRepo;

    public static FavoriteProductsFragment newInstance() {
        FavoriteProductsFragment fragment = new FavoriteProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new FavoriteProductAdapter(new ArrayList<FavoriteArticleModel>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        roomRepo = new RoomRepo();

        viewModel = ViewModelProviders.of(this).get(FavoriteListViewModel.class);

        viewModel.getItemAndPersonList().observe(getActivity(), new Observer<List<FavoriteArticleModel>>() {
            @Override
            public void onChanged(@Nullable List<FavoriteArticleModel> itemProduct) {

                recyclerViewAdapter.addItems(itemProduct);
            }
        });

        recyclerViewAdapter.setOnItemDeleteListener(new FavoriteProductAdapter.OnItemDeleteListener() {
            @Override
            public void onClick(FavoriteArticleModel borrowModel) {
                roomRepo.deleteItem(borrowModel);
            }
        });


    }
}