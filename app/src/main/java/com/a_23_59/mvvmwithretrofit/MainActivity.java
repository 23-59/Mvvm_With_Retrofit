package com.a_23_59.mvvmwithretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static ArticlesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       RecyclerView recyclerView=findViewById(R.id.rv_articles);

        MainViewModel viewModel=new ViewModelProvider(this,
                new ViewModelFactory(new ArticleRepository(ArticlesDataBase.getInstance(getApplicationContext()).getDao()
                ,ApiServiceProvider.getApiService()))).get(MainViewModel.class);

        viewModel.getErrorMessage().observe(this, errorMessage -> {

            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();

        });

        viewModel.getArticles().observe(this,articles -> {

            Log.i(TAG, "articles has been received in the MainActivity ");

            adapter=new ArticlesAdapter(articles);

            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

            recyclerView.setAdapter(adapter);

        });



    }
}