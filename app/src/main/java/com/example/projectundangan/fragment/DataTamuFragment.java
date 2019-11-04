package com.example.projectundangan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectundangan.R;
import com.example.projectundangan.adapter.AdapterDataTamu;
import com.example.projectundangan.db.TamuHelper;

public class DataTamuFragment extends Fragment {

    private RecyclerView recyclerView;

    AdapterDataTamu adapterDafrtarTamu;

    public DataTamuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_data_tamu
                , container, false);

        recyclerView = view_frag1.findViewById(R.id.recylerview);

        setRecyclerView();

        return view_frag1;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//
//    }

    private void setRecyclerView(){
        AdapterDataTamu adapterDataTamu = new AdapterDataTamu(getContext());
        adapterDataTamu.notifyDataSetChanged();
        TamuHelper tamuHelper = TamuHelper.getInstance(getContext());
        adapterDataTamu.setListTamu(tamuHelper.getAllTamu());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterDataTamu);
        recyclerView.setNestedScrollingEnabled(false);
    }

}
