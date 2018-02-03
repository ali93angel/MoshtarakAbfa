package com.sa_sh.sepehr.moshtarakapp.Utills;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.sa_sh.sepehr.moshtarakapp.Activities.HomeActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

/**
 * Created by Leon on 12/11/2017.
 */

public class CustomDialog extends Activity {
    Context context;
    String Top, Title, Message, ButtonText;
    static LovelyStandardDialog lovelyStandardDialog;

    public enum DialogType {
        Green,
        Yellow,
        Red,
        GreenRedirect,
        YellowRedirect,
        RedRedirect,
    }

    public CustomDialog(DialogType choose, Context context, String message, String title, String top, String buttonText) {
        this.context = context;
        Message = message;
        Title = title;
        Top = top;
        ButtonText = buttonText;
        lovelyStandardDialog = new LovelyStandardDialog(context)
                .setTitle(Title)
                .setMessage(Message)
                .setTopTitle(Top);
        if (choose == DialogType.Green)
            CustomGreenDialog(this.context, ButtonText);
        else if (choose == DialogType.Yellow)
            CustomYellowDialog(this.context, ButtonText);
        else if (choose == DialogType.Red)
            CustomRedDialog(this.context, ButtonText);
        else if (choose == DialogType.GreenRedirect)
            CustomGreenDialogRedirect(this.context, ButtonText);
        else if (choose == DialogType.YellowRedirect)
            CustomYellowDialogRedirect(this.context, ButtonText);
        else if (choose == DialogType.RedRedirect)
            CustomRedDialogRedirect(this.context, ButtonText);
    }

    public static void CustomGreenDialogRedirect(final Context context, String ButtonText) {
        lovelyStandardDialog
                .setTopColorRes(R.color.green2)
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.green2)
                .setPositiveButton(ButtonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivity(intent);
                    }
                });
        lovelyStandardDialog.show();
    }

    public static void CustomYellowDialogRedirect(final Context context, String buttonText) {
        lovelyStandardDialog
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.yellow1)
                .setTopColorRes(R.color.yellow1)
                .setPositiveButton(buttonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivity(intent);
                    }
                })
                .show();
    }

    public static void CustomRedDialogRedirect(final Context context, String buttonText) {
        lovelyStandardDialog
                .setTopColorRes(R.color.red1)
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.red1)
                .setPositiveButton(buttonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lovelyStandardDialog.dismiss();
                    }
                })
                .show();
    }

    public static void CustomGreenDialog(final Context context, String ButtonText) {
        lovelyStandardDialog
                .setTopColorRes(R.color.green2)
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.green2)
                .setPositiveButton(ButtonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lovelyStandardDialog.dismiss();
                    }
                })
                .show();
    }

    public static void CustomYellowDialog(final Context context, String buttonText) {
        lovelyStandardDialog
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.yellow1)
                .setTopColorRes(R.color.yellow1)
                .setPositiveButton(buttonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivity(intent);
                    }
                })
                .show();
    }

    public static void CustomRedDialog(final Context context, String buttonText) {
        lovelyStandardDialog
                .setTopColorRes(R.color.red1)
                .setTopTitleColor(context.getResources().getColor(R.color.black))
                .setButtonsColorRes(R.color.red1)
                .setPositiveButton(buttonText, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lovelyStandardDialog.dismiss();
                    }
                })
                .show();
    }
}
