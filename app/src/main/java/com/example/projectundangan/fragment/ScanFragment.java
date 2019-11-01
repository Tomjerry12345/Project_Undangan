package com.example.projectundangan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectundangan.R;
import com.example.projectundangan.db.DatabaseHelper;
import com.example.projectundangan.db.TamuHelper;
import com.example.projectundangan.model.Tamu;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class ScanFragment extends Fragment {

    Button scanBarcode;
    DatabaseHelper helper;
    ArrayList<Tamu> arrayList;

    private Tamu tamu;

    private TamuHelper tamuHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_scan, container, false);

        return view_frag1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        scanBarcode = view.findViewById(R.id.scan);
        tamuHelper = TamuHelper.getInstance(this.getActivity());

        final IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setCameraId(0);

        scanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentIntegrator.initiateScan();

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode , resultCode , data);
        String[] data1 = result.toString().split("__");

        if (result != null) {
            tamu = new Tamu();
            tamu.setNama(data1[0]);
            tamu.setAlamat(data1[1]);
            long result1 = tamuHelper.insertTamu(tamu);
            if (result1 > 0) {
                tamu.setId((int) result1);
                Toast.makeText(getActivity(), "succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode ,resultCode ,data);
        }
    }

}
