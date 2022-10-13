package com.a_23_59.mvvmwithretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    List<DataItem> dataItems;

    public ArticlesAdapter(List<DataItem> dataItems){

        this.dataItems=new ArrayList<>(dataItems);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindView(dataItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        private TextView description;

        private TextView source;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            title=itemView.findViewById(R.id.tv_title);

            description=itemView.findViewById(R.id.tv_description);

            source=itemView.findViewById(R.id.tv_source);
        }

        public void bindView(DataItem dataItem){

            title.setText(dataItem.getTitle());

            String modifiedDescription=dataItem.getDescription().isEmpty() ? "description is empty "  : dataItem.getDescription();

            description.setText(modifiedDescription);

            source.setText(dataItem.getSource());

        }
    }
}
