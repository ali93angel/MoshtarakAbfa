package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.DbTables.LastQabzBrief;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;
import com.sa_sh.sepehr.moshtarakapp.Utills.Code128;
import com.sa_sh.sepehr.moshtarakapp.Utills.CustomTab;
import com.sa_sh.sepehr.moshtarakapp.Utills.HttpClientWrapper;
import com.sa_sh.sepehr.moshtarakapp.Utills.IAbfaService;
import com.sa_sh.sepehr.moshtarakapp.Utills.ICallback;
import com.sa_sh.sepehr.moshtarakapp.Utills.NetworkHelper;
import com.sa_sh.sepehr.moshtarakapp.Utills.SharedPreference;

import retrofit2.Call;
import retrofit2.Retrofit;

public class LastBillActivity extends ActivityBase
        implements SharedPreference.accessData, ICallback<LastQabzBrief> {

    TextView textViewQabzID, textViewPayID, textViewNew, textViewPre, textViewAbBaha, textViewAbo,
            textViewOther, textViewMaliat, textViewCost, textViewDate;
    ImageView imageViewBarcode;
    String[] data = new String[3];
    LinearLayout linearLayoutPay;

    boolean whichColor = true;

    public void AccessData() {
        SharedPreference appPrefs = new SharedPreference(LastBillActivity.this);
        if (appPrefs.CheckIsNotEmpty()) {
            data[0] = appPrefs.getFileNumber();
            data[1] = appPrefs.getAccountNumber();
            data[2] = appPrefs.getBillID();
//            getLastBill(Integer.valueOf(971058382));
            getLastBill(Integer.valueOf(data[0]));
        } else {
            Intent intent = new Intent(getApplicationContext(), SignAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.last_bill_activity);
        return uiElementInActivity;
    }

    void initializeTextView() {
        textViewQabzID = (TextView) findViewById(R.id.textViewQabzID);
        textViewPayID = (TextView) findViewById(R.id.textViewPayID);
        textViewPre = (TextView) findViewById(R.id.textViewPre);
        textViewNew = (TextView) findViewById(R.id.textViewNew);
        textViewAbBaha = (TextView) findViewById(R.id.textViewAbBaha);
        textViewAbo = (TextView) findViewById(R.id.textViewAbo);
        textViewOther = (TextView) findViewById(R.id.textViewOther);
        textViewMaliat = (TextView) findViewById(R.id.textViewMaliat);
        textViewCost = (TextView) findViewById(R.id.textViewCost);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
    }

    @Override
    protected void initialize() {
        imageViewBarcode = (ImageView) findViewById(R.id.imageViewBarcode);
        initializeTextView();
        AccessData();
        linearLayoutPay = (LinearLayout) findViewById(R.id.linearLayoutPay);

//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    updateColor();
//                    whichColor = !whichColor;
//                }
//            }
//        }).start();
        linearLayoutPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CustomTab("https://bill.pec.ir/Bill/payment", LastBillActivity.this);
            }
        });
    }

    private void updateColor() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (whichColor)
                    linearLayoutPay.setBackground(getResources().getDrawable(R.drawable.border_orange_));
                else {
                    linearLayoutPay.setBackground(getResources().getDrawable(R.drawable.border_green_));
                }
            }
        });
    }

    void getLastBill(int id) {
        Retrofit retrofit = NetworkHelper.getInstance(true);
        final IAbfaService lastQabsBrief = retrofit.create(IAbfaService.class);
        Call<LastQabzBrief> call = lastQabsBrief.loadDataL(id);
        HttpClientWrapper.callHttpAsync(call, LastBillActivity.this, this);
    }

    String makeMoneyStandard(String money) {

        StringBuilder stringBuilder = new StringBuilder(money);

        for (int i = stringBuilder.length() - 3; i > 0; i = i - 3)
            stringBuilder.insert(i, ",");
        return stringBuilder.toString();
    }

    @Override
    public void execute(LastQabzBrief lastQabzBriefs) {
        setTextView(textViewQabzID, lastQabzBriefs.getBillId());
        setTextView(textViewPayID, lastQabzBriefs.getPayId());
        setTextView(textViewNew, lastQabzBriefs.getCounterReadingNumberNow());
        setTextView(textViewPre, lastQabzBriefs.getCounterReadingNumberPre());

        setTextView(textViewAbBaha, makeMoneyStandard(lastQabzBriefs.getAbBaha()));
        setTextView(textViewAbo, makeMoneyStandard(lastQabzBriefs.getAbonman()));
        setTextView(textViewOther, makeMoneyStandard(lastQabzBriefs.getSaier()));
        setTextView(textViewMaliat, makeMoneyStandard(lastQabzBriefs.getMaliat()));
        setTextView(textViewCost, makeMoneyStandard(lastQabzBriefs.getFinalAmount()));

        String date = lastQabzBriefs.getMohlat();
        if (date.startsWith("13")) {
            date = date.substring(2, date.length());
        }
        setTextView(textViewDate, date);

//        String text = "ali";
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        try {
//            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//            imageViewBarcode.setImageBitmap(bitmap);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }

        setImageBitmap(imageViewBarcode, lastQabzBriefs.getFinalAmount());


    }

    void setImageBitmap(ImageView imageView, String s) {
        Code128 code = new Code128(this);
        code.setData(s);
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        Bitmap bitmap = code.getBitmap(2 * width / 3, height / 8);
        imageView.setImageBitmap(bitmap);
    }

    void setTextView(TextView textView, String s) {
        textView.setText(s);
    }
}
