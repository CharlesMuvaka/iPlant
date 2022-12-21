package com.example.teamenvironmentkenya.adapters.recyclerViews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamenvironmentkenya.R;
import com.example.teamenvironmentkenya.VendorsActivity;
import com.example.teamenvironmentkenya.models.Vendor;

import java.io.Serializable;
import java.util.List;

public class VendorRecAdapter extends RecyclerView.Adapter<VendorRecAdapter.MyHolder> {
    private final List<Vendor> allVendors;
    private final Context context;

    public VendorRecAdapter(List<Vendor> allVendors, Context context) {
        this.allVendors = allVendors;
        this.context = context;
    }

    @NonNull
    @Override
    public VendorRecAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_vendor, parent, false);

        return new VendorRecAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorRecAdapter.MyHolder holder, int position) {
        holder.setData(allVendors.get(position));

    }

    @Override
    public int getItemCount() {
        return allVendors.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name, description, location;
        View image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.vendor_name);
            description = itemView.findViewById(R.id.vendor_status);
            image = itemView.findViewById(R.id.image);
            int position = getLayoutPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VendorsActivity.class);
                    intent.putExtra("allVendors", (Serializable) allVendors);
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }

        public void setData(Vendor vendor) {
            name.setText(vendor.getName());
            description.setText(vendor.getLocation());
        }
    }
}
