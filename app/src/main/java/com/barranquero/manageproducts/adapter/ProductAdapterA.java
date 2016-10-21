package com.barranquero.manageproducts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.barranquero.manageproducts.ManageProducts_Application;
import com.barranquero.manageproducts.R;
import com.barranquero.manageproducts.model.Product;

/**
 * Inefficient adapter
 */
public class ProductAdapterA extends ArrayAdapter<Product> {
    private Context context;

    public ProductAdapterA(Context context) {
        super(context, R.layout.item_list_product, ((ManageProducts_Application) context.getApplicationContext()).getProducts());
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgProduct;
        TextView txvProductName;
        TextView txvProductStock;
        TextView txvProductPrice;

        // 1. Create Inflater object and initialise it from the Context casted to LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        // LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Inflate the view. Create into system memory the View object which contains the widgets defined in the XML file
        // If the second parameter is null, it will create a RelativeLayout inside the ListView. View hierarchy
        View item = layoutInflater.inflate(R.layout.item_list_product, null);

        // 3. Set variables to Widget with findViewById()
        imgProduct = (ImageView)item.findViewById(R.id.imgProduct);
        txvProductName = (TextView)item.findViewById(R.id.txvProductName);
        txvProductStock = (TextView)item.findViewById(R.id.txvProductStock);
        txvProductPrice = (TextView)item.findViewById(R.id.txvProductPrice);

        // 4. Assign data to Adapter
        imgProduct.setImageResource(getItem(position).getmImage());
        txvProductName.setText(getItem(position).getmName());
        txvProductStock.setText(getItem(position).getFormattedStock());
        txvProductPrice.setText(getItem(position).getFormattedPrice());

        return item;
    }
}
