package com.azdevelopers.coronatacker.models;

public class NewsUpdateData {
    private String news;
    private String sourceUrl;

    public NewsUpdateData(String news, String sourceUrl) {
        this.news = news;
        this.sourceUrl = sourceUrl;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
