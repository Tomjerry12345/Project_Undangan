package com.example.projectundangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.projectundangan.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment pageContent = new HomeFragment();
    public static final String KEY_FRAGMENT = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, pageContent).commit();

        } else {
            pageContent = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, pageContent).commit();

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, pageContent);
        super.onSaveInstanceState(outState);
    }
}
