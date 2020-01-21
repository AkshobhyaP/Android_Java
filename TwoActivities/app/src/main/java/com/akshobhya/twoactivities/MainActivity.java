package com.akshobhya.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    private EditText main_edittext;
    public static final String LOG_TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_edittext=findViewById(R.id.main_edittext);
        mReplyHeadTextView = findViewById(R.id.revieved_message_header);
        mReplyTextView = findViewById(R.id.revieved_message_back);
        if(savedInstanceState!= null)
        {
            if(savedInstanceState.getBoolean("reply_visible"))
            {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_recieved"));
            }
        }
    }

    public void launch_second_activity(View view) {
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent= new Intent(this,Second_Activity.class);
        String message=main_edittext.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);

    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
    super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(Second_Activity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mReplyTextView.getVisibility()== View.VISIBLE) {
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_recieved",mReplyTextView.getText().toString());
        }
    }
}
