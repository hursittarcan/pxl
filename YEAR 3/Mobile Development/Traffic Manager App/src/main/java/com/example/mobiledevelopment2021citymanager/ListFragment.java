package com.example.mobiledevelopment2021citymanager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.traffic_jam_list_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.rvTrafficJams);

//        Context listContext = getFragmentManager().findFragmentById(R.id.detail)

        final TrafficJamAdapter trafficJamAdapter = new TrafficJamAdapter(this.getActivity());
        recyclerView.setAdapter(trafficJamAdapter);
        LinearLayoutManager trafficJamsLayoutManager =
                new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(trafficJamsLayoutManager);

    }
}
