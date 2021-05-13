package com.example.lesson10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class answers extends AppCompatActivity {
    TextView t1,t2,t3;
    double a,b,c;
    double x1,x2;
    WebView wv1;
    String stringUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        Intent gi = getIntent();
        a = gi.getDoubleExtra("a",1);
        b = gi.getDoubleExtra("b",1);
        c = gi.getDoubleExtra("c",1);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t3.setText("a="+a+" | b="+b+" | c="+c);
        x1 = -1*b + Math.sqrt(b*b-4*a*c);
        x1 = x1/(2*a);
        t1.setText("X1 = "+String.valueOf(x1));
        x2 = -1*b - Math.sqrt(b*b-4*a*c);
        x2 = x2/(2*a);
        t2.setText("X2 = "+String.valueOf(x2));
        wv1 = (WebView) findViewById(R.id.wv1);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setWebViewClient(new MyWebViewClient());
        stringUrl="https://www.google.com/search?q="+a+"x%5E2%2B"+b+"x%2B"+c+"&oq=x%5E2&aqs=chrome.0.69i59l3j69i57j0l2j69i61l2.3824j0j7&sourceid=chrome&ie=UTF-8";
        wv1.loadUrl(stringUrl);
    }

    public void back(View view) {
        Intent gi = getIntent();
        gi.putExtra("x1",x1);
        gi.putExtra("x2",x2);
        setResult(RESULT_OK,gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}