package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.CustomDialog;
import com.sa_sh.sepehr.moshtarakapp.Utills.HttpClientWrapper;
import com.sa_sh.sepehr.moshtarakapp.Utills.IAbfaService;
import com.sa_sh.sepehr.moshtarakapp.Utills.ICallback;
import com.sa_sh.sepehr.moshtarakapp.Utills.NetworkHelper;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

import retrofit2.Call;
import retrofit2.Retrofit;

public class SignAccountActivity extends ActivityBase
        implements SharedPreference.accessData, ICallback<String> {


    Button buttonSign, buttonLogOut;
    EditText editTextFile, editTextAccount;
    View viewFocus;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.sign_account_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        buttonSign = (Button) findViewById(R.id.buttonSign);
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        SharedPreference sharedPreference = new SharedPreference(SignAccountActivity.this);
        if (sharedPreference.CheckIsNotEmpty()) {
            buttonSign.setText(getResources().getString(R.string.change_account));
            buttonLogOut.setVisibility(View.VISIBLE);
        } else {
            buttonSign.setText(getResources().getString(R.string.account));
            buttonLogOut.setVisibility(View.GONE);
        }
        setButtonSignListener();
        editTextFile = (EditText) findViewById(R.id.editTextFile);
        editTextAccount = (EditText) findViewById(R.id.editTextAccount);
        SetTextChangedListener();
    }

    private void SetTextChangedListener() {
        editTextFile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 9) {
                    viewFocus = editTextAccount;
                    viewFocus.requestFocus();
                }
            }
        });
        editTextAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 9) {
                    viewFocus = buttonSign;
                    viewFocus.requestFocus();
                }
            }
        });
    }

    private void setButtonSignListener() {
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View viewFocus;
                Boolean cancel = false;
                if (editTextFile.getText().length() < 1) {
                    cancel = true;
                    editTextFile.setError(getString(R.string.error_empty));
                    viewFocus = editTextFile;
                    viewFocus.requestFocus();
                }
                if (!cancel && editTextAccount.getText().length() < 1) {
                    cancel = true;
                    editTextAccount.setError(getString(R.string.error_empty));
                    viewFocus = editTextAccount;
                    viewFocus.requestFocus();
                }
//                if (!cancel && editTextFile.getText().length() < 10) {
//                    cancel = true;
//                    editTextFile.setError(getString(R.string.error_short_length));
//                    viewFocus = editTextFile;
//                    viewFocus.requestFocus();
//                }
//                if (!cancel && editTextAccount.getText().length() < 10) {
//                    cancel = true;
//                    editTextAccount.setError(getString(R.string.error_short_length));
//                    viewFocus = editTextAccount;
//                    viewFocus.requestFocus();
//                }
                if (!cancel) {
                    checkIsMatch();
                }
            }
        });
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreference sharedPreference = new SharedPreference(SignAccountActivity.this);
                sharedPreference.putData("", "", "");
                new CustomDialog(CustomDialog.DialogType.YellowRedirect, SignAccountActivity.this, getString(R.string.logout_successful),
                        getString(R.string.dear_user), getString(R.string.logout),
                        getString(R.string.accepted));
            }
        });
    }

    @Override
    public void execute(String ID) {
        if (ID.length()>0) {
            SharedPreference sharedPreference = new SharedPreference(SignAccountActivity.this);
            sharedPreference.putData(editTextFile.getText().toString(),
                    editTextAccount.getText().toString(), ID);
            new CustomDialog(CustomDialog.DialogType.GreenRedirect, SignAccountActivity.this, getString(R.string.you_are_signed),
                    getString(R.string.dear_user), getString(R.string.login),
                    getString(R.string.accepted));

        } else {
            new CustomDialog(CustomDialog.DialogType.Red, SignAccountActivity.this, getString(R.string.error_is_not_match),
                    getString(R.string.dear_user), getString(R.string.login),
                    getString(R.string.accepted));
        }
    }

    void checkIsMatch() {
        Retrofit retrofit = NetworkHelper.getInstance(true);
        final IAbfaService checkIsMatch = retrofit.create(IAbfaService.class);
        Call<String> call = checkIsMatch.CheckIsMatch(editTextFile.getText().toString(),
                editTextAccount.getText().toString());
        HttpClientWrapper.callHttpAsync(call, SignAccountActivity.this, this);
    }

    @Override
    public void AccessData() {

    }
}
