package com.BmCollege.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class Attendence extends AppCompatActivity {

    private String WebAddress = "http://attendance.Bmiet.net/";
    private WebView webview;
    private ProgressBar progress;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setMax(100);
        webview = (WebView) findViewById(R.id.webview);

        webview.setWebViewClient(new HelpClient());

        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progres) {
                frameLayout.setVisibility(View.VISIBLE);
                progress.setProgress(progres);
                setTitle("Loading...");
                if (progres == 100) {
                    frameLayout.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                }
                super.onProgressChanged(view, progres);
            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setVerticalScrollBarEnabled(false);
        webview.loadUrl(WebAddress);
        progress.setProgress(0);

    }

    private class HelpClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            frameLayout.setVisibility(View.VISIBLE);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview.canGoBack()) {
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
