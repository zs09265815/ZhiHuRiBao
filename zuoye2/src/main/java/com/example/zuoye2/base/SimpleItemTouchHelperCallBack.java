package com.example.zuoye2.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    private TouchCallBack touchCallBack;

    public SimpleItemTouchHelperCallBack(TouchCallBack touchCallBack) {
        this.touchCallBack = touchCallBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
         int move = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
         int swipe = ItemTouchHelper.LEFT;
        return makeMovementFlags(move,swipe);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
       touchCallBack.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        touchCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }
}
