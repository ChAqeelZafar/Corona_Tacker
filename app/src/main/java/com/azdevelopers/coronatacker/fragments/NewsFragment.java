package com.azdevelopers.coronatacker.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.azdevelopers.coronatacker.FragmentContainerActivity;
import com.azdevelopers.coronatacker.R;
import com.azdevelopers.coronatacker.models.NewsUpdateData;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;

import java.util.List;


public class NewsFragment extends Fragment {

    private NewsFragmentViewModel newsFragmentViewModel;

    private LinearLayout linearLayout;

    private TextView casesText, countryText, updatesText, symptomsText;
    //For bottom menu text button to switch betweeen fragments
    private TextView casesTextB, countryTextB, updatesTextB, symptomsTextB;
    private ProgressBar loadingProgress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        bindIds(view);
        setListeners();

        ((FragmentContainerActivity) getActivity()).setCurrentFragment("news");

        newsFragmentViewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel.class);
        newsFragmentViewModel.getNewsUpdates().observe(getViewLifecycleOwner(), new Observer<List<NewsUpdateData>>() {
            @Override
            public void onChanged(List<NewsUpdateData> newsUpdateData) {
                setTextViews(newsUpdateData);
                loadingProgress.setVisibility(View.GONE);
            }
        });

        return view;
    }

    public void bindIds(View view){

        casesText = view.findViewById(R.id.news_textbtn_cases);
        countryText = view.findViewById(R.id.news_textbtn_country);
        updatesText = view.findViewById(R.id.news_textbtn_updates);
        symptomsText = view.findViewById(R.id.news_textbtn_symptoms);

        linearLayout = view.findViewById(R.id.news_fragment_linearlayout);

        casesTextB = view.findViewById(R.id.news_textbtn_bottom_cases);
        countryTextB = view.findViewById(R.id.news_textbtn_bottom_country);
        updatesTextB = view.findViewById(R.id.news_textbtn_bottom_updates);
        symptomsTextB = view.findViewById(R.id.news_textbtn_bottom_symptoms);

        loadingProgress = view.findViewById(R.id.news_progress_loading);
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

        countryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CountriesFragment());
            }
        });

        countryTextB.setOnClickListener(new View.OnClickListener() {
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
        updatesTextB.setOnClickListener(new View.OnClickListener() {
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
        casesTextB.setOnClickListener(new View.OnClickListener() {
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

    public void setTextViews(List<NewsUpdateData> newsUpdateData){

        for(int i=0; i<newsUpdateData.size(); i++){
            NewsUpdateData currentNews = newsUpdateData.get(i);
            linearLayout.addView(setSingleNews(currentNews.getNews()));
            linearLayout.addView(setSingleSrc(currentNews.getSourceUrl()));
        }
    }

    public TextView setSingleNews(String news){
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setPadding(10,0,10,0);
        textView.setText("►"+news);
        textView.setTextSize(15);
        return textView;

    }
    public TextView setSingleSrc(final String src){
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setPadding(10,0,10,0);
        textView.setText("[Source]\n");
        textView.setTextColor(Color.BLUE);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToURL(src);
            }
        });
        textView.setTextSize(14);
        return textView;
    }

    void GoToURL(String url){
        Uri uri = Uri.parse(url);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

}
