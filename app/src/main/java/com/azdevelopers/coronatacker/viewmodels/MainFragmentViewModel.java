package com.azdevelopers.coronatacker.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopers.coronatacker.models.CoronaCounts;
import com.azdevelopers.coronatacker.repositories.CoronaCountsRepository;

public class MainFragmentViewModel extends ViewModel {
    private static MutableLiveData<CoronaCounts> coronaCountsMutableLiveData ;
    private CoronaCountsRepository coronaCountsRepository ;

    public LiveData<CoronaCounts> getCoronaCounts(){
        return coronaCountsMutableLiveData;
    }

    public void init(){

            coronaCountsRepository = CoronaCountsRepository.getInstance();
            coronaCountsMutableLiveData = coronaCountsRepository.getCoronaCounts();

    }



}
