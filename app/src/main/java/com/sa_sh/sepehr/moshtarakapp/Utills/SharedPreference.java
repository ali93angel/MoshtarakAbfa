package com.sa_sh.sepehr.moshtarakapp.Utills;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Leon on 12/13/2017.
 */

public class SharedPreference {
    Context context;
    SharedPreferences appPrefs;

    public SharedPreference(Context context) {
        this.context = context;
        appPrefs = this.context.getSharedPreferences("com.sa_sh.sepehr.moshtarakapp.user_preferences", MODE_PRIVATE);
    }

    public interface accessData {
        void AccessData();
    }

    public void saveData(String file_number, String account_number, String bill_id) {
//        SharedPreferences.Editor prefsEditor = appPrefs.edit();
//        prefsEditor.putString("file_number", file_number);
//        prefsEditor.putString("account_number", account_number);
//        prefsEditor.putString("bill_id", bill_id);
//        prefsEditor.commit();
        putBillID(bill_id);
        putFileNumber(file_number);
        putAccountNumber(account_number);
    }

    public void putFileNumber(String file_number) {
        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        prefsEditor.putString("file_number", file_number);
        prefsEditor.commit();
    }

    public void putAccountNumber(String account_number) {
        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        prefsEditor.putString("account_number", account_number);
        prefsEditor.commit();
    }

    public void putBillID(String bill_id) {
        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        prefsEditor.putString("bill_id", bill_id);
        prefsEditor.commit();
    }

    public void putData(String file_number, String account_number, String bill_id) {
        putAccountNumber(account_number);
        putBillID(bill_id);
        putFileNumber(file_number);

    }

    public boolean CheckIsNotEmpty() {
        if (appPrefs == null) {
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
            return false;
        } else if (appPrefs.getString("file_number", "") == null ||
                appPrefs.getString("account_number", "") == null ||
                appPrefs.getString("bill_id", "") == null) {
            return false;
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
        } else if (appPrefs.getString("file_number", "").isEmpty() ||
                appPrefs.getString("account_number", "").isEmpty() ||
                appPrefs.getString("bill_id", "").isEmpty()
                ) {
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
            return false;
        } else if (appPrefs.getString("file_number", "").length() < 1 ||
                appPrefs.getString("account_number", "").length() < 1 ||
                appPrefs.getString("bill_id", "").length() < 1
                ) {
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
            return false;
        }
        return true;
    }

    public String getFileNumber() {
        return appPrefs.getString("file_number", "");
    }

    public String getAccountNumber() {
        return appPrefs.getString("account_number", "");
    }

    public String getBillID() {
        return appPrefs.getString("bill_id", "");
    }

//    public void accessData() {
//        SharedPreferences appPrefs = context.getSharedPreferences("com.sa_sh.sepehr.moshtarakapp.user_preferences", MODE_PRIVATE);
//        if (appPrefs == null) {
//        } else if (appPrefs.getString("file_number", "") == null ||
//                appPrefs.getString("account_number", "") == null) {
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
//        } else if (appPrefs.getString("file_number", "").isEmpty() ||
//                appPrefs.getString("account_number", "").isEmpty()) {
//            Intent intent = new Intent(context, SignAccountActivity.class);
//            context.startActivity(intent);
//        } else {
//            String[] data = new String[2];
//            data[0] = appPrefs.getString("file_number", "");
//            data[1] = appPrefs.getString("account_number", "");
//        }
//    }
}
