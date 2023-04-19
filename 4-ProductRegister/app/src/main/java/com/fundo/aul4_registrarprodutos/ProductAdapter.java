package com.fundo.aul4_registrarprodutos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    ArrayList<Product> productArrayList;
    LayoutInflater layoutInflater;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return  productArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.product_item, parent, false);
        }

        Product produto = (Product) getItem(position);

        TextView nomeTextView = view.findViewById(R.id.inputName);
        nomeTextView.setText(produto.getName());

        TextView precoTextView = view.findViewById(R.id.inputPrice);
        precoTextView.setText(String.format("R$%.2f", produto.getPrice()));


        return view;
    }

}

