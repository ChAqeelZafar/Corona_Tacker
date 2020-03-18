package com.azdevelopers.coronatacker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azdevelopers.coronatacker.fragments.CountriesFragment;
import com.azdevelopers.coronatacker.fragments.MainFragment;
import com.azdevelopers.coronatacker.fragments.NewsFragment;
import com.azdevelopers.coronatacker.fragments.SymptomsFragment;
import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.MainFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;

public class FragmentContainerActivity extends AppCompatActivity {


    private String currentFragment = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        //String temp = savedInstanceState.getString("currentFragment");
        if(savedInstanceState==null) {


            loadFragment(new MainFragment());
        }else{
            currentFragment = savedInstanceState.getString("currentFragment");
            if(currentFragment.equals("symptoms")){
                loadFragment(new SymptomsFragment());
            }else if(currentFragment.equals("countries")){
                loadFragment(new CountriesFragment());
            }else if(currentFragment.equals("news")){
                loadFragment(new NewsFragment());
            }else{
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

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }

//    private void loadMainFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
//        fragmentTransaction.addToBackStack(fragment.toString());
//        fragmentTransaction.commit();
//    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putString("currentFragment", currentFragment);

    }

//    @Override
//    public void onBackPressed(){
////        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
////            finish();
////            System.exit(0);
////        }else{
////            loadMainFragment(new MainFragment());
////        }
//        if(currentFragment.equals("main")){
//
//            super.onBackPressed();
//        }else{
//            loadFragment(new MainFragment());
//        }
//
//    }
}
