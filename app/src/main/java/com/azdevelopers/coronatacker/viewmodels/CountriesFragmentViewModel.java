package com.azdevelopers.coronatacker.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseCountries;
import com.azdevelopers.coronatacker.models.CountryData;
import com.azdevelopers.coronatacker.repositories.CountriesCountsRepository;

import java.util.List;

public class CountriesFragmentViewModel extends AndroidViewModel implements AsyncResponseCountries {
    private static MutableLiveData<List<CountryData>> countriesDataMutable  = new MutableLiveData<>(); ;
    private CountriesCountsRepository countriesCountsRepository;

    public CountriesFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<CountryData>> getCountriesData(){
        return countriesDataMutable;
    }

    public void init(){
//        if(countriesDataMutable.getValue()!=null)
//            countriesDataMutable.setValue(null);


            countriesCountsRepository = CountriesCountsRepository.getInstance();
            countriesCountsRepository.getCountriesData(this);

    }


    @Override
    public void processFinish(List<CountryData> countryData) {
        countriesDataMutable.setValue(countryData);
    }
}
