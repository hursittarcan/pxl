package com.example.mobiledevelopment2021citymanager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddFragment extends Fragment {

    private ActivityResultLauncher<String> mPermissionResult = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {}
            });
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    MenuItem menuBar;

    TextView txtTitle;
    EditText txtCity;
    EditText txtAddress;
    Button btnLocation;
    EditText txtDistance;
    EditText txtReason;
    EditText txtEmergencyServices;
    EditText txtStartTime;
    EditText txtStillActive;
    EditText txtBlockedLanes;

    TrafficJam trafficJam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.traffic_jam_add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menuBar = (MenuItem) getView().findViewById(R.id.navigation_list);

        txtTitle = (TextView) getView().findViewById(R.id.txtJamTitle);
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewTrafficJam();

                clean();
            }
        });

        btnLocation = (Button) getView().findViewById(R.id.btnLocation);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPermissionResult.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
                mPermissionResult.launch(Manifest.permission.ACCESS_FINE_LOCATION);
                mPermissionResult.launch(Manifest.permission.INTERNET);

                getLocation();
            }
        });

        //Databaseconnection via FirebaseUtil Class
        FirebaseUtil.openFirebaseReference("trafficjams");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        //Reference to EditText (all)
        txtCity = (EditText) getView().findViewById(R.id.txtJamCity);
        txtAddress = (EditText) getView().findViewById(R.id.txtJamAddress);
        txtDistance = (EditText) getView().findViewById(R.id.txtJamDistance);
        txtReason = (EditText) getView().findViewById(R.id.txtJamReason);
        txtEmergencyServices = (EditText) getView().findViewById(R.id.txtJamEmergencyServices);
        txtStartTime = (EditText) getView().findViewById(R.id.txtJamStartTime);
        txtStillActive = (EditText) getView().findViewById(R.id.txtJamStillActive);
        txtBlockedLanes = (EditText) getView().findViewById(R.id.txtJamBlockedLanes);

        Intent intent = getActivity().getIntent();
        TrafficJam trafficJam = (TrafficJam) intent.getSerializableExtra("TrafficJam");
        if (trafficJam == null) {
            trafficJam = new TrafficJam();
        }
        this.trafficJam = trafficJam;

        txtCity.setText(trafficJam.getCity());
        txtAddress.setText(trafficJam.getAddress());
        txtDistance.setText(trafficJam.getDistance());
        txtReason.setText(trafficJam.getReason());
        txtEmergencyServices.setText(trafficJam.getEmergencyServices());
        txtStartTime.setText(trafficJam.getStartTime());
        txtStillActive.setText(trafficJam.getStillActive());
        txtBlockedLanes.setText(trafficJam.getBlockedLanes());
    }

    private void getLocation() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

            }
        });

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        //https://maps.googleapis.com/maps/api/geocode/json?latlng=" + location.getLatitude() + "," + location.getLongitude() + "&key=AIzaSyAWQuwruO1DuFXWRd2eCgGSi_H4veCfICg
        String url = "http://api.positionstack.com/v1/reverse?access_key=ab1f917520d436920b34d8141363e78a&query=" + location.getLatitude() + "," + location.getLongitude() + "&limit=1";

//        Log.d("URL", url);

        sendAndRequestResponse(url);

    }

    private void sendAndRequestResponse(String url) {
        mRequestQueue = Volley.newRequestQueue(getActivity());

        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject objectResponse = new JSONObject(response);
                    JSONArray dataArray = (JSONArray) objectResponse.get("data");
                    JSONObject dataObject = (JSONObject) dataArray.get(0);

                    String city = dataObject.get("locality").toString();
                    String address = dataObject.get("name").toString();

                    txtCity.setText(city);
                    txtAddress.setText(address);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);

    }

    private void saveNewTrafficJam() {
        trafficJam.setCity(txtCity.getText().toString());
        trafficJam.setAddress(txtAddress.getText().toString());
        trafficJam.setDistance(txtDistance.getText().toString());
        trafficJam.setReason(txtReason.getText().toString());
        trafficJam.setEmergencyServices(txtEmergencyServices.getText().toString());
        trafficJam.setStartTime(txtStartTime.getText().toString());
        trafficJam.setStillActive(txtStillActive.getText().toString());
        trafficJam.setBlockedLanes(txtBlockedLanes.getText().toString());

        if (trafficJam.getId() == null) {
            mDatabaseReference.push().setValue(trafficJam);
        }
        else {
            mDatabaseReference.child(trafficJam.getId()).setValue(trafficJam);
        }
    }

    private void clean() {
        txtCity.setText("");
        txtAddress.setText("");
        txtDistance.setText("");
        txtReason.setText("");
        txtEmergencyServices.setText("");
        txtStartTime.setText("");
        txtStillActive.setText("");
        txtBlockedLanes.setText("");

        txtCity.requestFocus();
    }
}
