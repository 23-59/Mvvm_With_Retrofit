package com.a_23_59.mvvmwithretrofit;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataItem.class},exportSchema = false,version = 2)
public abstract class ArticlesDataBase extends RoomDatabase {

    private static ArticlesDataBase articlesDataBase;

    public static ArticlesDataBase getInstance(Context context) {

        if (articlesDataBase==null){

            articlesDataBase= Room.databaseBuilder(context,ArticlesDataBase.class,"db_articles").build();
        }



        return articlesDataBase;
    }

    public abstract ArticleDao getDao();
}
