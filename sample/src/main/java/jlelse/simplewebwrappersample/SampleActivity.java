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

package jlelse.simplewebwrappersample;

import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import jlelse.simplewebwrapper.SimpleWebWrapperActivity;

public class SampleActivity extends SimpleWebWrapperActivity {


    @Override
    public String startUrl() {
        return "http://www.yahoo.com";
    }

    @Override
    public boolean allowOnlyOwnPages() {
        return true;
    }

    @Override
    public boolean shareFab() {
        return true;
    }

    @Override
    public boolean customFab() {
        return false;
    }

    @Override
    public Drawable customFabDrawable() {
        return null;
    }

    @Override
    public View.OnClickListener customFabOnClickListener() {
        return null;
    }

    @Override
    public boolean drawer() {
        return true;
    }

    @Override
    public int drawerMenuRes() {
        return R.menu.drawer;
    }

    @Override
    public NavigationView.OnNavigationItemSelectedListener drawerMenuListener() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_home:
                        getWebView().loadUrl(startUrl());
                        break;
                    case R.id.drawer_news:
                        getWebView().loadUrl("http://news.yahoo.com");
                        break;
                }
                return true;
            }
        };
    }

    @Override
    public boolean optionsMenu() {
        return true;
    }

    @Override
    public int optionsMenuRes() {
        return R.menu.drawer;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_home:
                getWebView().loadUrl(startUrl());
                break;
            case R.id.drawer_news:
                getWebView().loadUrl("http://news.yahoo.com");
                break;
        }
        return true;
    }

    @Override
    public boolean toolbar() {
        return true;
    }

    @Override
    public int primaryColor() {
        return getResources().getColor(R.color.colorPrimary);
    }

    @Override
    public int primaryColorDark() {
        return getResources().getColor(R.color.colorPrimaryDark);
    }

    @Override
    public int accentColor() {
        return getResources().getColor(R.color.colorAccent);
    }
}
