package com.azdevelopers.coronatacker.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopers.coronatacker.models.CountryData;
import com.azdevelopers.coronatacker.repositories.CountriesCountsRepository;

import java.util.List;

public class CountriesFragmentViewModel extends AndroidViewModel {
    private static MutableLiveData<List<CountryData>> countriesData ;
    private CountriesCountsRepository countriesCountsRepository;

    public CountriesFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<CountryData>> getCountriesData(){
        return countriesData;
    }

    public void init(){
        if(countriesData!=null) {
            return;
        }else {
            countriesCountsRepository = CountriesCountsRepository.getInstance();
            countriesData = countriesCountsRepository.getCountriesData();
        }
    }
}
