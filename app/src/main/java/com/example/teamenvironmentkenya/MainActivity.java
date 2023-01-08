package com.example.teamenvironmentkenya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import com.example.teamenvironmentkenya.adapters.recyclerViews.VendorRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivityMainBinding;
import com.example.teamenvironmentkenya.models.Constants;
import com.example.teamenvironmentkenya.models.Vendor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bind;
    private VendorRecAdapter adapter;
    private List<Vendor> allVendors;
    private DatabaseClient client;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        client = DatabaseClient.getInstance(this);
        allVendors = new ArrayList<>();
        allVendors = client.VendorDao().getAllVendors();

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        adapter = new VendorRecAdapter( allVendors, this);
        String name = pref.getString(Constants.USER_Name, null);


        bind.search1.setQueryHint("Search vendor");
        bind.vendors.setText("Welcome " + name + "!!");
        bind.myRecView.setAdapter(adapter);
        bind.myRecView.setLayoutManager(new LinearLayoutManager(this));
        bind.myRecView.setHasFixedSize(true);

        bind.image3.setOnClickListener(view -> bind.drawer.openDrawer(GravityCompat.START));

        setNavigation(bind.bottom);
    }

    public void setNavigation(BottomNavigationView bottom){
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(MainActivity.this, ShopActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(MainActivity.this, CustomerOrderActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}