package com.azdevelopers.coronatacker;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.MainFragmentViewModel;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    private CountriesFragmentViewModel countriesFragmentViewModel;
    private NewsFragmentViewModel newsFragmentViewModel;
    private MainFragmentViewModel mainFragmentViewModel;
    private boolean isNetwork = false;

    @Override
    public void initSplash(ConfigSplash configSplash) {



            mainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel.class);
            mainFragmentViewModel.init();

            countriesFragmentViewModel = ViewModelProviders.of(this).get(CountriesFragmentViewModel.class);
            countriesFragmentViewModel.init();

            newsFragmentViewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel.class);
            newsFragmentViewModel.init();




            /* you don't have to override every property */

            //Customize Circular Reveal
            configSplash.setBackgroundColor(R.color.black); //any color you want form colors.xml
            configSplash.setAnimCircularRevealDuration(1500); //int ms
            configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
            configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

            //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

            //Customize Logo
            configSplash.setLogoSplash(R.drawable.logo); //or any other drawable
            configSplash.setAnimLogoSplashDuration(800); //int ms
            configSplash.setAnimLogoSplashTechnique(Techniques.Landing); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


            //Customize Title
            configSplash.setTitleSplash("CORONA TRACKER");
            configSplash.setTitleTextColor(R.color.splash_title);
            configSplash.setTitleTextSize(30f); //float value
            configSplash.setAnimTitleDuration(2000);
            //configSplash.setTitleFont("asset/font/splashfont.ttf");
            //configSplash.setAnimTitleTechnique(Techniques.FadeInDown);
            //configSplash.setTitleFont("asset/splashfont.ttf"); //provide string to your font



    }

    @Override
    public void animationsFinished() {

        Intent intent = new Intent(SplashActivity.this, FragmentContainerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }



}
