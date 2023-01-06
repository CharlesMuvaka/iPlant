package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.ActivitySplashBinding;
import com.example.teamenvironmentkenya.models.Tree;
import com.example.teamenvironmentkenya.models.Vendor;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        Vendor vendor = new Vendor("Matthew Ochanda", "0763000000", "o@gmail.com", "Imara daima");
        Vendor vendor1 = new Vendor("Kenny Rodgers", "0763000000", "o@gmail.com", "Karen junction");
        Vendor vendor2 = new Vendor("Matthew Omondi", "0763000000", "o@gmail.com", "Ongata Rongai");
        Vendor vendor3 = new Vendor("Dennis Kioko", "0763000000", "o@gmail.com", "Git merge");
        Vendor vendor4 = new Vendor("Victoria Amanda", "0763000000", "o@gmail.com", "Ole lenku");
        Vendor vendor5 = new Vendor("Gilbert Ochieng", "0763000000", "o@gmail.com", "Kiserian");
        Vendor vendor6 = new Vendor("Charles Ndirang'u", "0763000000", "o@gmail.com", "Kayole East");
        Vendor vendor7 = new Vendor("Paul Gitonga", "0763000000", "o@gmail.com", "Donholm stage");
        Vendor vendor8 = new Vendor("Fidelis Nyagothie", "0763000000", "o@gmail.com", "Utawala East");
        Vendor vendor9 = new Vendor("Rose Chari", "0763000000", "o@gmail.com", "Ngong Road");

        Tree tree = new Tree("Acacia", "Carrica Pappaya");
        tree.setImage(R.drawable.seed1);
        Tree tree1 = new Tree("Eucalyptus", "Shade Tree");
        tree1.setImage(R.drawable.seed2);
        Tree tree2 = new Tree("Sycamore", "Cash crop tree");
        tree2.setImage(R.drawable.seed3);
        Tree tree3 = new Tree("Coconut", "Cash crop tree");
        tree3.setImage(R.drawable.seed4);
        Tree tree4 = new Tree("Blue gum", "Shade Tree");
        Tree tree5 = new Tree("Ginkgo", "Shade Tree");
        Tree tree6 = new Tree("Weeping Willow", "Cash crop tree");
        Tree tree7 = new Tree("Giant Sequoia", "Cash crop tree");
        Tree tree8 = new Tree("European Ash", "Carrica Pappaya");
        Tree tree9 = new Tree("White Oak", "Carrica Pappaya");


        List<Vendor> allVendors = new ArrayList<>();
        allVendors = DatabaseClient.getInstance(this).VendorDao().getAllVendors();

        if (allVendors.size() == 0){
            DatabaseClient.getInstance(this).TreeDao().addTree(tree, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9);
            DatabaseClient.getInstance(this).VendorDao().addVendor(vendor, vendor1,vendor2,vendor3,vendor4,vendor5,vendor6, vendor7, vendor8, vendor9);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}