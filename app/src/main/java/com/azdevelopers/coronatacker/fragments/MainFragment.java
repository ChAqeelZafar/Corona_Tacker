package com.azdevelopers.coronatacker.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.azdevelopers.coronatacker.R;
import com.azdevelopers.coronatacker.TempActivity;
import com.azdevelopers.coronatacker.models.CoronaCounts;
import com.azdevelopers.coronatacker.viewmodels.MainFragmentViewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.zip.Inflater;

public class MainFragment extends Fragment {
    private MainFragmentViewModel mainFragmentViewModel;


    //Main
    private TextView timeText, casesText, countryText, updatesText, symptomsText;

    private TextView totalCasesText, deathsText, recoveredText;
    private TextView activeCasesText, mildText, mildPerText, seriousText, seriousPerText;
    private TextView closedCasesText, recovredMinitext, recoveredPerText, deathMiniText, deathPerText;

    private TextView casesTextB, countryTextB, updatesTextB, symptomsTextB;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);


        mainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel.class);
        mainFragmentViewModel.init();

        bindIds(view);
        setListeners();



        mainFragmentViewModel.getCoronaCounts().observe(getActivity(), new Observer<CoronaCounts>() {
            @Override
            public void onChanged(CoronaCounts coronaCounts) {
                //CoronaCounts temp = mainFragmentViewModel.getCoronaCounts().getValue();
                    setTextViews(coronaCounts);
            }
        });



        return view;

    }

    public void setListeners(){
        symptomsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SymptomsFragment());
            }
        });
        symptomsTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SymptomsFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }





    public void bindIds(View view){
        timeText = view.findViewById(R.id.main_text_time);
        casesText = view.findViewById(R.id.main_textbtn_cases);
        countryText = view.findViewById(R.id.main_textbtn_country);
        updatesText = view.findViewById(R.id.main_textbtn_updates);
        symptomsText = view.findViewById(R.id.main_textbtn_symptoms);

        totalCasesText = view.findViewById(R.id.main_text_total);
        deathsText = view.findViewById(R.id.main_text_deaths);
        recoveredText = view.findViewById(R.id.main_text_recovered);

        activeCasesText = view.findViewById(R.id.main_text_activecases);
        mildText = view.findViewById(R.id.main_text_mini_mild);
        mildPerText = view.findViewById(R.id.main_text_mini_mild_percent);
        seriousText = view.findViewById(R.id.main_text_mini_serious);
        seriousPerText = view.findViewById(R.id.main_text_mini_serious_percent);

        closedCasesText = view.findViewById(R.id.main_text_closedcases);
        recovredMinitext = view.findViewById(R.id.main_text_mini_recovered);
        recoveredPerText = view.findViewById(R.id.main_text_mini_recovered_percent);
        deathMiniText = view.findViewById(R.id.main_text_mini_deaths);
        deathPerText = view.findViewById(R.id.main_text_mini_deaths_percent);

        casesTextB = view.findViewById(R.id.main_textbtn_bottom_cases);
        countryTextB = view.findViewById(R.id.main_textbtn_bottom_country);
        updatesTextB = view.findViewById(R.id.main_textbtn_bottom_updates);
        symptomsTextB = view.findViewById(R.id.main_textbtn_bottom_symptoms);
    }


    public void setTextViews(CoronaCounts coronaCounts){
        totalCasesText.setText(coronaCounts.getTotalCasesCount());
        deathsText.setText(coronaCounts.getDeathCount());
        recoveredText.setText(coronaCounts.getRecoverCounts());

        activeCasesText.setText(coronaCounts.getActiveCasesCount());
        mildText.setText(coronaCounts.getMildCasesCount());
        mildPerText.setText(getPercentage(coronaCounts.getMildCasesCount(), coronaCounts.getActiveCasesCount()));
        seriousText.setText(coronaCounts.getSeriousCasesCount());
        seriousPerText.setText(getPercentage(coronaCounts.getSeriousCasesCount(), coronaCounts.getActiveCasesCount()));

        closedCasesText.setText(coronaCounts.getClosedCasesCount());
        recovredMinitext.setText(coronaCounts.getRecoverCounts());
        recoveredPerText.setText(getPercentage(coronaCounts.getRecoverCounts(), coronaCounts.getClosedCasesCount()));
        deathMiniText.setText(coronaCounts.getDeathCount());
        deathPerText.setText(getPercentage(coronaCounts.getDeathCount(), coronaCounts.getClosedCasesCount()));

        timeText.setText(coronaCounts.getCurrentTime());
    }

    public String getPercentage(String s1, String s2){
        if(s1!=null && s2!=null) {
            int n1 = Integer.parseInt(s1.replaceAll(",", ""));
            int n2 = Integer.parseInt(s2.replaceAll(",", ""));
            n1 *= 100;
            double percent = (n1 / n2);
            percent = new BigDecimal(percent).setScale(2, RoundingMode.HALF_UP).doubleValue();
            return percent + "%";
        }
        return null;

    }



}


