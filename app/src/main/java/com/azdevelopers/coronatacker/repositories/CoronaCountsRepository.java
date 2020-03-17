package com.azdevelopers.coronatacker.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.models.CoronaCounts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CoronaCountsRepository {
    private static CoronaCountsRepository instance;
    private CoronaCounts coronaCounts = new CoronaCounts();
    MutableLiveData<CoronaCounts> data;
    private CoronaCountsRepository(){

    }

    public static CoronaCountsRepository getInstance(){
        if(instance==null){
            instance = new CoronaCountsRepository();
        }
        return instance;
    }

    public MutableLiveData<CoronaCounts> getCoronaCounts(){
        setCoronaCounts();
        MutableLiveData<CoronaCounts> data = new MutableLiveData<>();
        data.setValue(coronaCounts);
        return data;

    }

    public void setCoronaCounts(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();

                    //For current Time of Updated Data
                    Elements currentTimeE = doc.getElementsByClass("content-inner");
                    Elements divArrays = currentTimeE.get(0).select("div");
                    coronaCounts.setCurrentTime(divArrays.get(2).text());


                    Elements mainCasesE = doc.getElementsByClass("maincounter-number");
                    Elements activeClosedCounts = doc.getElementsByClass("number-table-main");
                    Elements mildSeriousCount = doc.getElementsByClass("number-table");


                    coronaCounts.setTotalCasesCount(mainCasesE.get(0).text());
                    coronaCounts.setDeathCount(mainCasesE.get(1).text());
                    coronaCounts.setRecoverCounts(mainCasesE.get(2).text());

                    coronaCounts.setActiveCasesCount(activeClosedCounts.get(0).text());
                    coronaCounts.setClosedCasesCount(activeClosedCounts.get(1).text());

                    coronaCounts.setMildCasesCount(mildSeriousCount.get(0).text());
                    coronaCounts.setSeriousCasesCount(mildSeriousCount.get(1).text());

                    System.out.println(coronaCounts.getDeathCount());




                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    }
}
