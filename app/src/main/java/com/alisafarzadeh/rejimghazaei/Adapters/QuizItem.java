package com.alisafarzadeh.rejimghazaei.Adapters;

import com.google.gson.annotations.SerializedName;

public class QuizItem {
    @SerializedName("messageQuiz")
    String _soal;
    @SerializedName("messageAnswer")
    String _answer;

    public QuizItem(String _soal, String _answer) {
        this._soal = _soal;
        this._answer = _answer;
    }

    public String get_soal() {
        return _soal;
    }

    public void set_soal(String _soal) {
        this._soal = _soal;
    }

    public String get_answer() {
        return _answer;
    }

    public void set_answer(String _answer) {
        this._answer = _answer;
    }
}
