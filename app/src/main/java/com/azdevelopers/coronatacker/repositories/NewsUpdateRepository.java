package com.azdevelopers.coronatacker.repositories;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.models.NewsUpdateData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsUpdateRepository {
    public static NewsUpdateRepository instance;
    private ArrayList<NewsUpdateData> newsUpdates = new ArrayList<>();
    private NewsUpdateRepository(){

    }

    public static NewsUpdateRepository getInstance(){
        if(instance==null)
            instance = new NewsUpdateRepository();
        return instance;
    }

    public MutableLiveData<List<NewsUpdateData>> getNewsUpdates(){
        setNewsUpdates();
        MutableLiveData<List<NewsUpdateData>> data = new MutableLiveData<>();
        data.setValue(newsUpdates);
        return  data;
    }

    public void setNewsUpdates(){
        new AsyncTask<Void, Void, Void>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            protected Void doInBackground(Void... voids) {

                Document doc = null;
                try {
                    doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();


                    //Element dateNews = doc.getElementById("newsdate2020-03-15");
                    Element dateNews = doc.getElementById("newsdate" + java.time.LocalDate.now());
                    Elements newsList = dateNews.getElementsByClass("news_post");

                    for (int i = 0; i < newsList.size(); i++) {

                        Element singleNews = newsList.get(i);
                        String actualNews = singleNews.text();
                        String srcUrl = singleNews.select("a").attr("href");
                        newsUpdates.add(new NewsUpdateData(actualNews, srcUrl));


                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    }
}
