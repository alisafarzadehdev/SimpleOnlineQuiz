package com.alisafarzadeh.rejimghazaei;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alisafarzadeh.rejimghazaei.Adapters.QuizAdapater;
import com.alisafarzadeh.rejimghazaei.Adapters.QuizItem;
import com.alisafarzadeh.rejimghazaei.Retrofit.MyApi;
import com.alisafarzadeh.rejimghazaei.Retrofit.MyRetrofit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizAndAwnserActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    QuizAdapater quizAdapater;
    RecyclerView rec;
    List<QuizItem> quizItems=new ArrayList<>();
    FloatingActionButton flatbutton;
    SwipeRefreshLayout swipeQuiz;

    Button btn_send;
    EditText editText_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_and_awnser);

        swipeQuiz = findViewById(R.id.swipequiz);
        swipeQuiz.setOnRefreshListener(this);

        flatbutton = findViewById(R.id.flataction);

        quizAdapater = new QuizAdapater(quizItems,QuizAndAwnserActivity.this);
        rec = findViewById(R.id.recyclermessage);
        rec.setLayoutManager(new LinearLayoutManager(QuizAndAwnserActivity.this));
        rec.setAdapter(quizAdapater);

        getSoalat("alisafarzadeh");

        flatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlertDialog();

            }
        });

    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(QuizAndAwnserActivity.this);
        View customLayout = getLayoutInflater().inflate(R.layout.alert_layout, null);
        alertDialog.setView(customLayout);
        Button btn = customLayout.findViewById(R.id.SendMessage);
        EditText edit_msg = customLayout.findViewById(R.id.messageSoal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("alisafarzadeh",edit_msg.getText().toString());
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }


    MyApi myApi;
    public void sendMessage(String user,String msg)
    {
        myApi = MyRetrofit.getRetrofit().create(MyApi.class);
        myApi.IsSend(user,msg).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("DDDDD",response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("DDDDD",t.getMessage());

            }
        });


        quizItems.add(new QuizItem(msg,"منتظر جواب باشید..."));
        quizAdapater.notifyDataSetChanged();

                /*/
        quizItems.clear();
        Log.d("ddd",quizItems.size()+"");
        quizAdapater.notifyDataSetChanged();
        getSoalat(user);
        */
    }


    public void getSoalat(String user)
    {
        myApi = MyRetrofit.getRetrofit().create(MyApi.class);
        myApi.getMessage(user).enqueue(new Callback<List<QuizItem>>() {
            @Override
            public void onResponse(Call<List<QuizItem>> call, Response<List<QuizItem>> response) {

                for (int i = 0; i < response.body().size(); i++) {
                    QuizItem quiz = response.body().get(i);
                    quizItems.add(new QuizItem(quiz.get_soal(),quiz.get_answer()));
                }
                quizAdapater.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<QuizItem>> call, Throwable t) {
                Log.d("DDDDD",t.getMessage());

            }
        });
    }

    @Override
    public void onRefresh() {
        quizItems.clear();
        quizAdapater.notifyDataSetChanged();
        getSoalat("alisafarzadeh");
        swipeQuiz.setRefreshing(false);
    }
}