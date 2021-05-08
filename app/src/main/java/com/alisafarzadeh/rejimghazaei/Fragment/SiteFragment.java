package com.alisafarzadeh.rejimghazaei.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alisafarzadeh.rejimghazaei.Adapters.Article;
import com.alisafarzadeh.rejimghazaei.Adapters.MyRecycler;
import com.alisafarzadeh.rejimghazaei.R;
import com.alisafarzadeh.rejimghazaei.Retrofit.MyApi;
import com.alisafarzadeh.rejimghazaei.Retrofit.MyRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SiteFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    public SiteFragment() {
        // Required empty public constructor
    }

    SwipeRefreshLayout swipeLayout;

    RecyclerView recyclerView;
    MyRecycler myRecycler;
    MyApi myApi;
    private List<Article> articles=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_site, container, false);

        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        swipeLayout.setOnRefreshListener(this);


        myRecycler = new MyRecycler(articles,getActivity());
        recyclerView = view.findViewById(R.id.recid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myRecycler);
        myRecycler.notifyDataSetChanged();
        getdataSite();


        return view;
    }


    public void getdataSite()
    {
        myApi = MyRetrofit.getRetrofit().create(MyApi.class);
        myApi.getArticle().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {

                for (int i = 0; i < response.body().size() ; i++) {
                    articles.add(response.body().get(i));
                }
                myRecycler.notifyDataSetChanged();


                Log.d("DDDDD",response.body()+"");
                Log.d("DDDDD",response.body().get(1).getContent()+"");
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.d("DDDDD",t.getMessage()+"");
            }
        });
    }

    @Override
    public void onRefresh() {
        articles.clear();
        myRecycler.notifyDataSetChanged();
        getdataSite();
        swipeLayout.setRefreshing(false);

    }
}