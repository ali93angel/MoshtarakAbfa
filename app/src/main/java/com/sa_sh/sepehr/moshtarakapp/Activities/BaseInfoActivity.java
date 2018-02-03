package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Intent;
import android.widget.TextView;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.BaseInfo;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.HttpClientWrapper;
import com.sa_sh.sepehr.moshtarakapp.Utills.IAbfaService;
import com.sa_sh.sepehr.moshtarakapp.Utills.ICallback;
import com.sa_sh.sepehr.moshtarakapp.Utills.NetworkHelper;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BaseInfoActivity extends ActivityBase
        implements ICallback<BaseInfo>, SharedPreference.accessData {

    TextView textViewName, textViewFile, textViewAccount, textViewID, textViewUser, textViewCapacity, textViewAhad,
            textViewBranchRadius, textViewSiphonRadius, textViewLastReadDate, textViewDebt;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.base_info_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewFile = (TextView) findViewById(R.id.textViewFile);
        textViewAccount = (TextView) findViewById(R.id.textViewAccount);
        textViewID = (TextView) findViewById(R.id.textViewID);
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewCapacity = (TextView) findViewById(R.id.textViewCapacity);
        textViewAhad = (TextView) findViewById(R.id.textViewAhad);
        textViewBranchRadius = (TextView) findViewById(R.id.textViewBranchRadius);
        textViewSiphonRadius = (TextView) findViewById(R.id.textViewSiphonRadius);
        textViewLastReadDate = (TextView) findViewById(R.id.textViewLastReadDate);
        textViewDebt = (TextView) findViewById(R.id.textViewDebt);
        AccessData();
    }

    public void AccessData() {
        SharedPreference appPrefs = new SharedPreference(BaseInfoActivity.this);
        if (appPrefs.CheckIsNotEmpty()) {
            String[] data = new String[3];
            data[0] = appPrefs.getFileNumber();
            data[1] = appPrefs.getAccountNumber();
            data[2] = appPrefs.getBillID();
            getBaseInfoData(Integer.valueOf(data[0]));
        } else {
            Intent intent = new Intent(getApplicationContext(), SignAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }

    void getBaseInfoData(int id) {
        Retrofit retrofit = NetworkHelper.getInstance(true);
        final IAbfaService baseInfo = retrofit.create(IAbfaService.class);
        Call<BaseInfo> call = baseInfo.loadData(id);
        HttpClientWrapper.callHttpAsync(call, BaseInfoActivity.this, this);
    }

    public void execute(BaseInfo baseInfo1) {
        setTextView(textViewName, "نام: " + baseInfo1.getFirstName() + " " + baseInfo1.getSureName());
        if (baseInfo1.getPreAbDebt() != null)
            setTextView(textViewDebt, baseInfo1.getPreAbDebt());
        if (baseInfo1.getZarfiatQarardadi() != null)
            setTextView(textViewCapacity, baseInfo1.getZarfiatQarardadi());
        if (baseInfo1.getQotrSifoonTitle() != null)
            setTextView(textViewSiphonRadius, baseInfo1.getQotrSifoonTitle());
        if (baseInfo1.getKarbariTitle() != null)
            setTextView(textViewUser, baseInfo1.getKarbariTitle());
        if (baseInfo1.getAhadAsli() != null)
            setTextView(textViewAhad, baseInfo1.getAhadAsli());
        if (baseInfo1.getQotrAbTitle() != null)
            setTextView(textViewBranchRadius, baseInfo1.getQotrAbTitle());
        if (baseInfo1.getEshterak() != null)
            setTextView(textViewAccount, baseInfo1.getEshterak());
        if (baseInfo1.getRadif() != null)
            setTextView(textViewFile, baseInfo1.getRadif());
        if (baseInfo1.getPreReadingDate() != null)
            setTextView(textViewLastReadDate, baseInfo1.getPreReadingDate());
        if (baseInfo1.getEshterakQeraatCode() != null)
            setTextView(textViewID, baseInfo1.getEshterakQeraatCode());

    }


    void setTextView(TextView textView, String s) {
        textView.setText(s);
    }
}
