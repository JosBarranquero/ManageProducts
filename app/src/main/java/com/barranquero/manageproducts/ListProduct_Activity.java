package com.barranquero.manageproducts;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.barranquero.manageproducts.adapter.ProductAdapterA;
import com.barranquero.manageproducts.adapter.ProductAdapterB;
import com.barranquero.manageproducts.adapter.ProductAdapterC;
import com.barranquero.manageproducts.model.Product;

public class ListProduct_Activity extends ListActivity {
    // CASE 1: private ArrayAdapter<Product> adapter;
    // CASE 2: private ProductAdapterA adapter;
    // CASE 3: private ProductAdapterB adapter;
    private ProductAdapterC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        /* CASE 1: Unpersonalised Adapter
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, ((ManageProducts_Application)getApplication()).getProducts());
        getListView().setAdapter(adapter); */

        /* CASE 2: Personalised Adapter
        adapter = new ProductAdapterA(this);
        getListView().setAdapter(adapter); */

        /* CASE 3:
        adapter = new ProductAdapterB(this);
        getListView().setAdapter(adapter); */

        // CASE 4:
        adapter = new ProductAdapterC(this);
        getListView().setAdapter(adapter);
    }
}
