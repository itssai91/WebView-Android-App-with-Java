package com.app.onpraystorm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class WebviewActivity extends AppCompatActivity {

    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        CustomTabsIntent.Builder builderCustomTabs = new CustomTabsIntent.Builder();
        CustomTabsIntent intentCustomTabs = builderCustomTabs.build();
        intentCustomTabs.intent.setPackage("com.android.chrome");
        intentCustomTabs.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentCustomTabs.launchUrl(this, Uri.parse("http://live.onpray.co.kr/"));
    }
    @Override
    public void onResume(){
        super.onResume();
        a++;
        if (a==2){
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

    }

}