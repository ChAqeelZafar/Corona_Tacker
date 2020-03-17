package com.azdevelopers.coronatacker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azdevelopers.coronatacker.R;
import com.azdevelopers.coronatacker.models.NewsUpdateData;
import com.azdevelopers.coronatacker.viewmodels.NewsFragmentViewModel;

import java.util.List;


public class NewsFragment extends Fragment {

    private NewsFragmentViewModel newsFragmentViewModel;
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        newsFragmentViewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel.class);
        newsFragmentViewModel.init();


        textView = view.findViewById(R.id.fragment_news_text);
        newsFragmentViewModel.getNewsUpdates().observe(getActivity(), new Observer<List<NewsUpdateData>>() {
            @Override
            public void onChanged(List<NewsUpdateData> newsUpdateData) {
                textView.setText(newsUpdateData.size()+" :size");
            }
        });

        return view;
    }
}
