package com.akshobhya.implicit_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edittext_website;
    private EditText edittext_location;
    private EditText edittext_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext_website=findViewById(R.id.website_edittext);
        edittext_location=findViewById(R.id.location_edittext);
        edittext_share=findViewById(R.id.share_edittext);
    }

    public void openLocation(View view) {
        String location=edittext_location.getText().toString();
        Uri locate=Uri.parse("geo:0,0?q="+location);
        Intent intent=new Intent(Intent.ACTION_VIEW,locate);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String text=edittext_share.getText().toString();
        String mime_type="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mime_type)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }

    public void openWebsite(View view) {
        String url=edittext_website.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
}
