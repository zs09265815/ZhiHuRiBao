package com.example.zuoye2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.zuoye2.R;
import com.example.zuoye2.base.TouchCallBack;
import com.example.zuoye2.bean.Gold_bean;

import java.util.ArrayList;
import java.util.Collections;

public class GoldDateRecviewAdapter extends RecyclerView.Adapter<GoldDateRecviewAdapter.ViewHolder>implements TouchCallBack {
    private Context context;
    private ArrayList<Gold_bean> list;

    public GoldDateRecviewAdapter(Context context, ArrayList<Gold_bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GoldDateRecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=View.inflate(context,R.layout.fragment_gold_dates_frangment,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoldDateRecviewAdapter.ViewHolder holder, int position) {
        final Gold_bean gold_bean = list.get(position);
        holder.tv.setText(gold_bean.getName());
        holder.add.setChecked(gold_bean.isSelected());
        holder.add.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gold_bean.setSelected(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        list.remove(position);
        notifyItemRemoved(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private SwitchCompat add;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.gotv);
            add = itemView.findViewById(R.id.goadd);
        }
    }
}
