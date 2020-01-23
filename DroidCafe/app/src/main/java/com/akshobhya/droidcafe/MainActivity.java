package com.akshobhya.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void donut_order(View view) {
        displayToast(getString(R.string.donut_order_message));
    }

    public void icecream_order(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void froyo_order(View view) {
        displayToast(getString(R.string.froyo_order_message));
    }
}
