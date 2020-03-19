package com.azdevelopers.coronatacker.repositories;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseNews;
import com.azdevelopers.coronatacker.models.NewsUpdateData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NewsUpdateRepository {
    public static NewsUpdateRepository instance;
    private ArrayList<NewsUpdateData> newsUpdates ;
    private NewsUpdateRepository(){

    }

    public static NewsUpdateRepository getInstance(){
        if(instance==null)
            instance = new NewsUpdateRepository();
        return instance;
    }

    public void getNewsUpdates(AsyncResponseNews asyncResponseNews){
        setNewsUpdates(asyncResponseNews);

    }

    public void setNewsUpdates(AsyncResponseNews asyncResponseNews){
        final AsyncResponseNews delegate = asyncResponseNews;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                delegate.processFinish(newsUpdates);
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            protected Void doInBackground(Void... voids) {

                Document doc = null;
                try {
                    newsUpdates = new ArrayList<>();
                    doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();


                    SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd");
                    dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String date =  dateFormatGmt.format(new Date())+"";

                    Element dateNews = doc.getElementById("newsdate" + date);
                    Elements newsList = dateNews.getElementsByClass("news_post");

                    for (int i = 0; i < newsList.size(); i++) {

                        Element singleNews = newsList.get(i);
                        String actualNews = singleNews.text();
                        actualNews = actualNews.replaceAll("\\[source", "").replaceAll("\\]","");
                        String srcUrl = singleNews.select("a").attr("href");
                        newsUpdates.add(new NewsUpdateData(actualNews, srcUrl));


                    }

                    String s = "temp";


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    }
}
