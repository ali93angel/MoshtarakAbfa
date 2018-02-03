package com.sa_sh.sepehr.moshtarakapp.Models.DbTables;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Leon on 12/13/2017.
 */

public class KardexAbBrief {
    @SerializedName("BankTitle")
    String Bank;
    @SerializedName("Bedehkari")
    String Bedehkari;
    @SerializedName("Bestankari")
    String Bestankari;
    @SerializedName("CounterReadingNumberNow")
    String CounterReadingNumberNow;
    @SerializedName("Date")
    String Date;
    @SerializedName("IsEslah")
    String IsEslah;
    @SerializedName("KarbariId")
    String KarbariId;
    @SerializedName("Masraf")
    String Masraf;
    @SerializedName("Rate")
    String Rate;
    @SerializedName("TedadAhad")
    String TedadAhad;

    public KardexAbBrief(String bank, String bedehkari, String bestankari,
                         String counterReadingNumberNow, String date, String isEslah,
                         String karbariId, String masraf, String rate, String tedadAhad) {
        Bank = bank;
        Bedehkari = bedehkari;
        Bestankari = bestankari;
        CounterReadingNumberNow = counterReadingNumberNow;
        Date = date;
        IsEslah = isEslah;
        KarbariId = karbariId;
        Masraf = masraf;
        Rate = rate;
        TedadAhad = tedadAhad;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getBedehkari() {
        return Bedehkari;
    }

    public void setBedehkari(String bedehkari) {
        Bedehkari = bedehkari;
    }

    public String getBestankari() {
        return Bestankari;
    }

    public void setBestankari(String bestankari) {
        Bestankari = bestankari;
    }

    public String getCounterReadingNumberNow() {
        return CounterReadingNumberNow;
    }

    public void setCounterReadingNumberNow(String counterReadingNumberNow) {
        CounterReadingNumberNow = counterReadingNumberNow;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getIsEslah() {
        return IsEslah;
    }

    public void setIsEslah(String isEslah) {
        IsEslah = isEslah;
    }

    public String getKarbariId() {
        return KarbariId;
    }

    public void setKarbariId(String karbariId) {
        KarbariId = karbariId;
    }

    public String getMasraf() {
        return Masraf;
    }

    public void setMasraf(String masraf) {
        Masraf = masraf;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getTedadAhad() {
        return TedadAhad;
    }

    public void setTedadAhad(String tedadAhad) {
        TedadAhad = tedadAhad;
    }
}
