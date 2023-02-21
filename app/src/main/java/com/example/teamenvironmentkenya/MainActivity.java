package com.example.teamenvironmentkenya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.teamenvironmentkenya.adapters.recyclerViews.TreeRecAdapter;
import com.example.teamenvironmentkenya.adapters.recyclerViews.VendorRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivityMainBinding;
import com.example.teamenvironmentkenya.databinding.BottomSheetBinding;
import com.example.teamenvironmentkenya.fragments.ShopFragment;
import com.example.teamenvironmentkenya.fragments.VendorsFragment;
import com.example.teamenvironmentkenya.models.Constants;
import com.example.teamenvironmentkenya.models.Tree;
import com.example.teamenvironmentkenya.models.Vendor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding bind;
    private SharedPreferences pref;
    private BottomSheetDialog dialog;
    private List<Tree> allTrees;
    private TreeRecAdapter adapter;
    private DatabaseClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        dialog = new BottomSheetDialog(this);
        createDialog();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(bind.frameLayout.getId(), new VendorsFragment());
        transaction.commit();

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        String name = pref.getString(Constants.USER_Name, null);

        allTrees = new ArrayList<>();
        client = DatabaseClient.getInstance(this);

        allTrees = client.TreeDao().getAllTrees();
        adapter = new TreeRecAdapter(allTrees, this);

        bind.image2.setOnClickListener(this);
        bind.search1.setQueryHint("Search vendor");
        bind.vendors.setText("Welcome " + name + "!!");

        bind.image3.setOnClickListener(view -> bind.drawer.openDrawer(GravityCompat.START));
        bind.navView.bringToFront();
        bind.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                bind.drawer.closeDrawer(GravityCompat.START);
                switch(item.getItemId()){
                    case R.id.home:
                        replaceFragment(new VendorsFragment());
                        break;
                    case R.id.shop:
                        replaceFragment(new ShopFragment());
                        break;
                        case R.id.history:
                        startActivity(new Intent(MainActivity.this, CustomerOrderActivity.class));
                        break;
                    case R.id.settings:
                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

    }

    private void createDialog() {
        BottomSheetBehavior behavior;
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null, false);
        BottomSheetBinding binding = BottomSheetBinding.inflate(getLayoutInflater(), null, false);
        binding.recView.setAdapter(adapter);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setHasFixedSize(true);

        dialog.setContentView(view);

        behavior = BottomSheetBehavior.from((View) view.getParent());
        behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        CoordinatorLayout layout = view.findViewById(R.id.coordinate);
        assert layout != null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(bind.frameLayout.getId(), fragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(bind.frameLayout.getId(), new VendorsFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        if(view == bind.image2){
            dialog.show();
        }
    }
}