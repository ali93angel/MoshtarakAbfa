package com.sa_sh.sepehr.moshtarakapp.BaseItems;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sa_sh.sepehr.moshtarakapp.Activities.BaseInfoActivity;
import com.sa_sh.sepehr.moshtarakapp.Activities.HomeActivity;
import com.sa_sh.sepehr.moshtarakapp.Activities.SignAccountActivity;
import com.sa_sh.sepehr.moshtarakapp.Adapters.NavigationCustomAdapter;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.CustomTab;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class ActivityBase extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawer;
    Toolbar toolbar;
    Typeface typeface;
    NavigationCustomAdapter adapter;
    private ListView drawerList;
    List<NavigationCustomAdapter.DrawerItem> dataList;
    private UiElementInActivity uiElementInActivity;
    private final String url = "http://www.tpww.ir/";

    protected abstract UiElementInActivity getUiElementsInActivity();

    protected abstract void initialize();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        super.onCreate(savedInstanceState);
        uiElementInActivity = getUiElementsInActivity();
        overridePendingTransition(R.anim.slide_up_info, R.anim.no_change);
        setContentView(uiElementInActivity.getContentViewId());
        initializeBase();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });
        initialize();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }
    void setOnDrawerItemClick(){
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int position,
                                    long id) {
                setItemsColor(drawer, position);
                if (position != 0) {
                    for (int i = 0; i < drawerList.getChildCount(); i++) {
                        if (position == i) {
                            drawerList.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.red2));
                        } else {
                            drawerList.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.white));
                        }
                    }
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    new CustomTab(url, ActivityBase.this);
                } else if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), BaseInfoActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                } else if (position == 5) {
                } else if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), SignAccountActivity.class);
                    startActivity(intent);
                } else if (position == 7) {
                } else if (position == 8) {
                } else if (position == 9) {
                }
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_logout) {
            SharedPreferences appPrefs = getSharedPreferences("com.sa_sh.sepehr.moshtarakapp.user_preferences", MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = appPrefs.edit();
            prefsEditor.putString("file_number", "");
            prefsEditor.putString("account_number", "");
            prefsEditor.commit();
            Toast.makeText(getApplicationContext(), getString(R.string.logout_successful), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setMenuBackground() {
        getLayoutInflater().setFactory(new LayoutInflater.Factory() {
            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                if (name.equalsIgnoreCase("com.android.internal.view.menu.IconMenuItemView")) {
                    try {
                        // Ask our inflater to create the view
                        LayoutInflater f = getLayoutInflater();
                        final View view = f.createView(name, null, attrs);
                        // Kind of apply our own background
                        new Handler().post(new Runnable() {
                            public void run() {
                                view.setBackgroundResource(R.color.black);
                            }
                        });
                        return view;
                    } catch (InflateException e) {
                    } catch (ClassNotFoundException e) {
                    }
                }
                return null;
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeBase() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        dataList = new ArrayList<NavigationCustomAdapter.DrawerItem>();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        fillDrawerListView();
        setOnDrawerItemClick();
        typeface = Typeface.createFromAsset(getAssets(), "fonts/BYekan_3.ttf");
        setFont(this.drawer, typeface);
    }

    void fillDrawerListView() {
        dataList.add(new NavigationCustomAdapter.DrawerItem("", R.drawable.img_menu_logo));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.home), R.drawable.img_home));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.portal_connect), R.drawable.img_connect_to_portal));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.base_info), R.drawable.img_profile));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.transaction), R.drawable.img_transactions));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.update), R.drawable.img_update));
        SharedPreference sharedPreference = new SharedPreference(this);
        if (sharedPreference.CheckIsNotEmpty())
            dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.change_account), R.drawable.img_registration));
        else
            dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.account), R.drawable.img_registration));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.recovery_code), R.drawable.img_recovery_code));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.connect), R.drawable.img_contact_us));
        dataList.add(new NavigationCustomAdapter.DrawerItem(getString(R.string.exit), R.drawable.img_exit));
        adapter = new NavigationCustomAdapter(this, R.layout.item_navigation, dataList);
        drawerList.setAdapter(adapter);
    }

    public void setFont(ViewGroup viewTree, Typeface typeface) {
        Stack<ViewGroup> stackOfViewGroup = new Stack<ViewGroup>();
        stackOfViewGroup.push(viewTree);
        while (!stackOfViewGroup.isEmpty()) {
            ViewGroup tree = stackOfViewGroup.pop();
            for (int i = 0; i < tree.getChildCount(); i++) {
                View child = tree.getChildAt(i);
                if (child instanceof ViewGroup) {
                    stackOfViewGroup.push((ViewGroup) child);
                } else if (child instanceof Button) {
                    ((Button) child).setTypeface(typeface);
                } else if (child instanceof EditText) {
                    ((EditText) child).setTypeface(typeface);
                } else if (child instanceof TextView) {
                    ((TextView) child).setTypeface(typeface);
                } else if (child instanceof ListView) {
                    TextView textView = (TextView) ((ListView) child).getChildAt(0);
                    textView.setTypeface(typeface);
                    textView = (TextView) ((ListView) child).getChildAt(2);
                    textView.setTypeface(typeface);
                }
            }
        }
    }

    public void setItemsColor(ViewGroup viewTree, int selected) {
        Stack<ViewGroup> stackOfViewGroup = new Stack<ViewGroup>();
        stackOfViewGroup.push(viewTree);
        while (!stackOfViewGroup.isEmpty()) {
            ViewGroup tree = stackOfViewGroup.pop();
            for (int i = 0; i < tree.getChildCount(); i++) {
                View child = tree.getChildAt(i);
                if (child instanceof ViewGroup) {
                    stackOfViewGroup.push((ViewGroup) child);
                } else if (child instanceof TextView) {
                    if (child.getId() == R.id.textViewTitle) {
                        ((TextView) child).setTextColor(getResources().getColor(R.color.gray2));
                    }
                }
            }
        }

        View view = drawerList.getChildAt(selected);
        TextView textView = (TextView) view.findViewById(R.id.textViewTitle);
        textView.setTextColor(getResources().getColor(R.color.white));
    }

}
