package com.sa_sh.sepehr.moshtarakapp.Utills;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;

import com.sa_sh.sepehr.moshtarakapp.R;

/**
 * Created by Leon on 12/13/2017.
 */

public class CustomTab {
    private CustomTabsClient mClient;
    private String url;
    private Context context;

    public CustomTab(String url, Context context) {
        this.url = url;
        this.context = context;
        ShowCustomTab();
    }

    public void ShowCustomTab() {
        CustomTabsClient.bindCustomTabsService(context, "com.android.chrome", new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                mClient = client;
                mClient.warmup(0);
                CustomTabsSession session = mClient.newSession(new CustomTabsCallback());
                session.mayLaunchUrl(Uri.parse(url), null, null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mClient = null;
            }
        });
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(context.getResources().getColor(R.color.colorPrimaryDark));
        builder.setStartAnimations(context, R.anim.slide_up_info, R.anim.no_change);
        builder.setExitAnimations(context, R.anim.no_change, R.anim.slide_down_info);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.intent.setPackage("com.android.chrome");
        customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
