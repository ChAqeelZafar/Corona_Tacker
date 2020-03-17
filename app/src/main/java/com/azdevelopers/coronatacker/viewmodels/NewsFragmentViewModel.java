package com.azdevelopers.coronatacker.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopers.coronatacker.models.NewsUpdateData;
import com.azdevelopers.coronatacker.repositories.NewsUpdateRepository;

import java.util.List;

public class NewsFragmentViewModel extends ViewModel {
    private static MutableLiveData<List<NewsUpdateData>> newsUpdates;

    private NewsUpdateRepository newsUpdateRepository;
    public LiveData<List<NewsUpdateData>> getNewsUpdates(){
        return newsUpdates;
    }

    public void init(){
        if(newsUpdates!=null){
            return;
        }else{
            newsUpdateRepository = NewsUpdateRepository.getInstance();
            newsUpdates = newsUpdateRepository.getNewsUpdates();
        }
    }
}
