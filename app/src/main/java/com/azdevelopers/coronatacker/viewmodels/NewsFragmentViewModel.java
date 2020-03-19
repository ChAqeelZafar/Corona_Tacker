package com.azdevelopers.coronatacker.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseNews;
import com.azdevelopers.coronatacker.models.NewsUpdateData;
import com.azdevelopers.coronatacker.repositories.NewsUpdateRepository;

import java.util.List;

public class NewsFragmentViewModel extends ViewModel implements AsyncResponseNews {
    private static MutableLiveData<List<NewsUpdateData>> newsUpdatesMutable = new MutableLiveData<>();;

    private NewsUpdateRepository newsUpdateRepository;
    public LiveData<List<NewsUpdateData>> getNewsUpdates(){
        return newsUpdatesMutable;
    }

    public void init(){


            newsUpdateRepository = NewsUpdateRepository.getInstance();
            newsUpdateRepository.getNewsUpdates(this);
    }


    @Override
    public void processFinish(List<NewsUpdateData> newsUpdateData) {
        newsUpdatesMutable.setValue(newsUpdateData);
    }
}
