package com.example.bookingfilght.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bookingfilght.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder>{

    private int selectedItemIconInit;
    private int selectedItemTextInit;

    private int normalItemIconInit;
    private int normalItemTextInit;

    private Drawable icon;
    private String title;

    public SimpleItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        holder.icon.setImageDrawable(icon);

        holder.title.setTextColor(isChecked ? selectedItemTextInit : normalItemTextInit);
        holder.icon.setColorFilter(isChecked ? selectedItemIconInit : normalItemIconInit);
    }

    public SimpleItem withSelectedItemIconInit(int selectedItemIconInit){
        this.selectedItemIconInit = selectedItemIconInit;
        return this;
    }

    public SimpleItem withSelectedItemTextInit(int selectedItemTextInit){
        this.selectedItemTextInit = selectedItemTextInit;
        return this;
    }

    public SimpleItem withIconInit(int normalItemIconInit){
        this.normalItemIconInit = normalItemIconInit;
        return this;
    }

    public SimpleItem withTextInit(int normalItemTextInit){
        this.normalItemTextInit = normalItemTextInit;
        return this;
    }



    static class ViewHolder extends DrawerAdapter.ViewHolder {

        private ImageView icon;
        private TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }

}
