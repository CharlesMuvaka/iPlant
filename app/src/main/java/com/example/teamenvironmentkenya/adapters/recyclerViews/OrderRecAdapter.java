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
import com.example.teamenvironmentkenya.TreeActivity;
import com.example.teamenvironmentkenya.models.Order;

import java.io.Serializable;
import java.util.List;

public class OrderRecAdapter extends RecyclerView.Adapter<OrderRecAdapter.MyHolder> {
    private final List<Order> allOrders;
    private final Context context;

    public OrderRecAdapter(List<Order> allOrders, Context context) {
        this.allOrders = allOrders;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderRecAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_tree, parent, false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRecAdapter.MyHolder holder, int position) {
        holder.setData(allOrders.get(position));
    }

    @Override
    public int getItemCount() {
        return allOrders.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name, description, location;
        View image;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
            int position = getLayoutPosition();

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(context, TreeActivity.class);
                    intent.putExtra("allOrders", (Serializable) allOrders);
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }

        public void setData(Order order){

        }

    }

}
