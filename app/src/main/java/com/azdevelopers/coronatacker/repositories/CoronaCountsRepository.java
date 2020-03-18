package com.azdevelopers.coronatacker.repositories;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.azdevelopers.coronatacker.interfaces.AsyncResponseCorona;
import com.azdevelopers.coronatacker.models.CoronaCounts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CoronaCountsRepository {
    private static CoronaCountsRepository instance;
    private CoronaCounts coronaCounts = new CoronaCounts();
    MutableLiveData<CoronaCounts> data;
    //private MainFragmentViewModel mainFragmentViewModel = new MainFragmentViewModel();
    private CoronaCountsRepository(){

    }

    public static CoronaCountsRepository getInstance(){
        if(instance==null){
            instance = new CoronaCountsRepository();
        }
        return instance;
    }

    public void getCoronaCounts(AsyncResponseCorona asyncResponseCorona){
        setCoronaCounts(asyncResponseCorona);
//        MutableLiveData<CoronaCounts> data = new MutableLiveData<>();
//        data.setValue(coronaCounts);


    }

    public void setCoronaCounts(final AsyncResponseCorona asyncResponseCorona){
        new AsyncTask<Void, Void, Void>(){


            public AsyncResponseCorona delegate = asyncResponseCorona;


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

                    //System.out.println(coronaCounts.getDeathCount());

//                    if(coronaCounts!=null)
//                        mainFragmentViewModel.setCoronaCountsMutableLiveData(coronaCounts);



                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                delegate.processFinish(coronaCounts);
            }
        }.execute();


    }
}
