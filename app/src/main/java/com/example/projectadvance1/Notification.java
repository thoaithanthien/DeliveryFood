package com.example.projectadvance1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectadvance1.adapter.AdapterNotification;
import com.example.projectadvance1.object.ItemNotification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Notification extends AppCompatActivity {
    private String urlRequest = "http://phamthoai123-001-site1.ctempurl.com/jsonnotifi.php";
    private String urlDelete = "http://phamthoai123-001-site1.ctempurl.com/deletenotifi.php";
    private ListView lvNotification;
    private ArrayList<ItemNotification> arrayList;
    private AdapterNotification adapterNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        lvNotification = findViewById(R.id.lv_Notification);
        arrayList = new ArrayList<>();
        adapterNotification = new AdapterNotification(this,R.layout.item_notification, arrayList);
        lvNotification.setAdapter(adapterNotification);
        GetData(urlRequest);

    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arrayList.clear();
                // Goi GetData o fuction deleteNhanVien nen no tu update lai
                // Su dung clear de xoa
                for (int i = 0 ; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrayList.add(new ItemNotification(
                                jsonObject.getInt("Id"),
                                jsonObject.getString("Title"),
                                jsonObject.getString("Des"),
                                jsonObject.getString("Gio"),
                                jsonObject.getString("Anh")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterNotification.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notification.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }

    // su li su kien delete
    public void deleteNotification(String titleNotifi) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("delete data successful")){
                            Toast.makeText(Notification.this, "Delete thanh cong", Toast.LENGTH_SHORT).show();
                            GetData(urlRequest);
                        } else
                            Toast.makeText(Notification.this, "Delete khong thanh cong", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notification.this, "Xay ra loi!!!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Title", String.valueOf(titleNotifi));
                return  params;
            }
        };
        requestQueue.add(request);
    }
}