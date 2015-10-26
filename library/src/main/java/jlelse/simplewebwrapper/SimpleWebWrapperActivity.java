/*
 *    Copyright 2015 Jan-Lukas Else
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package jlelse.simplewebwrapper;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import jlelse.simpleui.SimpleActivity;

public abstract class SimpleWebWrapperActivity extends SimpleActivity {

    private WebView webView;

    public abstract String startUrl();

    public abstract boolean allowOnlyOwnPages();

    public abstract boolean shareFab();

    public abstract boolean customFab();

    public abstract Drawable customFabDrawable();

    public abstract View.OnClickListener customFabOnClickListener();

    @Override
    public boolean fab() {
        if (shareFab()) {
            return true;
        } else {
            return customFab();
        }
    }

    @Override
    public Drawable fabDrawable() {
        if (shareFab()) {
            return getResources().getDrawable(R.drawable.ic_share_white_24dp);
        } else {
            return customFabDrawable();
        }
    }

    @Override
    public View.OnClickListener fabOnClickListener() {
        if (shareFab()) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TITLE, webView.getTitle());
                    sendIntent.putExtra(Intent.EXTRA_TEXT, webView.getUrl());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
            };
        } else {
            return customFabOnClickListener();
        }
    }

    @Override
    public abstract boolean drawer();

    @Override
    public abstract int drawerMenuRes();

    @Override
    public abstract NavigationView.OnNavigationItemSelectedListener drawerMenuListener();

    @Override
    public abstract boolean optionsMenu();

    @Override
    public abstract int optionsMenuRes();

    @Override
    public abstract boolean toolbar();

    @Override
    public abstract int primaryColor();

    @Override
    public abstract int primaryColorDark();

    @Override
    public abstract int accentColor();

    @Override
    public void init() {
        webView = new WebView(this);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (allowOnlyOwnPages()) {
                    if (Uri.parse(url).getHost().equals(Uri.parse(startUrl()).getHost())) {
                        return false;
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        webView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContent(webView);

        webView.loadUrl(startUrl());
    }

    public WebView getWebView() {
        return webView;
    }
}
