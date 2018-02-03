package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sa_sh.sepehr.moshtarakapp.Adapters.CardexCustomAdapter;
import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.KardexAbBrief;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.HttpClientWrapper;
import com.sa_sh.sepehr.moshtarakapp.Utills.IAbfaService;
import com.sa_sh.sepehr.moshtarakapp.Utills.ICallback;
import com.sa_sh.sepehr.moshtarakapp.Utills.NetworkHelper;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CardexActivity extends ActivityBase
        implements ICallback<ArrayList<KardexAbBrief>>, SharedPreference.accessData {

    ListView listViewCardex;
    ArrayAdapter arrayAdapter;
    CardexCustomAdapter adapter;


    ArrayList<CardexCustomAdapter.CardexList> arraylist = new ArrayList<CardexCustomAdapter.CardexList>();

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.cardex_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        listViewCardex = (ListView) findViewById(R.id.listViewCardex);
        AccessData();

    }

    void getKardexAbBrief(int id) {
        Retrofit retrofit = NetworkHelper.getInstance(true);
        final IAbfaService kardexAbBrief = retrofit.create(IAbfaService.class);
        Call<ArrayList<KardexAbBrief>> call = kardexAbBrief.loadDataK(id);
        HttpClientWrapper.callHttpAsync(call, CardexActivity.this, this);
    }

    public void AccessData() {
        SharedPreference appPrefs = new SharedPreference(CardexActivity.this);
        if (appPrefs.CheckIsNotEmpty()) {
            String[] data = new String[3];
            data[0] = appPrefs.getFileNumber();
            data[1] = appPrefs.getAccountNumber();
            data[2] = appPrefs.getBillID();
            getKardexAbBrief(Integer.valueOf(data[0]));
        } else {
            Intent intent = new Intent(getApplicationContext(), SignAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }

    protected void fillListView() {
        String[] note = {getString(R.string.get_cardex), getString(R.string.pay_cardex), getString(R.string.pay_cardex)
                , getString(R.string.edit), getString(R.string.pay_cardex), getString(R.string.edit), getString(R.string.get_cardex),
                getString(R.string.edit), getString(R.string.pay_cardex), getString(R.string.edit)};
        String[] cost = {"12,223", "17,321", "11,321", "7,321", "12,321", "11,321", "11,321", "11,321",
                "21,321", "11,341", "16,321", "11,521", "11,321", "11,321"},
                date = {"93/12/11", "91/02/23", "81/02/25", "78/02/12", "89/02/19", "89/02/12",
                        "90/02/12", "78/02/12", "92/06/25", "91/02/12", "93/02/12", "90/12/12",
                        "95/02/12", "89/12/12"},
                use = {"111", "128", "192", "202", "0", "52", "62", "22", "122", "122", "82", "92", "22", "122"};
        for (int i = 0; i < note.length; i++) {
            CardexCustomAdapter.CardexList cl = new CardexCustomAdapter.CardexList(cost[i], date[i], note[i], use[i]);
            arraylist.add(cl);
            adapter = new CardexCustomAdapter(this, arraylist);
            listViewCardex.setAdapter(adapter);
            listViewCardex.setTextFilterEnabled(true);
        }
    }
    @Override
    public void execute(ArrayList<KardexAbBrief> kardexAbBriefs) {
        for (int i = 0; i < kardexAbBriefs.size(); i++) {
            KardexAbBrief kardexAbBrief = kardexAbBriefs.get(i);
            int bedehkari = Integer.valueOf(kardexAbBrief.getBedehkari());
            int bestankari = Integer.valueOf(kardexAbBrief.getBestankari());
            int mablagh = bedehkari + bestankari;
            int eslah = Integer.valueOf(kardexAbBrief.getIsEslah());
            String note = "";
            if (bedehkari == 0)
                note = getString(R.string.pay_cardex);
            else if (bestankari == 0)
                note = getString(R.string.get_cardex);
            else if (eslah == 1)
                note = getString(R.string.edit);
            String date = kardexAbBrief.getDate();
            if (date.startsWith("13")) {
                date = date.substring(2, date.length());
            }
            CardexCustomAdapter.CardexList cl = new CardexCustomAdapter.CardexList(
                    String.valueOf(mablagh), date, note, kardexAbBrief.getMasraf());
            arraylist.add(cl);
        }
        adapter = new CardexCustomAdapter(this, arraylist);
        listViewCardex.setAdapter(adapter);
        listViewCardex.setTextFilterEnabled(true);
    }
}
