package com.example.mobiledevelopment2021citymanager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TrafficJamAdapter extends RecyclerView.Adapter<TrafficJamAdapter.TrafficJamViewHolder> {
    ArrayList<TrafficJam> trafficJams;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private Context context;

    public TrafficJamAdapter(Context context) {
        this.context = context;
        FirebaseUtil.openFirebaseReference("trafficjams");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;
        trafficJams = FirebaseUtil.mTrafficJams;
        mChildListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                TrafficJam jam = snapshot.getValue(TrafficJam.class);
                jam.setId(snapshot.getKey());
                trafficJams.add(jam);
                notifyItemInserted(trafficJams.size() - 1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildListener);
    }

    @NonNull
    @Override
    public TrafficJamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_recyclerview, parent, false);
        return new TrafficJamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrafficJamViewHolder holder, int position) {
        TrafficJam jam = trafficJams.get(position);
        holder.bind(jam);

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }
    }

    @Override
    public int getItemCount() {
        return trafficJams.size();
    }

    public class TrafficJamViewHolder extends RecyclerView.ViewHolder {

        TextView tvTrafficJamCity;
        TextView tvTrafficJamAddress;
        TextView tvTrafficJamDistance;
        ImageView ivTrafficView;
        ImageView ivTrafficEdit;


        public TrafficJamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTrafficJamCity = (TextView) itemView.findViewById(R.id.tvTrafficJamCity);
            tvTrafficJamAddress = (TextView) itemView.findViewById(R.id.tvTrafficJamAdress);
            tvTrafficJamDistance = (TextView) itemView.findViewById(R.id.tvTrafficJamDistance);
            ivTrafficView = (ImageView) itemView.findViewById(R.id.imageView);

            ivTrafficView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    TrafficJam selectedTrafficJam = trafficJams.get(position);

                    int orientation = view.getResources().getConfiguration().orientation;
                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

                        Fragment listFragment = (ListFragment) ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(R.id.nav_fragment);

                        Fragment detailFragment = (DetailFragment) ((Fragment) listFragment).getChildFragmentManager().findFragmentById(R.id.detail_fragment);

                        DetailFragment newFragment = new DetailFragment();

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("TrafficJam", selectedTrafficJam);
                        newFragment.setArguments(bundle);

                        FragmentTransaction transaction = ((Fragment) listFragment).getChildFragmentManager().beginTransaction();
                        transaction.replace(detailFragment.getId(), newFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    } else {
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("TrafficJam", selectedTrafficJam);
                        view.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void bind(TrafficJam jam) {
            tvTrafficJamCity.setText(jam.getCity());
            tvTrafficJamAddress.setText(jam.getAddress());
            tvTrafficJamDistance.setText(jam.getDistance());
        }
    }
}
