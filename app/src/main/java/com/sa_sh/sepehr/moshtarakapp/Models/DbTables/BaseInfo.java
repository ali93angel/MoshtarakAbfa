package com.sa_sh.sepehr.moshtarakapp.Models.DbTables;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Leon on 12/8/2017.
 */

public class BaseInfo {
    @SerializedName("Radif")
    String Radif;
    @SerializedName("Eshterak")
    String Eshterak;
    @SerializedName("EshterakQeraatCode")
    String EshterakQeraatCode;
    @SerializedName("BillId")
    String BillId;
    @SerializedName("FirstName")
    String FirstName;
    @SerializedName("SureName")
    String SureName;
    @SerializedName("Address")
    String Address;
    @SerializedName("RegisterDate")
    String RegisterDate;
    @SerializedName("InstallAbDate")
    String InstallAbDate;
    @SerializedName("InstallFazelabDate")
    String InstallFazelabDate;
    @SerializedName("MobileNumber")
    String MobileNumber;
    @SerializedName("PhoneNumber")
    String PhoneNumber;
    @SerializedName("PreReadingDate")
    String PreReadingDate;
    @SerializedName("PreReadingNumber")
    String PreReadingNumber;
    @SerializedName("PreCounterReadingCode")
    String PreCounterReadingCode;
    @SerializedName("KarbariTitle")
    String KarbariTitle;
    @SerializedName("KarbariCode")
    String KarbariCode;
    @SerializedName("AhadAsli")
    String AhadAsli;
    @SerializedName("AhadFari")
    String AhadFari;
    @SerializedName("QotrAbCode")
    String QotrAbCode;
    @SerializedName("QotrAbTitle")
    String QotrAbTitle;
    @SerializedName("QotrSifoonCode")
    String QotrSifoonCode;
    @SerializedName("QotrSifoonTitle")
    String QotrSifoonTitle;
    @SerializedName("ZarfiatQarardadi")
    String ZarfiatQarardadi;
    @SerializedName("PreAbDebt")
    String PreAbDebt;
    public BaseInfo(String address, String ahadAsli, String ahadFari, String billId, String eshterak,
                    String eshterakQeraatCode, String firstName, String installAbDate,
                    String installFazelabDate, String karbariCode, String karbariTitle,
                    String mobileNumber, String preAbDebt, String preCounterReadingCode,
                    String preReadingDate, String qotrAbCode, String qotrAbTitle,
                    String qotrSifoonCode, String qotrSifoonTitle, String radif,
                    String registerDate, String sureName, String zarfiatQarardadi) {
        Address = address;
        AhadAsli = ahadAsli;
        AhadFari = ahadFari;
        BillId = billId;
        Eshterak = eshterak;
        EshterakQeraatCode = eshterakQeraatCode;
        FirstName = firstName;
        InstallAbDate = installAbDate;
        InstallFazelabDate = installFazelabDate;
        KarbariCode = karbariCode;
        KarbariTitle = karbariTitle;
        MobileNumber = mobileNumber;
        PreAbDebt = preAbDebt;
        PreCounterReadingCode = preCounterReadingCode;
        PreReadingDate = preReadingDate;
        QotrAbCode = qotrAbCode;
        QotrAbTitle = qotrAbTitle;
        QotrSifoonCode = qotrSifoonCode;
        QotrSifoonTitle = qotrSifoonTitle;
        Radif = radif;
        RegisterDate = registerDate;
        SureName = sureName;
        ZarfiatQarardadi = zarfiatQarardadi;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setAhadAsli(String ahadAsli) {
        AhadAsli = ahadAsli;
    }

    public void setAhadFari(String ahadFari) {
        AhadFari = ahadFari;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public void setEshterak(String eshterak) {
        Eshterak = eshterak;
    }

    public void setEshterakQeraatCode(String eshterakQeraatCode) {
        EshterakQeraatCode = eshterakQeraatCode;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setInstallAbDate(String installAbDate) {
        InstallAbDate = installAbDate;
    }

    public void setInstallFazelabDate(String installFazelabDate) {
        InstallFazelabDate = installFazelabDate;
    }

    public void setKarbariCode(String karbariCode) {
        KarbariCode = karbariCode;
    }

    public void setKarbariTitle(String karbariTitle) {
        KarbariTitle = karbariTitle;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public void setPreAbDebt(String preAbDebt) {
        PreAbDebt = preAbDebt;
    }

    public void setPreCounterReadingCode(String preCounterReadingCode) {
        PreCounterReadingCode = preCounterReadingCode;
    }

    public void setPreReadingDate(String preReadingDate) {
        PreReadingDate = preReadingDate;
    }

    public void setQotrAbCode(String qotrAbCode) {
        QotrAbCode = qotrAbCode;
    }

    public void setQotrAbTitle(String qotrAbTitle) {
        QotrAbTitle = qotrAbTitle;
    }

    public void setQotrSifoonCode(String qotrSifoonCode) {
        QotrSifoonCode = qotrSifoonCode;
    }

    public void setQotrSifoonTitle(String qotrSifoonTitle) {
        QotrSifoonTitle = qotrSifoonTitle;
    }

    public void setRadif(String radif) {
        Radif = radif;
    }

    public void setRegisterDate(String registerDate) {
        RegisterDate = registerDate;
    }

    public void setSureName(String sureName) {
        SureName = sureName;
    }

    public void setZarfiatQarardadi(String zarfiatQarardadi) {
        ZarfiatQarardadi = zarfiatQarardadi;
    }

    public String getAddress() {
        return Address;
    }

    public String getAhadAsli() {
        return AhadAsli;
    }

    public String getAhadFari() {
        return AhadFari;
    }

    public String getBillId() {
        return BillId;
    }

    public String getEshterak() {
        return Eshterak;
    }

    public String getEshterakQeraatCode() {
        return EshterakQeraatCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getInstallAbDate() {
        return InstallAbDate;
    }

    public String getInstallFazelabDate() {
        return InstallFazelabDate;
    }

    public String getKarbariCode() {
        return KarbariCode;
    }

    public String getKarbariTitle() {
        return KarbariTitle;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getPreAbDebt() {
        return PreAbDebt;
    }

    public String getPreCounterReadingCode() {
        return PreCounterReadingCode;
    }

    public String getPreReadingDate() {
        return PreReadingDate;
    }

    public String getQotrAbCode() {
        return QotrAbCode;
    }

    public String getQotrAbTitle() {
        return QotrAbTitle;
    }

    public String getQotrSifoonCode() {
        return QotrSifoonCode;
    }

    public String getQotrSifoonTitle() {
        return QotrSifoonTitle;
    }

    public String getRadif() {
        return Radif;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public String getSureName() {
        return SureName;
    }

    public String getZarfiatQarardadi() {
        return ZarfiatQarardadi;
    }
}
