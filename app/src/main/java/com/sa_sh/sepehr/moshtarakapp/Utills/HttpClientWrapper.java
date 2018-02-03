package com.sa_sh.sepehr.moshtarakapp.Utills;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import com.sa_sh.sepehr.moshtarakapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Leon on 12/12/2017.
 */

final public class HttpClientWrapper {
    private HttpClientWrapper() {
    }

    public static <T> void callHttpAsync(Call<T> call, final ICallback callback, final Context context) {
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(context.getString(R.string.loading_getting_info));
        dialog.setTitle(context.getString(R.string.loading_connecting));
        dialog.show();
        dialog.setCancelable(false);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    if (response.isSuccessful()) {
                        T responseT = response.body();
                        callback.execute(responseT);
                        dialog.dismiss();
                    } else {
                        CustomErrorHandling customErrorHandling = new CustomErrorHandling(context);
                        String error = customErrorHandling.getErrorMessage(response.code());
                        new CustomDialog(CustomDialog.DialogType.Red, context, error, context.getString(R.string.dear_user),
                                context.getString(R.string.error), context.getString(R.string.accepted));
                        dialog.dismiss();

                    }
                } catch (Exception e) {
                    CustomErrorHandling customErrorHandling = new CustomErrorHandling(context);
                    String error = customErrorHandling.getErrorMessage(e);
                    new CustomDialog(CustomDialog.DialogType.Red, context, error, context.getString(R.string.dear_user),
                            context.getString(R.string.error), context.getString(R.string.accepted));
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    CustomErrorHandling customErrorHandling = new CustomErrorHandling(context);
                    String error = customErrorHandling.getErrorMessage(t);
                    new CustomDialog(CustomDialog.DialogType.Red, context, error, context.getString(R.string.dear_user),
                            context.getString(R.string.error), context.getString(R.string.accepted));
                }
                dialog.dismiss();
            }
        });
    }
}
