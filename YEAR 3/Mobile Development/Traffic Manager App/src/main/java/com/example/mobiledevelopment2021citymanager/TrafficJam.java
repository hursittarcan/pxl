package com.example.mobiledevelopment2021citymanager;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class TrafficJam implements Parcelable {
    private String id;
    private String city;
    private String address;
    private String distance;
    private String reason;
    private String emergencyServices;
    private String startTime;
    private String stillActive;
    private String blockedLanes;

    public TrafficJam() {}

    public TrafficJam(String city, String address, String distance, String reason, String emergencyServices, String startTime, String stillActive, String blockedLanes) {
        this.setCity(city);
        this.setAddress(address);
        this.setDistance(distance);
        this.setReason(reason);
        this.setEmergencyServices(emergencyServices);
        this.setStartTime(startTime);
        this.setStillActive(stillActive);
        this.setBlockedLanes(blockedLanes);
    }

    protected TrafficJam(Parcel in) {
        id = in.readString();
        city = in.readString();
        address = in.readString();
        distance = in.readString();
        reason = in.readString();
        emergencyServices = in.readString();
        startTime = in.readString();
        stillActive = in.readString();
        blockedLanes = in.readString();
    }

    public static final Creator<TrafficJam> CREATOR = new Creator<TrafficJam>() {
        @Override
        public TrafficJam createFromParcel(Parcel in) {
            return new TrafficJam(in);
        }

        @Override
        public TrafficJam[] newArray(int size) {
            return new TrafficJam[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(city);
        parcel.writeString(address);
        parcel.writeString(distance);
        parcel.writeString(reason);
        parcel.writeString(emergencyServices);
        parcel.writeString(startTime);
        parcel.writeString(stillActive);
        parcel.writeString(blockedLanes);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEmergencyServices() {
        return emergencyServices;
    }

    public void setEmergencyServices(String emergencyServices) {
        this.emergencyServices = emergencyServices;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStillActive() {
        return stillActive;
    }

    public void setStillActive(String stillActive) {
        this.stillActive = stillActive;
    }

    public String getBlockedLanes() {
        return blockedLanes;
    }

    public void setBlockedLanes(String blockedLanes) {
        this.blockedLanes = blockedLanes;
    }
}
