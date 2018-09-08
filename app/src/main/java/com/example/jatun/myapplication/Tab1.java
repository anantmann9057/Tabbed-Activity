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


public class Tab1 extends Fragment {
    WebView wb;
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
            wb.goBack();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.tab1,container,false);
        View view=inflater.inflate(R.layout.tab1,container,false);
        wb=(WebView)view.findViewById(R.id.web1);
        wb.setWebViewClient(new WebViewClient());
        CookieManager.getInstance().setAcceptCookie(true);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebChromeClient(new WebChromeClient());
        wb.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && wb.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }

                return false;
            }
        });
        wb.loadUrl("http://www.google.com");
        return view;
    }
}
