package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

public class SetKontorActivity extends ActivityBase
        implements SharedPreference.accessData {
    LinearLayout linearLayout1, linearLayout2;
    Button buttonSign;
    EditText editText1, editText2, editText3, editText4, editText5;
    View viewFocus;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.set_kontor_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        buttonSign = (Button) findViewById(R.id.buttonSign);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        setComponentPosition();
        setTextChangedListener();
        viewFocus = editText1;
        viewFocus.requestFocus();
        AccessData();
    }

    private void setTextChangedListener() {
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    viewFocus = editText2;
                    viewFocus.requestFocus();
                }


            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    viewFocus = editText3;
                    viewFocus.requestFocus();
                }
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    viewFocus = editText4;
                    viewFocus.requestFocus();
                }
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    viewFocus = editText5;
                    viewFocus.requestFocus();
                }
            }
        });
        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    viewFocus = buttonSign;
                    viewFocus.requestFocus();
                }
            }
        });
    }

    public void AccessData() {
        SharedPreference appPrefs = new SharedPreference(SetKontorActivity.this);
        if (appPrefs.CheckIsNotEmpty()) {
            String[] data = new String[3];
            data[0] = appPrefs.getFileNumber();
            data[1] = appPrefs.getAccountNumber();
            data[2] = appPrefs.getBillID();
        } else {
            Intent intent = new Intent(getApplicationContext(), SignAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }

    void setComponentPosition() {
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int height = metrics.heightPixels;
        linearLayout1.setY(height - 14 * height / 25);
        linearLayout2.setY(height - 2 * height / 5);
    }

}
