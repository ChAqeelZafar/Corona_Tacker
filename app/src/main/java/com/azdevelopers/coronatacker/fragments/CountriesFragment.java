package com.azdevelopers.coronatacker.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.azdevelopers.coronatacker.FragmentContainerActivity;
import com.azdevelopers.coronatacker.R;
import com.azdevelopers.coronatacker.models.CountryData;
import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;



import java.util.List;


public class CountriesFragment extends Fragment {

    private CountriesFragmentViewModel countriesFragmentViewModel;
    //Table Layout and Table Row for populate countries data in table
    private TableLayout tv;
    private TableRow tr;
    //Menu buttons to switch between fragments
    private TextView  casesText, countryText, updatesText, symptomsText;
    //For showing progress bar
    private ScrollView mainHorizontalScrollView ;
    private ProgressBar loadingProgress;
    //Fragment View
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_countries, container, false);

        bindIds();
        setListeners();


        ((FragmentContainerActivity) getActivity()).setCurrentFragment("countries");

        switchProgress(true);

        countriesFragmentViewModel = ViewModelProviders.of(this).get(CountriesFragmentViewModel.class);
        countriesFragmentViewModel.getCountriesData().observe(getViewLifecycleOwner(), new Observer<List<CountryData>>() {
            @Override
            public void onChanged(List<CountryData> countryData) {
                    setTable(countryData);
                    switchProgress(false);
            }
        });

        return view;
    }

    public void switchProgress(boolean isShow){
        if(isShow){
            loadingProgress.setVisibility(View.VISIBLE);
            mainHorizontalScrollView.setVisibility(View.GONE);
        }else{
            loadingProgress.setVisibility(View.GONE);
            mainHorizontalScrollView.setVisibility(View.VISIBLE);
        }
    }

    public void bindIds(){
        tv = view.findViewById(R.id.countires_table_main);

        mainHorizontalScrollView = view.findViewById(R.id.countries_scrollview_horizontal);
        loadingProgress = view.findViewById(R.id.countries_progress_loading);

        casesText = view.findViewById(R.id.countries_textbtn_cases);
        countryText = view.findViewById(R.id.countries_textbtn_country);
        updatesText = view.findViewById(R.id.countries_textbtn_updates);
        symptomsText = view.findViewById(R.id.countries_textbtn_symptoms);
    }

    public void setListeners(){
        symptomsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SymptomsFragment());
            }
        });

        countryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CountriesFragment());
            }
        });



        updatesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NewsFragment());
            }
        });


        casesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MainFragment());
            }
        });

    }




    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }

    public void setTable(List<CountryData> countryData){


        //tv.removeAllViews();
        int flag = 1;
        for(int i=0; i<countryData.size(); i++){
            tr=new TableRow(getContext());

            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            // this will be executed once for headers
            if(flag==1){

                tr.addView(setTextView("COUNTRY  "));
                tr.addView(setTextView("TOTAL CASES  "));
                tr.addView(setTextView("NEW CASES  "));
                tr.addView(setTextView("TOTAL DEATHS  "));
                tr.addView(setTextView("NEW DEATHS  "));
                tr.addView(setTextView("TOTAL RECOVERED  "));
                tr.addView(setTextView("ACTIVE CASES  "));
                tr.addView(setTextView("SERIOUS CASES  "));
                tr.addView(setTextView("TOT CASES/ 1M"));


                tv.addView(tr);

                final View vline = new View(getContext());
                vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                tv.addView(vline); // add line below heading
                flag=0;
            } else {
                CountryData cd = countryData.get(i-1);

                tr.addView(setCellTextView( cd.getCountryName(), i%2));
                tr.addView(setCellTextView( cd.getTotalCases(), i%2));
                tr.addView(setCellTextView( cd.getNewCases(), i%2));
                tr.addView(setCellTextView( cd.getTotalDeaths(), i%2));
                tr.addView(setCellTextView( cd.getNewDeaths(), 3));
                tr.addView(setCellTextView( cd.getTotalRecoverd(), 2));
                tr.addView(setCellTextView( cd.getActiveCases(), i%2));
                tr.addView(setCellTextView( cd.getSeriousCases(), i%2));
                tr.addView(setCellTextView( cd.getTotCases(), i%2));



                tv.addView(tr);
                final View vline1 = new View(getContext());
                vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
                vline1.setBackgroundColor(Color.WHITE);
                tv.addView(vline1);  // add line below each row
            }
        }
    }

    //backColor 0 for grey, 1 for white
    public TextView setCellTextView(String cellText, int backColor){
        TextView textView = new TextView(getContext());
        textView.setPadding(10,0,0,0);
        textView.setTextSize(15);
        textView.setText(cellText);
        textView.setTextColor(Color.BLACK);
        if(backColor==0){
            textView.setBackgroundColor(getResources().getColor(R.color.main_timing_grey));
        }else if(backColor==1){
            textView.setBackgroundColor(Color.WHITE);
        }else if(backColor==2){
            textView.setBackgroundColor(getResources().getColor(R.color.recovered_number));
        }else if(backColor==3){
            textView.setBackgroundColor(getResources().getColor(R.color.red));
        }

        return textView;
    }



    public TextView setTextView(String heading){
        TextView textView = new TextView(getContext());
        textView.setPadding(10,0,10,0);
        textView.setTextColor(Color.RED);
        textView.setText(heading);
        textView.setTextSize(20);
        return textView;
    }



}
