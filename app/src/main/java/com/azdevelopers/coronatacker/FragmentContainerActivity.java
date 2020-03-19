package com.azdevelopers.coronatacker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.azdevelopers.coronatacker.fragments.CountriesFragment;
import com.azdevelopers.coronatacker.fragments.MainFragment;
import com.azdevelopers.coronatacker.fragments.NewsFragment;
import com.azdevelopers.coronatacker.fragments.SymptomsFragment;
import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.MainFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class FragmentContainerActivity extends AppCompatActivity {


    private String currentFragment = "main";
    private AdView mainBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        //Disable ad loading for debugging, Ads is is also test ids in string resources
       //loadAd();
        //String temp = savedInstanceState.getString("currentFragment");
        if (savedInstanceState == null) {


            loadFragment(new MainFragment());
        } else {
            currentFragment = savedInstanceState.getString("currentFragment");
            if (currentFragment.equals("symptoms")) {
                loadFragment(new SymptomsFragment());
            } else if (currentFragment.equals("countries")) {
                loadFragment(new CountriesFragment());
            } else if (currentFragment.equals("news")) {
                loadFragment(new NewsFragment());
            } else {
                loadFragment(new MainFragment());
            }
        }

    }


    public String getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(String currentFragment) {
        this.currentFragment = currentFragment;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }


    public void loadAd(){
        MobileAds.initialize(this, getString(R.string.admob_app_id_original));


        mainBanner = findViewById(R.id.main_adview_bottom_banner);

        AdRequest adRequest = new AdRequest.Builder().build();
        mainBanner.loadAd(adRequest);

    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putString("currentFragment", currentFragment);

    }

    @Override
    public void onBackPressed() {

        if (currentFragment.equals("main")) {

            finishAffinity();
            System.exit(0);
        } else {
            loadFragment(new MainFragment());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_refresh:
                if(isNetworkConnected()) {

                    refreshApp();
                    return true;

                }else{
                    Toast.makeText(FragmentContainerActivity.this, "Internet Unavailable", Toast.LENGTH_LONG).show();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void refreshApp(){

        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
