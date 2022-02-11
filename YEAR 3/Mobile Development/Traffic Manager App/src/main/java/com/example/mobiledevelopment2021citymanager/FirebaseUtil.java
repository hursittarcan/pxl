package com.example.mobiledevelopment2021citymanager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil {
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private static FirebaseUtil firebaseUtil;
    public static ArrayList<TrafficJam> mTrafficJams;

    private FirebaseUtil() {}

    public static void openFirebaseReference(String ref) {
        if (firebaseUtil == null) {
            firebaseUtil = new FirebaseUtil();
            mFirebaseDatabase = mFirebaseDatabase.getInstance();
        }
        mTrafficJams = new ArrayList<TrafficJam>();
        mDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }
}
