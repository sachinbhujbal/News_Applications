package com.example.news;

import com.example.news.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListner<NewsApiResponce> {
    void onFetchData(List<NewsHeadlines> list,String message);
    void onError(String message);
}
