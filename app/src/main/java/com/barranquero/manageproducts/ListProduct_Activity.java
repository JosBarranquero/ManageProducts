package com.barranquero.manageproducts;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.barranquero.manageproducts.model.Product;

public class ListProduct_Activity extends ListActivity {
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        // CASE 1: Unpersonalised Adapter
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, ((ManageProducts_Application)getApplication()).getProducts());
        getListView().setAdapter(adapter);
    }
}
