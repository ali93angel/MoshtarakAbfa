package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.sa_sh.sepehr.moshtarakapp.BaseItems.ActivityBase;
import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;

public class LearningActivity extends ActivityBase {
    ImageView imageViewWaterConsumption;

    @Override
    protected UiElementInActivity getUiElementsInActivity() {
        UiElementInActivity uiElementInActivity = new UiElementInActivity();
        uiElementInActivity.setContentViewId(R.layout.learning_activity);
        return uiElementInActivity;
    }

    @Override
    protected void initialize() {
        imageViewWaterConsumption = (ImageView) findViewById(R.id.imageViewWaterConsumption);
        setImageButtonsClickListener();
    }

    private void setImageButtonsClickListener() {
        setImageViewWaterConsumptionListener();
    }

    private void setImageViewWaterConsumptionListener() {
        imageViewWaterConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LearningActivity.this, UsingMethodActivity.class);
                startActivity(intent);

            }
        });
    }
}
