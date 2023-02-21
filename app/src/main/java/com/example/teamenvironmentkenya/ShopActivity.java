package com.example.teamenvironmentkenya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.teamenvironmentkenya.adapters.recyclerViews.TreeRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivityShopBinding;
import com.example.teamenvironmentkenya.databinding.BottomSheetBinding;
import com.example.teamenvironmentkenya.models.Tree;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityShopBinding bind;
    private List<Tree> allTrees;
    private TreeRecAdapter adapter;
    private DatabaseClient client;
    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        dialog = new BottomSheetDialog(this);
        allTrees = new ArrayList<>();
        client = DatabaseClient.getInstance(this);

        allTrees = client.TreeDao().getAllTrees();
        adapter = new TreeRecAdapter(allTrees, this);

        bind.recView.setAdapter(adapter);
        bind.recView.setLayoutManager(new LinearLayoutManager(this));
        bind.recView.setHasFixedSize(true);
        createDialog();
        bind.ship.setOnClickListener(this);


    }

    private void createDialog() {
        BottomSheetBinding binding = BottomSheetBinding.inflate(getLayoutInflater());
        binding.recView.setAdapter(adapter);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setHasFixedSize(true);
        dialog.setContentView(binding.getRoot());
    }

    public void setNavigation(BottomNavigationView bottom){
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(ShopActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.shop:
                        return true;
                    case R.id.history:
                        startActivity(new Intent(ShopActivity.this, CustomerOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        Intent intent = new Intent(ShopActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (bind.ship == view){
            dialog.show();
        }
    }
}