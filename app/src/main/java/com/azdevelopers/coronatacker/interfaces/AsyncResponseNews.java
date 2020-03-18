package com.azdevelopers.coronatacker.interfaces;

import com.azdevelopers.coronatacker.models.NewsUpdateData;

import java.util.List;

public interface AsyncResponseNews {
    void processFinish(List<NewsUpdateData> newsUpdateData);
}
