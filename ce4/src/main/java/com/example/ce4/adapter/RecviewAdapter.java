package com.example.ce4.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ce4.R;
import com.example.ce4.Student;

import java.util.ArrayList;

public class RecviewAdapter extends RecyclerView.Adapter<RecviewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Student> list;

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public RecviewAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.recview_item,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapter.ViewHolder holder, final int position) {
        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText(list.get(position).getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onclick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private TextView tv1;
        private TextView tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
    private onclick click;

    public void setClick(onclick click) {
        this.click = click;
    }
    public interface onclick{
        void onclick(View view,int position);
    }
}
