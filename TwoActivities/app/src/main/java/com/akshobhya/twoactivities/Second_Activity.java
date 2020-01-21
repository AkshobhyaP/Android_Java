package com.akshobhya.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private EditText reply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView_message=findViewById(R.id.revieved_message);
        textView_message.setText(message);
        reply=findViewById(R.id.edittext_second_reply);

    }

    public void second_reply(View view) {
        String reply_back=reply.getText().toString();
        Intent reply_intent=new Intent();
        reply_intent.putExtra(EXTRA_REPLY,reply_back);
        setResult(RESULT_OK,reply_intent);
        finish();
    }
}
