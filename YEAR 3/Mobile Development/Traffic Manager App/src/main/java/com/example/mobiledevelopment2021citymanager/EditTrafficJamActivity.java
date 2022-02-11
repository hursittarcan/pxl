package com.example.mobiledevelopment2021citymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditTrafficJamActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    EditText txtCity;
    EditText txtAddress;
    EditText txtDistance;
    EditText txtReason;
    EditText txtEmergencyServices;
    EditText txtStartTime;
    EditText txtStillActive;
    EditText txtBlockedLanes;

    TrafficJam trafficJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_jam_edit_activity);

        //Databaseconnection via FirebaseUtil Class
        FirebaseUtil.openFirebaseReference("trafficjams");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        //Reference to EditText (all)
        txtCity = (EditText) findViewById(R.id.txtJamCity);
        txtAddress = (EditText) findViewById(R.id.txtJamAddress);
        txtDistance = (EditText) findViewById(R.id.txtJamDistance);
        txtReason = (EditText) findViewById(R.id.txtJamReason);
        txtEmergencyServices = (EditText) findViewById(R.id.txtJamEmergencyServices);
        txtStartTime = (EditText) findViewById(R.id.txtJamStartTime);
        txtStillActive = (EditText) findViewById(R.id.txtJamStillActive);
        txtBlockedLanes = (EditText) findViewById(R.id.txtJamBlockedLanes);

        Intent intent = getIntent();
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_menu:
                saveNewTrafficJam();
                Toast.makeText(this, "Jam added!", Toast.LENGTH_LONG).show();
                clean();
                backToList();
                return true;
            case R.id.delete_menu:
                deleteTrafficJam();
                Toast.makeText(this, "Jam deleted!", Toast.LENGTH_LONG).show();
                clean();
                backToList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
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

        mDatabaseReference.child(trafficJam.getId()).setValue(trafficJam);
    }

    private void deleteTrafficJam() {
        if (trafficJam == null) {
            Toast.makeText(this, "Save the traffic jam first", Toast.LENGTH_SHORT).show();
        }
        mDatabaseReference.child(trafficJam.getId()).removeValue();
    }

    private void backToList() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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