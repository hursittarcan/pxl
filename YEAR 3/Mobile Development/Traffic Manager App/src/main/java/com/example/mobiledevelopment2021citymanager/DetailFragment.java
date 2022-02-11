package com.example.mobiledevelopment2021citymanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.traffic_jam_detail_fragment, container, false);

        Bundle bundle = getArguments();

        TextView txtCity = (TextView) view.findViewById(R.id.txtJamCity);
        TextView txtAddress = (TextView) view.findViewById(R.id.txtJamAddress);
        TextView txtDistance = (TextView) view.findViewById(R.id.txtJamDistance);
        TextView txtReason = (TextView) view.findViewById(R.id.txtJamReason);
        TextView txtEmergencyServices = (TextView) view.findViewById(R.id.txtJamEmergencyServices);
        TextView txtStartTime = (TextView) view.findViewById(R.id.txtJamStartTime);
        TextView txtStillActive = (TextView) view.findViewById(R.id.txtJamStillActive);
        TextView txtBlockedLanes = (TextView) view.findViewById(R.id.txtJamBlockedLanes);

        String city = "";
        String address = "";
        String distance = "";
        String reason = "";
        String emergencyServices = "";
        String startTime = "";
        String stillActive = "";
        String blockedLanes = "";

        if(bundle != null) {
            TrafficJam trafficJam = (TrafficJam) bundle.getParcelable("TrafficJam");
            city = trafficJam.getCity();
            address = trafficJam.getAddress();
            distance = trafficJam.getDistance();
            reason = trafficJam.getReason();
            emergencyServices = trafficJam.getEmergencyServices();
            startTime = trafficJam.getStartTime();
            stillActive = trafficJam.getStillActive();
            blockedLanes = trafficJam.getBlockedLanes();
        }

        txtCity.setText(city);
        txtAddress.setText(address);
        txtDistance.setText(distance);
        txtReason.setText(reason);
        txtEmergencyServices.setText(emergencyServices);
        txtStartTime.setText(startTime);
        txtStillActive.setText(stillActive);
        txtBlockedLanes.setText(blockedLanes);

        return view;
    }
}