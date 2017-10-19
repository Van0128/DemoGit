package com.example.anhchan.taskone.RecycleViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anhchan.taskone.Object.DataRecyclerView;
import com.example.anhchan.taskone.R;
import com.example.anhchan.taskone.RecycleView.RecycleViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhchan on 17/10/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<DataRecyclerView> listData = new ArrayList<DataRecyclerView>();

    public RecyclerViewAdapter(List<DataRecyclerView> listData) {
        this.listData = listData;
    }
    public void UpdateListData(List<DataRecyclerView> listUpdate){
        listData = listUpdate;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycler_view, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataRecyclerView dataView = listData.get(position);
        holder.txtRecycleview.setText(dataView.getNameStudent());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtRecycleview;
        public ImageButton imgbtnRemove;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtRecycleview = (TextView) itemView.findViewById(R.id.txtRecyclerview);
            imgbtnRemove =(ImageButton) itemView.findViewById(R.id.imgbtnRemove);
            imgbtnRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            RemoveItem(getPosition());
        }
    }
    public void RemoveItem(int position){  // remove one item in listData
        listData.remove(position);
        notifyItemRemoved(position);
    }
    public void AddItem(int position, DataRecyclerView dataRecycleView){  // add one item and data on listData
        listData.add(position, dataRecycleView);
        notifyItemInserted(position);
    }
}

