package com.example.teamenvironmentkenya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.teamenvironmentkenya.adapters.recyclerViews.OrderRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivityCustomerOrderBinding;
import com.example.teamenvironmentkenya.models.Order;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class CustomerOrderActivity extends AppCompatActivity {
    private ActivityCustomerOrderBinding bind;
    private List<Order> customerOrders;
    private OrderRecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityCustomerOrderBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        customerOrders = DatabaseClient.getInstance(this).OrderDao().getUserOrders(1);
        if (customerOrders.isEmpty()){
            bind.empty.setVisibility(View.VISIBLE);
        }else{
            adapter = new OrderRecAdapter(customerOrders, this);
            bind.recView.setAdapter(adapter);
            bind.recView.setLayoutManager(new LinearLayoutManager(this));
            bind.recView.setHasFixedSize(true);
        }




        setNavigation(bind.bottom);
    }
    public void setNavigation(BottomNavigationView bottom){
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(CustomerOrderActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(CustomerOrderActivity.this, ShopActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        return true;
                    case R.id.settings:
                        Intent intent = new Intent(CustomerOrderActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

}