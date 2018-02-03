package com.sa_sh.sepehr.moshtarakapp.Utills;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Leon on 12/9/2017.
 */

public final class NetworkHelper {
    private static TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static long READ_TIMEOUT = 120;
    private static long WRITE_TIMEOUT = 60;
    private static long CONNECT_TIMEOUT = 10;
    private static boolean RETRY_ENABLED = true;

    private NetworkHelper() {

    }

    private static OkHttpClient getHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient
                .Builder()
                .readTimeout(READ_TIMEOUT, TIME_UNIT)
                .writeTimeout(WRITE_TIMEOUT, TIME_UNIT)
                .connectTimeout(CONNECT_TIMEOUT, TIME_UNIT)
                .retryOnConnectionFailure(RETRY_ENABLED)
                .addInterceptor(interceptor).build();
        return client;
    }

    public static Retrofit getInstance(boolean isLocal) {
        String baseUrl = "http://81.90.148.25";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(NetworkHelper.getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
