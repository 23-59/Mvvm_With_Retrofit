package com.a_23_59.mvvmwithretrofit;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {
    
   @Query("SELECT * FROM articles")
    LiveData<List<DataItem>> getArticles();

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addArticlesToDataBase(List<DataItem> dataItems);



}
