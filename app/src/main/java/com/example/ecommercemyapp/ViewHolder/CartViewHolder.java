package com.example.ecommercemyapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ecommercemyapp.Interface.ItemClickListener;
import com.example.ecommercemyapp.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName, txtProductPrice;
    private ItemClickListener itemClickListener;

    public CartViewHolder(View itemView) {
        super(itemView);

        txtProductName= itemView.findViewById(R.id.cart_product_name);
        txtProductPrice= itemView.findViewById(R.id.cart_product_price);
    }


    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
