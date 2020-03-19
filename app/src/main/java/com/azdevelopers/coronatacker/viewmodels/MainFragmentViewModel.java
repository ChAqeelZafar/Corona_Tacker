package com.azdevelopers.coronatacker.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseCorona;
import com.azdevelopers.coronatacker.models.CoronaCounts;
import com.azdevelopers.coronatacker.repositories.CoronaCountsRepository;

public class MainFragmentViewModel extends ViewModel implements AsyncResponseCorona {
    private static MutableLiveData<CoronaCounts> coronaCountsMutableLiveData = new MutableLiveData<>();  ;
    private CoronaCountsRepository coronaCountsRepository ;


    public LiveData<CoronaCounts> getCoronaCounts(){
        return coronaCountsMutableLiveData;
    }

    public void init(){



            coronaCountsRepository = CoronaCountsRepository.getInstance();

            //coronaCountsMutableLiveData = coronaCountsRepository.getCoronaCounts();

           coronaCountsRepository.getCoronaCounts(this);

    }

    @Override
    public void processFinish(CoronaCounts coronaCounts) {

        coronaCountsMutableLiveData.setValue(coronaCounts);
    }

//    public void setCoronaCountsMutableLiveData(CoronaCounts coronaCounts){
//        coronaCountsMutableLiveData.setValue(coronaCounts);
//    }



}
