package com.a_23_59.mvvmwithretrofit;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;

public class ArticleRepository {

    private ArticleDao articleDao;

    private ApiService apiService;


    public ArticleRepository(ArticleDao articleDao, ApiService apiService) {
        this.articleDao = articleDao;
        this.apiService = apiService;
    }


    public Completable refreshArticle(){

    return apiService.getArticles().subscribeOn(Schedulers.io()).doOnSuccess(response -> {

        articleDao.addArticlesToDataBase(response.getData());

    }).ignoreElement();

    }

    public LiveData<List<DataItem>> getArticlesFromDataBase(){

        return articleDao.getArticles();

    }
}
