package com.example.imgod.md_3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imgod on 2016/3/11.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Activity context;
    private List<String> str_list;

    public MyAdapter(Activity context, List<String> str_list) {
        this.context = context;
        this.str_list = str_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_main.setText(str_list.get(position));
    }

    @Override
    public int getItemCount() {
        return str_list == null ? 0 : str_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_main;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_main = (TextView) itemView.findViewById(R.id.txt_main);
        }
    }
}
