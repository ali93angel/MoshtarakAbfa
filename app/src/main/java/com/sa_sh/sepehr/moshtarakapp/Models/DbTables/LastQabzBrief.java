package com.sa_sh.sepehr.moshtarakapp.Models.DbTables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Leon on 12/14/2017.
 */

public class LastQabzBrief {
    @SerializedName("AbBaha")
    @Expose
    String AbBaha;
    @SerializedName("Abonman")
    @Expose
    String Abonman;
    @SerializedName("BillId")
    @Expose
    String BillId;
    @SerializedName("CounterReadingNumberNow")
    @Expose
    String CounterReadingNumberNow;
    @SerializedName("CounterReadingNumberPre")
    @Expose
    String CounterReadingNumberPre;
    @SerializedName("FinalAmount")
    @Expose
    String FinalAmount;
    @SerializedName("Maliat")
    @Expose
    String Maliat;
    @SerializedName("Mohlat")
    @Expose
    String Mohlat;
    @SerializedName("PayId")
    @Expose
    String PayId;
    @SerializedName("Saier")
    @Expose
    String Saier;

    public LastQabzBrief(String abBaha, String abonman, String billId,
                         String counterReadingNumberNow, String counterReadingNumberPre,
                         String finalAmount, String maliat, String mohlat, String payId, String saier) {
        AbBaha = abBaha;
        Abonman = abonman;
        BillId = billId;
        CounterReadingNumberNow = counterReadingNumberNow;
        CounterReadingNumberPre = counterReadingNumberPre;
        FinalAmount = finalAmount;
        Maliat = maliat;
        Mohlat = mohlat;
        PayId = payId;
        Saier = saier;
    }

    public void setAbBaha(String abBaha) {
        AbBaha = abBaha;
    }

    public void setAbonman(String abonman) {
        Abonman = abonman;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public void setCounterReadingNumberNow(String counterReadingNumberNow) {
        CounterReadingNumberNow = counterReadingNumberNow;
    }

    public void setCounterReadingNumberPre(String counterReadingNumberPre) {
        CounterReadingNumberPre = counterReadingNumberPre;
    }

    public void setFinalAmount(String finalAmount) {
        FinalAmount = finalAmount;
    }

    public void setMaliat(String maliat) {
        Maliat = maliat;
    }

    public void setMohlat(String mohlat) {
        Mohlat = mohlat;
    }

    public void setPayId(String payId) {
        PayId = payId;
    }

    public void setSaier(String saier) {
        Saier = saier;
    }

    public String getAbBaha() {
        return AbBaha;
    }

    public String getAbonman() {
        return Abonman;
    }

    public String getBillId() {
        return BillId;
    }

    public String getCounterReadingNumberNow() {
        return CounterReadingNumberNow;
    }

    public String getCounterReadingNumberPre() {
        return CounterReadingNumberPre;
    }

    public String getFinalAmount() {
        return FinalAmount;
    }

    public String getMaliat() {
        return Maliat;
    }

    public String getMohlat() {
        return Mohlat;
    }

    public String getPayId() {
        return PayId;
    }

    public String getSaier() {
        return Saier;
    }
}
