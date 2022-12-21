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
import com.example.teamenvironmentkenya.models.Tree;

import java.io.Serializable;
import java.util.List;

public class TreeRecAdapter extends RecyclerView.Adapter<TreeRecAdapter.MyHolder> {
    private List<Tree> allTrees;
    private Context context;

    public TreeRecAdapter(List<Tree> allTrees, Context context) {
        this.allTrees = allTrees;
        this.context = context;
    }

    @NonNull
    @Override
    public TreeRecAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_rec_tree, parent, false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeRecAdapter.MyHolder holder, int position) {
        holder.setData(allTrees.get(position));
    }

    @Override
    public int getItemCount() {
        return allTrees.size();
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
                    intent.putExtra("allTrees", (Serializable) allTrees);
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }

        public void setData(Tree tree){
            name.setText(tree.getName());
            description.setText(tree.getDescription());
        }

    }
}
