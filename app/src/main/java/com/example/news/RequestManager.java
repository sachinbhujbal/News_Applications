package com.example.news;

import android.content.Context;
import android.widget.Toast;

import com.example.news.models.NewsApiResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {

    Context context;
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getNewsHeadlines(OnFetchDataListner listner,String category,String query)
    {
        CallNewsApi callNewsApi=retrofit.create(CallNewsApi.class);
        Call<NewsApiResponce> call=callNewsApi.callHeadlines("in",category,query,
                context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<NewsApiResponce>() {
                @Override
                public void onResponse(Call<NewsApiResponce> call, Response<NewsApiResponce> response) {

                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error!!!", Toast.LENGTH_SHORT).show();
                    }
                    // that will get the newsArticals for API resonce and passes through listner.
                    listner.onFetchData(response.body().getArticles(),response.message());
                }

                @Override
                public void onFailure(Call<NewsApiResponce> call, Throwable t) {
                    listner.onError("Sorry!!Requested Failed!!!");
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public RequestManager(Context context) {
        this.context = context;

    }
    // we need to manage the api calles.
    public interface CallNewsApi{
        @GET ("top-headlines")
        Call<NewsApiResponce> callHeadlines(
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key
        );
    }
}
