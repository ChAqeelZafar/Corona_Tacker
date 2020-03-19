package com.azdevelopers.coronatacker.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseCountries;
import com.azdevelopers.coronatacker.models.CountryData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountriesCountsRepository {
    public static CountriesCountsRepository instance;
    private ArrayList<CountryData> countriesData ;
    private CountryData totality = new CountryData();

    private CountriesCountsRepository(){

    }

    public static CountriesCountsRepository getInstance(){
        if(instance==null)
            instance = new CountriesCountsRepository();
        return instance;
    }

    public void getCountriesData(AsyncResponseCountries asyncResponseCountries){
        setCountiresData(asyncResponseCountries);
//        MutableLiveData<List<CountryData>> data = new MutableLiveData<>();
//        data.setValue(countriesData);

    }

    public void setCountiresData(final AsyncResponseCountries asyncResponseCountries){
        final AsyncResponseCountries delegate = asyncResponseCountries;
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                delegate.processFinish(countriesData);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                Document doc = null;

                try {
                    countriesData = new ArrayList<>();
                    doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();



                    Element table = doc.getElementById("main_table_countries");
                    if(table==null)
                        table = doc.getElementById("main_table_countries_today");
                    Elements tbody = table.select("tbody");
                    Elements rows = tbody.get(0).select("tr");

                    for (int i = 0; i < rows.size(); i++) {
                        Element row = rows.get(i);
                        Elements cols = row.select("td");

                        CountryData country = new CountryData();
                        country.setCountryName(cols.get(0).text());
                        country.setTotalCases(cols.get(1).text());
                        country.setNewCases(cols.get(2).text());
                        country.setTotalDeaths(cols.get(3).text());
                        country.setNewDeaths(cols.get(4).text());
                        country.setTotalRecoverd(cols.get(5).text());
                        country.setActiveCases(cols.get(6).text());
                        country.setSeriousCases(cols.get(7).text());
                        country.setTotCases(cols.get(8).text());

                        countriesData.add(country);
                    }


                    Elements rowTotality = tbody.get(1).select("tr");

                    totality.setCountryName(rowTotality.select("td").select("strong").text());
                    totality.setTotalCases(rowTotality.select("td").text());
                    totality.setNewCases(rowTotality.select("td").text());
                    totality.setTotalDeaths(rowTotality.select("td").text());
                    totality.setNewDeaths(rowTotality.select("td").text());
                    totality.setTotalRecoverd(rowTotality.select("td").text());
                    totality.setActiveCases(rowTotality.select("td").text());
                    totality.setSeriousCases(rowTotality.select("td").text());
                    totality.setTotCases(rowTotality.select("td").text());


                    countriesData.add(totality);//last country is the total of the all countries

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();


    }
}
