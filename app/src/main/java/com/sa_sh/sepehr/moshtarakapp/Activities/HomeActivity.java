package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;

public class HomeActivity extends ActivityBase {

    ImageButton saleImgBtn, lastBillImgBtn, KardexImgBtn, TrainImgBtn, MamoorImgBtn;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.home_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        initializeImageButtons();
        setImageButtonsClickListener();
    }

    private void initializeImageButtons() {
        saleImgBtn = (ImageButton) findViewById(R.id.imgBtnSale);
        lastBillImgBtn = (ImageButton) findViewById(R.id.imgBtnLastBill);
        KardexImgBtn = (ImageButton) findViewById(R.id.imgBtnKardex);
        TrainImgBtn = (ImageButton) findViewById(R.id.imgBtnTrain);
        MamoorImgBtn = (ImageButton) findViewById(R.id.imgBtnMamoor);
    }

    private void setImageButtonsClickListener() {
        setSaleImgBtnListener();
        setLastBillImgBtnListener();
        setKardexImgBtnListener();
        setTrainImgBtnListener();
        setMamoorImgBtnListener();
    }

    private void setMamoorImgBtnListener() {
        MamoorImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SetKontorActivity.class);
                startActivity(intent);

            }
        });
    }

    private void setSaleImgBtnListener() {
        saleImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void setTrainImgBtnListener() {
        TrainImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LearningActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void setKardexImgBtnListener() {
        KardexImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CardexActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setLastBillImgBtnListener() {
        lastBillImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LastBillActivity.class);
                startActivity(intent);
            }
        });
    }
}
