package com.example.mobiledevelopment2021citymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class DetailActivity extends FragmentActivity {
    TrafficJam trafficJam;

    TextView txtCity;
    TextView txtAddress;
    TextView txtDistance;
    TextView txtReason;
    TextView txtEmergencyServices;
    TextView txtStartTime;
    TextView txtStillActive;
    TextView txtBlockedLanes;

    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.traffic_jam_detail);

        txtCity = (TextView) findViewById(R.id.txtJamCity);
        txtAddress = (TextView) findViewById(R.id.txtJamAddress);
        txtDistance = (TextView) findViewById(R.id.txtJamDistance);
        txtReason = (TextView) findViewById(R.id.txtJamReason);
        txtEmergencyServices = (TextView) findViewById(R.id.txtJamEmergencyServices);
        txtStartTime = (TextView) findViewById(R.id.txtJamStartTime);
        txtStillActive = (TextView) findViewById(R.id.txtJamStillActive);
        txtBlockedLanes = (TextView) findViewById(R.id.txtJamBlockedLanes);

        Intent intent = getIntent();

        TrafficJam trafficJam = (TrafficJam) intent.getParcelableExtra("TrafficJam");
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
}
