package com.azdevelopers.coronatacker.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.azdevelopers.coronatacker.R;
import com.azdevelopers.coronatacker.models.CountryData;
import com.azdevelopers.coronatacker.viewmodels.CountriesFragmentViewModel;



import java.util.List;


public class CountriesFragment extends Fragment {
    private CountriesFragmentViewModel countriesFragmentViewModel;
    private TextView textView;
    private TableLayout tv;



    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_countries, container, false);

        countriesFragmentViewModel = ViewModelProviders.of(this).get(CountriesFragmentViewModel.class);
        countriesFragmentViewModel.init();


        tv = view.findViewById(R.id.countires_table_main);



        countriesFragmentViewModel.getCountriesData().observe(getActivity(), new Observer<List<CountryData>>() {
            @Override
            public void onChanged(List<CountryData> countryData) {
                    setTable(countryData);
            }
        });
















        return view;
    }

    public void setTable(List<CountryData> countryData){

        tv.removeAllViews();
        int flag = 1;
        for(int i=0; i<countryData.size(); i++){
            TableRow tr=new TableRow(getContext());

            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            // this will be executed once
            if(flag==1){

                //setTableHeader(tv);
                TextView b3=new TextView(getContext());
                b3.setText("column heading 1");
                b3.setTextColor(Color.BLUE);
                b3.setTextSize(15);
                tr.addView(b3);

                TextView b4=new TextView(getContext());
                b4.setPadding(10, 0, 0, 0);
                b4.setTextSize(15);
                b4.setText("column heading 2");
                b4.setTextColor(Color.BLUE);
                tr.addView(b4);

                TextView b5=new TextView(getContext());
                b5.setPadding(10, 0, 0, 0);
                b5.setText("column heading 3");
                b5.setTextColor(Color.BLUE);
                b5.setTextSize(15);
                tr.addView(b5);


                TextView b6=new TextView(getContext());
                b6.setText("column heading 1");
                b6.setTextColor(Color.BLUE);
                b6.setTextSize(15);
                tr.addView(b6);

                TextView b7=new TextView(getContext());
                b7.setPadding(10, 0, 0, 0);
                b7.setTextSize(15);
                b7.setText("column heading 2");
                b7.setTextColor(Color.BLUE);
                tr.addView(b7);

                TextView b8=new TextView(getContext());
                b8.setPadding(10, 0, 0, 0);
                b8.setText("column heading 3");
                b8.setTextColor(Color.BLUE);
                b8.setTextSize(15);
                tr.addView(b8);


                tv.addView(tr);

                final View vline = new View(getContext());
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                tv.addView(vline); // add line below heading
                flag=0;
            } else {
                CountryData cd = countryData.get(i);

                TextView b=new TextView(getContext());
                String str=cd.getCountryName();
                b.setText(str);
                b.setTextColor(Color.RED);
                b.setTextSize(15);
                tr.addView(b);

                TextView b1=new TextView(getContext());
                b1.setPadding(10, 0, 0, 0);
                b1.setTextSize(15);
                String str1=cd.getCountryName();
                b1.setText(str1);
                b1.setTextColor(Color.WHITE);
                tr.addView(b1);

                TextView b2=new TextView(getContext());
                b2.setPadding(10, 0, 0, 0);
                String str2=cd.getCountryName();
                b2.setText(str2);
                b2.setTextColor(Color.RED);
                b2.setTextSize(15);
                tr.addView(b2);


                TextView b12=new TextView(getContext());
                String str12=cd.getCountryName();
                b12.setText(str12);
                b12.setTextColor(Color.RED);
                b12.setTextSize(15);
                tr.addView(b12);

                TextView b112=new TextView(getContext());
                b112.setPadding(10, 0, 0, 0);
                b112.setTextSize(15);
                String str112=cd.getCountryName();
                b112.setText(str112);
                b112.setTextColor(Color.WHITE);
                tr.addView(b112);

                TextView b212=new TextView(getContext());
                b212.setPadding(10, 0, 0, 0);
                String str212=cd.getCountryName();
                b212.setText(str212);
                b212.setTextColor(Color.RED);
                b212.setTextSize(15);
                tr.addView(b212);

                tv.addView(tr);
                final View vline1 = new View(getContext());
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
                vline1.setBackgroundColor(Color.WHITE);
                tv.addView(vline1);  // add line below each row
            }
        }
    }

    public void setTableHeader(TableLayout tbl) {
        TableRow tr = new TableRow(getContext());

        TextView tcView = new TextView(getContext());
        tcView.setText("Class");
        tcView.setTextColor(Color.BLACK);
        tcView.setAllCaps(true);
        tcView.setTypeface(null, Typeface.BOLD);
        tcView.setGravity(Gravity.CENTER_HORIZONTAL);
        tr.addView(tcView);

        TextView tfView = new TextView(getContext());
        tfView.setText("Fee");
        tfView.setTextColor(Color.BLACK);
        tfView.setAllCaps(true);
        tfView.setTypeface(null, Typeface.BOLD);
        tfView.setGravity(Gravity.CENTER_HORIZONTAL);
        tr.addView(tfView);

        TextView tqView = new TextView(getContext());
        tqView.setText("Available");
        tqView.setTextColor(Color.BLACK);
        tqView.setAllCaps(true);
        tqView.setTypeface(null, Typeface.BOLD);
        tqView.setGravity(Gravity.CENTER_HORIZONTAL);
        tr.addView(tqView);

        // Adding row to Table
        tbl.addView(tr);

        // Table Header Has Been Set

    }


}
