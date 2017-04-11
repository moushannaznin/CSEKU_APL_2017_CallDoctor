package com.cse.calldoctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cse.calldoctor.app.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private int Urology = 0, Hematology = 0, Orthopaedics = 0, Gynaecology = 0, Respiratory = 0, Paediatrics = 0, Cardiology = 0, ENT = 0, Neurology = 0,
            Gastroenterology = 0, Eye = 0, Psychiatry = 0, Skin = 0, Hepatology = 0, Dental = 0, Oncology = 0, Rheumatology = 0, Nutritionist = 0, Dermatology = 0, Endocrinology = 0;

    private ArrayList<String> specialist = new ArrayList<>();
    private RequestQueue requestQueue;
    private boolean doctorResponse = true;
    private boolean specialistResponse = true;

    private String insertDoctorsUrl = AppConfig.URL + "call_doctor/insertDoctors.php";
    private String insertSpecialistUrl = AppConfig.URL + "call_doctor/insertSpecialist.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = ((EditText) findViewById(R.id.name)).getText().toString();
                final String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                final String degree = ((EditText) findViewById(R.id.degree)).getText().toString();
                final String latitude = ((EditText) findViewById(R.id.latitude)).getText().toString();
                final String longitude = ((EditText) findViewById(R.id.longitude)).getText().toString();
                final String address = ((EditText) findViewById(R.id.address)).getText().toString();


                if (!name.equals("") && !phone.equals("")  && !degree.equals("") && !latitude.equals("") && !longitude.equals("") && !address.equals("")) {
                    checkBoxListener();

                    if (specialist.size() > 0) {

                        String specialists = "";

                        for (int i = 0; i < specialist.size(); i++) {
                            specialists = specialists + specialist.get(i);
                            if (i != specialist.size() - 1) {
                                specialists = specialists + ", ";
                            }
                        }

                        // Insert into database
                        registerDoctors(name, phone, degree, latitude, longitude, specialists, address);

                        registerSpecialist();


                        // Clear all values
                        specialist.clear();

                        if (doctorResponse == true && specialistResponse == true) {
                            Toast.makeText(SignUp.this, "Sign up successfully, Thank you.", Toast.LENGTH_LONG).show();
                            finish();
                        } else finish();
                    } else
                        Toast.makeText(SignUp.this, "Nothing is selected", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(SignUp.this, "Please input every field", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Function to store user in MySQL database will post params(name,
     * phone, latitude, longitude) to register url
     */
    private void registerDoctors(final String name, final String phone, final String degree, final String latitude, final String longitude,  final String specialists, final String address) {

        StringRequest request = new StringRequest(Request.Method.POST, insertDoctorsUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                doctorResponse = false;
                Toast.makeText(getApplicationContext(), "Something went wrong! Please try again.", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("name", name);
                parameters.put("phone", phone);
                parameters.put("degree", degree);
                parameters.put("latitude", latitude);
                parameters.put("longitude", longitude);
                parameters.put("specialists", specialists);
                parameters.put("address", address);


                return parameters;
            }
        };
        // Adding request to request queue
        requestQueue.add(request);

    }

    /**
     * Function to store user in MySQL database will post params(name,
     * phone, latitude, longitude) to register url
     */
    private void registerSpecialist() {
        StringRequest request = new StringRequest(Request.Method.POST, insertSpecialistUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                specialistResponse = false;
                Toast.makeText(getApplicationContext(), "Something went wrong! Please try again.", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("Urology", String.valueOf(Urology));
                parameters.put("Hematology", String.valueOf(Hematology));
                parameters.put("Orthopaedics", String.valueOf(Orthopaedics));
                parameters.put("Gynaecology", String.valueOf(Gynaecology));
                parameters.put("Respiratory", String.valueOf(Respiratory));
                parameters.put("Paediatrics", String.valueOf(Paediatrics));
                parameters.put("Cardiology", String.valueOf(Cardiology));
                parameters.put("ENT", String.valueOf(ENT));
                parameters.put("Neurology", String.valueOf(Neurology));
                parameters.put("Gastroenterology", String.valueOf(Gastroenterology));
                parameters.put("Eye", String.valueOf(Eye));
                parameters.put("Psychiatry", String.valueOf(Psychiatry));
                parameters.put("Skin", String.valueOf(Skin));
                parameters.put("Hepatology", String.valueOf(Hepatology));
                parameters.put("Dental", String.valueOf(Dental));
                parameters.put("Oncology",String.valueOf(Oncology));
                parameters.put("Rheumatology", String.valueOf(Rheumatology));
                parameters.put("Nutritionist", String.valueOf(Nutritionist));
                parameters.put("Dermatology", String.valueOf(Dermatology));
                parameters.put("Endocrinology", String.valueOf(Endocrinology));

                return parameters;
            }
        };
        // Adding request to request queue
        requestQueue.add(request);
    }


    /*
    Get all value from check box
    */
    private void checkBoxListener() {

        if (((CheckBox) findViewById(R.id.checkbox)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox).getTag().toString());
            Urology = 1;
        } else Urology = 0;
        if (((CheckBox) findViewById(R.id.checkbox1)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox1).getTag().toString());
            Hematology = 1;
        } else Hematology = 0;
        if (((CheckBox) findViewById(R.id.checkbox2)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox2).getTag().toString());
            Orthopaedics = 1;
        } else Orthopaedics = 0;
        if (((CheckBox) findViewById(R.id.checkbox3)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox3).getTag().toString());
            Gynaecology = 1;
        } else Gynaecology = 0;
        if (((CheckBox) findViewById(R.id.checkbox4)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox4).getTag().toString());
            Respiratory = 1;
        } else Respiratory = 0;
        if (((CheckBox) findViewById(R.id.checkbox5)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox5).getTag().toString());
            Paediatrics = 1;
        } else Paediatrics = 0;
        if (((CheckBox) findViewById(R.id.checkbox6)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox6).getTag().toString());
            Cardiology = 1;
        } else Cardiology = 0;
        if (((CheckBox) findViewById(R.id.checkbox7)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox7).getTag().toString());
            ENT = 1;
        } else ENT = 0;
        if (((CheckBox) findViewById(R.id.checkbox8)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox8).getTag().toString());
            Neurology = 1;
        } else Neurology = 0;
        if (((CheckBox) findViewById(R.id.checkbox9)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox9).getTag().toString());
            Gastroenterology = 1;
        } else Gastroenterology = 0;
        if (((CheckBox) findViewById(R.id.checkbox10)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox10).getTag().toString());
            Eye = 1;
        } else Eye = 0;
        if (((CheckBox) findViewById(R.id.checkbox11)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox11).getTag().toString());
            Psychiatry = 1;
        } else Psychiatry = 0;
        if (((CheckBox) findViewById(R.id.checkbox12)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox12).getTag().toString());
            Skin = 1;
        } else Skin = 0;
        if (((CheckBox) findViewById(R.id.checkbox13)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox13).getTag().toString());
            Hepatology = 1;
        } else Hepatology = 0;
        if (((CheckBox) findViewById(R.id.checkbox14)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox14).getTag().toString());
            Dental = 1;
        } else Dental = 0;
        if (((CheckBox) findViewById(R.id.checkbox15)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox15).getTag().toString());
            Oncology = 1;
        } else Oncology = 0;
        if (((CheckBox) findViewById(R.id.checkbox16)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox16).getTag().toString());
            Rheumatology = 1;
        } else Rheumatology = 0;
        if (((CheckBox) findViewById(R.id.checkbox17)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox17).getTag().toString());
            Nutritionist = 1;
        } else Nutritionist = 0;
        if (((CheckBox) findViewById(R.id.checkbox18)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox18).getTag().toString());
            Dermatology = 1;
        } else Dermatology = 0;
        if (((CheckBox) findViewById(R.id.checkbox19)).isChecked()) {
            specialist.add(findViewById(R.id.checkbox19).getTag().toString());
            Endocrinology = 1;
        } else Endocrinology = 0;
    }

}