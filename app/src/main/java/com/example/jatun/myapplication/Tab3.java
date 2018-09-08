package com.example.jatun.myapplication;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Tab3 extends Fragment {
    WebView wb3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:{
                    wbGoBack();
                }break;
            }
        }

        private void wbGoBack() {
            wb3.goBack();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab3,container,false);
        wb3=(WebView)view.findViewById(R.id.web3);
        wb3.loadUrl("http://www.instagram.com");
        wb3.setWebChromeClient(new WebChromeClient());
        wb3.setWebViewClient(new WebViewClient());
        wb3.getSettings().setJavaScriptEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        wb3.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && wb3.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }

                return false;
            }
        });

        return view;
    }
}
