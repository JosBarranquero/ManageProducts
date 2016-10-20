package com.barranquero.manageproducts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Class which adds a product to our list
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public class AddProduct_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
    }
}
