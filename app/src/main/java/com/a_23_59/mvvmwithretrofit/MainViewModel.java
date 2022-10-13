package com.a_23_59.mvvmwithretrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private final ArticleRepository repository;

    private final MutableLiveData<String> errorMessage=new MutableLiveData<>();

    Disposable disposable;


   public MainViewModel(ArticleRepository repository){

       this.repository=repository;

       repository.refreshArticle()
               .subscribeOn(Schedulers.io())
               .subscribe(new CompletableObserver() {
           @Override
           public void onSubscribe(@NonNull Disposable d) {

               disposable=d;
           }

           @Override
           public void onComplete() {

           }

           @Override
           public void onError(@NonNull Throwable e) {

               errorMessage.postValue("an error has occurred");

           }
       });

    }

    public LiveData<List<DataItem>> getArticles(){

       return repository.getArticlesFromDataBase();

    }

    public MutableLiveData<String> getErrorMessage() {

        return errorMessage;
    }

    @Override
    protected void onCleared() {

        super.onCleared();

        disposable.dispose();

    }
}

