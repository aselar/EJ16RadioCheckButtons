package com.android.asel.ej16radiocheckbuttons;

import android.graphics.Color;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxRojo, checkBoxTransparente, checkBoxVerde;
    private ImageView imageView;
    private RadioGroup radioGroup;
    private RadioButton radioButtonEstirado, radioButtonCentrado;
    private ImageButton imageButtonIronMan, imageButtonCapitanAmerica;
    private LinearLayout activityMain, linearLayoutImage;

    private void inicializar() {

        checkBoxRojo = (CheckBox)findViewById(R.id.checkBoxRojo);
        checkBoxTransparente = (CheckBox)findViewById(R.id.checkBoxTransparente);
        checkBoxVerde = (CheckBox)findViewById(R.id.checkBoxVerde);

        imageView = (ImageView)findViewById(R.id.imageView);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButtonEstirado = (RadioButton)findViewById(R.id.radioButtonEstirado);
        radioButtonCentrado = (RadioButton)findViewById(R.id.radioButtonCentrado);

        imageButtonIronMan = (ImageButton)findViewById(R.id.imageButtonIronMan);
        imageButtonCapitanAmerica = (ImageButton)findViewById(R.id.imageButtonCapitanAmerica);

        activityMain = (LinearLayout)findViewById(R.id.activity_main);
        linearLayoutImage = (LinearLayout)findViewById(R.id.linearLayoutImage);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        checkBoxRojo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    linearLayoutImage.setBackgroundColor(getResources().getColor(R.color.colorRed));
                else
                    linearLayoutImage.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            }
        });

        checkBoxTransparente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    linearLayoutImage.setAlpha(0.5f);
                else
                    linearLayoutImage.setAlpha(1.0f);


            }
        });

        checkBoxVerde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    activityMain.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                else
                    activityMain.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == radioButtonEstirado.getId())
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                if (checkedId == radioButtonCentrado.getId())
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            }
        });

        imageButtonIronMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageDrawable(getDrawable(R.drawable.ironman));

            }
        });

        imageButtonCapitanAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageDrawable(getDrawable(R.drawable.capitanamerica));

            }
        });

    }
}
