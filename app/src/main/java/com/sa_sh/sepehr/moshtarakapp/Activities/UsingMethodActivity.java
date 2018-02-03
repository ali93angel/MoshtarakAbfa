package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.widget.ListView;

import com.sa_sh.sepehr.moshtarakapp.Adapters.LearningCustomAdapter;
import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;

import java.util.ArrayList;
import java.util.List;

public class UsingMethodActivity extends ActivityBase {
    ListView listViewLearningUsing;
    LearningCustomAdapter adapter;
    List<LearningCustomAdapter.DrawerItem> dataList;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.using_method_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        listViewLearningUsing = (ListView) findViewById(R.id.listViewLearningUsing);
        fillListViewLearningUsing();
    }

    void fillListViewLearningUsing() {
        dataList = new ArrayList<LearningCustomAdapter.DrawerItem>();
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_bath), R.drawable.btn_read));
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_washing), R.drawable.btn_read));
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_wc), R.drawable.btn_read));
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_watering), R.drawable.btn_read));
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_pool), R.drawable.btn_read));
        dataList.add(new LearningCustomAdapter.DrawerItem(getString(R.string.method_planet), R.drawable.btn_read));
        adapter = new LearningCustomAdapter(this, R.layout.item_learning, dataList);
        listViewLearningUsing.setAdapter(adapter);
    }
}
