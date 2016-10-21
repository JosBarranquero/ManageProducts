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
 * Completely efficient Adapter
 */
public class ProductAdapterC extends ArrayAdapter<Product> {
    private Context context;

    public ProductAdapterC(Context context) {
        super(context, R.layout.item_list_product, ((ManageProducts_Application) context.getApplicationContext()).getProducts());
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ProductHolder productHolder;

        if (item == null) {
            // 1. Create Inflater object and initialise it from the Context casted to LayoutInflater
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            // LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 2. Inflate the view. Create into system memory the View object which contains the widgets defined in the XML file
            // If the second parameter is null, it will create a RelativeLayout inside the ListView. View hierarchy
            item = layoutInflater.inflate(R.layout.item_list_product, null);

            productHolder = new ProductHolder();


            // 3. Set variables to Widget with findViewById()
            productHolder.imgProduct = (ImageView) item.findViewById(R.id.imgProduct);
            productHolder.txvProductName = (TextView) item.findViewById(R.id.txvProductName);
            productHolder.txvProductStock = (TextView) item.findViewById(R.id.txvProductStock);
            productHolder.txvProductPrice = (TextView) item.findViewById(R.id.txvProductPrice);

            item.setTag(productHolder);
        } else {
            productHolder = (ProductHolder) item.getTag();
        }

        // 4. Assign data to Adapter
        productHolder.imgProduct.setImageResource(getItem(position).getmImage());
        productHolder.txvProductName.setText(getItem(position).getmName());
        productHolder.txvProductStock.setText(getItem(position).getFormattedStock());
        productHolder.txvProductPrice.setText(getItem(position).getFormattedPrice());

        // 5. Set different colour for odd positions
        if (position % 2 != 0) {
            item.setBackgroundResource(R.color.colorPrimary);
        } else {
            item.setBackgroundResource(R.color.colorWhite);
        }

        return item;
    }

    // Internal class that contains the XML file Widgets
    class ProductHolder {
        ImageView imgProduct;
        TextView txvProductName;
        TextView txvProductStock;
        TextView txvProductPrice;
    }
}
