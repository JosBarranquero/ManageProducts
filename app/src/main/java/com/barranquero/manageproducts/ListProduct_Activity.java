package com.barranquero.manageproducts;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.barranquero.manageproducts.adapter.ProductAdapterC;

/**
 * Class which shows the product list
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public class ListProduct_Activity extends ListActivity {
    // CASE 1: private ArrayAdapter<Product> mAdapter;
    // CASE 2: private ProductAdapterA mAdapter;
    // CASE 3: private ProductAdapterB mAdapter;
    private ProductAdapterC mAdapter;
    private Button mBtnAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        /* CASE 1: Unpersonalised Adapter
        mAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, ((ManageProducts_Application)getApplication()).getProducts());
        getListView().setAdapter(mAdapter); */

        /* CASE 2: Personalised Adapter
        mAdapter = new ProductAdapterA(this);
        getListView().setAdapter(mAdapter); */

        /* CASE 3:
        mAdapter = new ProductAdapterB(this);
        getListView().setAdapter(mAdapter); */

        // CASE 4:
        mAdapter = new ProductAdapterC(this);
        getListView().setAdapter(mAdapter);

        mBtnAddProduct = (Button)findViewById(R.id.btnAddProduct);
        mBtnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListProduct_Activity.this, AddProduct_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new ProductAdapterC(this);
        getListView().setAdapter(mAdapter);
    }
}
