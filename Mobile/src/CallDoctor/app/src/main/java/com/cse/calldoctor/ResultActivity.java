package com.cse.calldoctor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cse.calldoctor.app.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    private String showSpecialistUrl =  AppConfig.URL + "call_doctor/showSpecialist.php";

    private ProgressDialog dialog;

    private List<Specialist> specialists = new ArrayList<Specialist>();
    private ListView listView;
    private Adapter adapter;

    // local members
    private String Urology,Hematology,Orthopaedics,Gynaecology,Respiratory,Paediatrics,Cardiology,ENT,Neurology,
            Gastroenterology,Eye,Psychiatry,Skin,Hepatology,Dental,Oncology,Rheumatology,Nutritionist,Dermatology,Endocrinology;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get all value from check box
        searchValue();

        listView = (ListView) findViewById(R.id.listView);
        adapter=new Adapter(this, specialists);
        listView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, showSpecialistUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    if (jsonArray.length() != 0) {
                        //parsing json
                        for(int i=0; i<response.length(); i++){
                            try{
                                JSONObject obj = jsonArray.getJSONObject(i);
                                Specialist specialist = new Specialist();
                                specialist.setName(obj.getString("name"));
                                specialist.setPhone(obj.getString("phone"));
                                specialist.setDegree(obj.getString("degree"));
                                specialist.setLatitude(obj.getDouble("latitude"));
                                specialist.setLongitude(obj.getDouble("longitude"));
                                specialist.setSpecialist(obj.getString("specialists"));
                                specialist.setAddress(obj.getString("address"));

                                //add to array
                                specialists.add(specialist);
                            }catch(JSONException ex){
                            }
                        }
                        adapter.notifyDataSetChanged();

                    } else Toast.makeText(getApplicationContext(), "No result found!", Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong! Please try again.", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                // Posting params to register url
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("Urology", Urology);
                parameters.put("Hematology", Hematology);
                parameters.put("Orthopaedics", Orthopaedics);
                parameters.put("Gynaecology", Gynaecology);
                parameters.put("Respiratory", Respiratory);
                parameters.put("Paediatrics", Paediatrics);
                parameters.put("Cardiology", Cardiology);
                parameters.put("ENT", ENT);
                parameters.put("Neurology", Neurology);
                parameters.put("Gastroenterology", Gastroenterology);
                parameters.put("Eye", Eye);
                parameters.put("Psychiatry", Psychiatry);
                parameters.put("Skin", Skin);
                parameters.put("Hepatology", Hepatology);
                parameters.put("Dental", Dental);
                parameters.put("Oncology", Oncology);
                parameters.put("Rheumatology", Rheumatology);
                parameters.put("Nutritionist", Nutritionist);
                parameters.put("Dermatology", Dermatology);
                parameters.put("Endocrinology", Endocrinology);

                return parameters;
            }
        };
        // Adding request to request queue
        requestQueue.add(request);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //getting data for row
                final Specialist specialist = specialists.get(position);

                Intent i = new Intent(getApplicationContext(), DoctorDetails.class);
                i.putExtra("name", specialist.getName());
                i.putExtra("phone", specialist.getPhone());
                i.putExtra("degree", specialist.getDegree());
                i.putExtra("latitude", specialist.getLatitude());
                i.putExtra("longitude", specialist.getLongitude());
                i.putExtra("specialist", specialist.getSpecialist());
                i.putExtra("address", specialist.getAddress());

                startActivity(i);
            }
        });

    }

    public void hideDialog(){
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }
    }

    /*
    Get all value from check box
    */

    public void searchValue() {
        Urology = getIntent().getExtras().getString("Urology");
        Hematology = getIntent().getExtras().getString("Hematology");
        Orthopaedics = getIntent().getExtras().getString("Orthopaedics");
        Gynaecology = getIntent().getExtras().getString("Gynaecology");
        Respiratory = getIntent().getExtras().getString("Respiratory");
        Paediatrics = getIntent().getExtras().getString("Paediatrics");
        Cardiology = getIntent().getExtras().getString("Cardiology");
        ENT = getIntent().getExtras().getString("ENT");
        Neurology = getIntent().getExtras().getString("Neurology");
        Gastroenterology = getIntent().getExtras().getString("Gastroenterology");
        Eye = getIntent().getExtras().getString("Eye");
        Psychiatry = getIntent().getExtras().getString("Psychiatry");
        Skin = getIntent().getExtras().getString("Skin");
        Hepatology = getIntent().getExtras().getString("Hepatology");
        Dental = getIntent().getExtras().getString("Dental");
        Oncology = getIntent().getExtras().getString("Oncology");
        Rheumatology = getIntent().getExtras().getString("Rheumatology");
        Nutritionist = getIntent().getExtras().getString("Nutritionist");
        Dermatology = getIntent().getExtras().getString("Dermatology");
        Endocrinology = getIntent().getExtras().getString("Endocrinology");
    }
}
