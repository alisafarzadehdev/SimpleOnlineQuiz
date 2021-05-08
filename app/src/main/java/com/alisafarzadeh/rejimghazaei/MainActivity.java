package com.alisafarzadeh.rejimghazaei;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.alisafarzadeh.rejimghazaei.Fragment.ProfileUserFragment;
import com.alisafarzadeh.rejimghazaei.Fragment.SiteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setfragment(new ProfileUserFragment());

        bottomnavigation = findViewById(R.id.bottomNavigationView);
        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.drstvia:

                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();


                        setfragment(new SiteFragment());


                        break;

                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "pr", Toast.LENGTH_SHORT).show();

                        setfragment(new ProfileUserFragment());


                        break;
                }

                return true;
            }
        });



        /*
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

         */

    }


    public void setfragment(Fragment fragment)
    {
        FragmentManager fff2 = getSupportFragmentManager();
        FragmentTransaction tr2 = fff2.beginTransaction();
        tr2.hide(new SiteFragment());
        tr2.replace(R.id.fragment_continer,fragment);
        tr2.commit();
    }

}