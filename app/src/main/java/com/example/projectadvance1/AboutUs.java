package com.example.projectadvance1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectadvance1.adapter.AdapterAboutUs;
import com.example.projectadvance1.object.ContactAS;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AboutUs extends AppCompatActivity {
    // Initialize variable
    DrawerLayout drawerLayout;

    private String urlRequest = "http://phamthoai123-001-site1.ctempurl.com/jsonaboutus.php";
    private ListView lvContact;
    private ArrayList<ContactAS> arrayList;
    private AdapterAboutUs adapterAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Web service
        lvContact = findViewById(R.id.lv_AboutUs);
        arrayList = new ArrayList<>();
        adapterAboutUs = new AdapterAboutUs(this, R.layout.item_about_us, arrayList);
        lvContact.setAdapter(adapterAboutUs);
        GetData(urlRequest);

    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arrayList.clear();
                // Goi GetData o fuction deleteNhanVien nen no tu update lai
                // Su dung clear de xoa
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrayList.add(new ContactAS(
                                jsonObject.getInt("Id"),
                                jsonObject.getString("Phone"),
                                jsonObject.getString("Email"),
                                jsonObject.getString("About")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterAboutUs.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AboutUs.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }
}

//    public void ClickMenu(View view) {
//        // Open drawer
//        MainActivity.openDrawer(drawerLayout);
//    }
//
//    public void ClickLogo(View view) {
//        // Close drawer
//        MainActivity.closeDrawer(drawerLayout);
//    }
//
//    public void ClickHome(View view) {
//        // Redirect activity to home
//        MainActivity.redirectActivity(this, MainActivity.class);
//    }
//
//    public void ClickDashBoard(View view) {
//        // Redirect activity to about us
//        MainActivity.redirectActivity(this, KindOfFoods.class);
//    }
//
//    public void ClickAboutUs(View view) {
//        // Recreate activity
//        recreate();
//    }
//
//    public void ClickLogout(View view) {
//        // Close app
//        MainActivity.logout(this);
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Close drawer
//        MainActivity.closeDrawer(drawerLayout);
//    }