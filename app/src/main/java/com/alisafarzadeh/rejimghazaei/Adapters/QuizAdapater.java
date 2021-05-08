package com.alisafarzadeh.rejimghazaei.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alisafarzadeh.rejimghazaei.R;

import java.util.List;

public class QuizAdapater extends RecyclerView.Adapter<QuizAdapater.MyHolder> {

    List<QuizItem> quizItems;
    Context context;

    public QuizAdapater(List<QuizItem> quizItems, Context context) {
        this.quizItems = quizItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz,null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.soal.setText(quizItems.get(position).get_soal());
        holder.javab.setText(quizItems.get(position).get_answer());
    }

    @Override
    public int getItemCount() {
        return quizItems.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView soal,javab;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            soal = itemView.findViewById(R.id.matnQuiz);
            javab = itemView.findViewById(R.id.matnJavab);
        }
    }
}
