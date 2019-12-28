package com.akshobhya.Counter_Basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private int mcount=0;
    private TextView textview_show_count;
    @Override
    protected
    void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","Hey");
        textview_show_count = (TextView) findViewById(R.id.textView_show_count);

    }

    public void showToast(View view)
    {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();

    }

    public void countUp(View view)
    {
    mcount++;
    textview_show_count.setText(Integer.toString(mcount));
    }
}
