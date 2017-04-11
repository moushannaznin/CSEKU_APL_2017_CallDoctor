package com.cse.calldoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchDoctor extends AppCompatActivity {

    // uiControls
    Button btnSearch;

    // local members
    private String Urology,Hematology,Orthopaedics,Gynaecology,Respiratory,Paediatrics,Cardiology,ENT,Neurology,
            Gastroenterology,Eye,Psychiatry,Skin,Hepatology,Dental,Oncology,Rheumatology,Nutritionist,Dermatology,Endocrinology;

    private ArrayList<String> specialist = new ArrayList<>();

    String sSpecialist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_doctor);

        btnSearch =(Button)findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxListener();

                if (specialist.size() > 0) {

                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("Urology", Urology);
                    i.putExtra("Hematology", Hematology);
                    i.putExtra("Orthopaedics", Orthopaedics);
                    i.putExtra("Gynaecology", Gynaecology);
                    i.putExtra("Respiratory", Respiratory);
                    i.putExtra("Paediatrics", Paediatrics);
                    i.putExtra("Cardiology", Cardiology);
                    i.putExtra("ENT", ENT);
                    i.putExtra("Neurology", Neurology);
                    i.putExtra("Gastroenterology", Gastroenterology);
                    i.putExtra("Eye", Eye);
                    i.putExtra("Psychiatry", Psychiatry);
                    i.putExtra("Skin", Skin);
                    i.putExtra("Hepatology", Hepatology);
                    i.putExtra("Dental", Dental);
                    i.putExtra("Oncology", Oncology);
                    i.putExtra("Rheumatology", Rheumatology);
                    i.putExtra("Nutritionist", Nutritionist);
                    i.putExtra("Dermatology", Dermatology);
                    i.putExtra("Endocrinology", Endocrinology);

                    startActivity(i);

                    // Clear all values from array list
                    specialist.clear();

                } else
                    Toast.makeText(SearchDoctor.this, "Nothing is selected", Toast.LENGTH_SHORT).show();

            }
        });

    }

    /*
    Get all value from check box
    */
    private void checkBoxListener() {

        if (((CheckBox) findViewById(R.id.checkbox)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox).getTag().toString());
            Urology = "Urology";
        } else Urology = "null";
        if (((CheckBox) findViewById(R.id.checkbox1)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox1).getTag().toString());
            Hematology = "Hematology";
        } else Hematology = "null";
        if (((CheckBox) findViewById(R.id.checkbox2)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox2).getTag().toString());
            Orthopaedics = "Orthopaedics";
        } else Orthopaedics = "null";
        if (((CheckBox) findViewById(R.id.checkbox3)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox3).getTag().toString());
            Gynaecology = "Gynaecology";
        } else Gynaecology = "null";
        if (((CheckBox) findViewById(R.id.checkbox4)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox4).getTag().toString());
            Respiratory = "Respiratory";
        } else Respiratory = "null";
        if (((CheckBox) findViewById(R.id.checkbox5)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox5).getTag().toString());
            Paediatrics = "Paediatrics";
        } else Paediatrics = "null";
        if (((CheckBox) findViewById(R.id.checkbox6)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox6).getTag().toString());
            Cardiology = "Cardiology";
        } else Cardiology = "null";
        if (((CheckBox) findViewById(R.id.checkbox7)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox7).getTag().toString());
            ENT = "ENT";
        } else ENT = "null";
        if (((CheckBox) findViewById(R.id.checkbox8)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox8).getTag().toString());
            Neurology = "Neurology";
        } else Neurology = "null";
        if (((CheckBox) findViewById(R.id.checkbox9)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox9).getTag().toString());
            Gastroenterology = "Gastroenterology";
        } else Gastroenterology = "null";
        if (((CheckBox) findViewById(R.id.checkbox10)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox10).getTag().toString());
            Eye = "Eye";
        } else Eye = "null";
        if (((CheckBox) findViewById(R.id.checkbox11)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox11).getTag().toString());
            Psychiatry = "Psychiatry";
        } else Psychiatry = "null";
        if (((CheckBox) findViewById(R.id.checkbox12)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox12).getTag().toString());
            Skin = "Skin";
        } else Skin = "null";
        if (((CheckBox) findViewById(R.id.checkbox13)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox13).getTag().toString());
            Hepatology = "Hepatology";
        } else Hepatology = "null";
        if (((CheckBox) findViewById(R.id.checkbox14)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox14).getTag().toString());
            Dental = "Dental";
        } else Dental = "null";
        if (((CheckBox) findViewById(R.id.checkbox15)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox15).getTag().toString());
            Oncology = "Oncology";
        } else Oncology = "null";
        if (((CheckBox) findViewById(R.id.checkbox16)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox16).getTag().toString());
            Rheumatology = "Rheumatology";
        } else Rheumatology = "null";
        if (((CheckBox) findViewById(R.id.checkbox17)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox17).getTag().toString());
            Nutritionist = "Nutritionist";
        } else Nutritionist = "null";
        if (((CheckBox) findViewById(R.id.checkbox18)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox18).getTag().toString());
            Dermatology = "Dermatology";
        } else Dermatology = "null";
        if (((CheckBox) findViewById(R.id.checkbox19)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox19).getTag().toString());
            Endocrinology = "Endocrinology";
        } else Endocrinology = "null";
    }
}
