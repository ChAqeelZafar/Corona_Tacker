package com.azdevelopers.coronatacker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.azdevelopers.coronatacker.fragments.CountriesFragment;
import com.azdevelopers.coronatacker.fragments.MainFragment;
import com.azdevelopers.coronatacker.fragments.NewsFragment;
import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.MainFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;

public class TempActivity extends AppCompatActivity {
    private MainFragmentViewModel mainFragmentViewModel;
    private CountriesFragmentViewModel countriesFragmentViewModel;
    private NewsFragmentViewModel newsFragmentViewModel;

    private Button btn, btnF2, btnF3;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        mainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel.class);
        mainFragmentViewModel.init();

        countriesFragmentViewModel = ViewModelProviders.of(this).get(CountriesFragmentViewModel.class);
        countriesFragmentViewModel.init();
//
//
//        newsFragmentViewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel.class);
//        newsFragmentViewModel.init();

        loadFragment(new MainFragment());


        btn = findViewById(R.id.temp_btn_btn);
        btnF2 = findViewById(R.id.temp_btn_fragment2);
        btnF3 = findViewById(R.id.temp_btn_fragment3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MainFragment());
            }
        });

        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CountriesFragment());
            }
        });

        btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NewsFragment());
            }
        });
    }


    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }
}
