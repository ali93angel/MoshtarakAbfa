package com.sa_sh.sepehr.moshtarakapp.Utills;

import android.database.Observable;

import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.BaseInfo;
import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.KardexAbBrief;
import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.LastQabzBrief;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Leon on 12/9/2017.
 */
public interface IAbfaService {
    @GET("/ApiSimafa/BaseInfo/GetBaseInfo")
    Call<BaseInfo> loadData(
            @Query("id") int moshtarakId);

    @GET("/ApiSimafa/BaseInfo/GetBaseInfo/{Radif}")
    Observable<BaseInfo> BASE_INFO_OBSERVABLE(
            @Path("Radif") String Radif);

    @GET("/ApiSimafa/KardexAb/GetKardexAbBrief")
    Call<ArrayList<KardexAbBrief>> loadDataK(
            @Query("id") int file_number);

    @GET("/ApiSimafa/KardexAb/GetKardexAbBrief/{id}")
    Observable<List<KardexAbBrief>> KARDEX_AB_BRIEF_OBSERVABLE(
            @Path("id") String file);

    @GET("/ApiSimafa/KardexAb/GetLastQabsBrief")
    Call<LastQabzBrief> loadDataL(
            @Query("id") int Radif);

    @POST("/ApiSimafa/BaseInfo/RadifEshterakMatch/")
    Call<String> CheckIsMatch(@Query("radif") String radif
            , @Query("eshterak") String eshterak);
}

