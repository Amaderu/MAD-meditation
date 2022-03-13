package com.example.madmeditation.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.Quotes;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Quotes>> mQuotes;
    private MutableLiveData<List<Feelings>> mFeelings;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("С возвращением,");
        mQuotes = new MutableLiveData<>();
        mQuotes.setValue(new ArrayList<>());
    }

    public MutableLiveData<List<Feelings>> getFeelings() {
        return mFeelings;
    }

    public void setFeelings(MutableLiveData<List<Feelings>> mFeelings) {
        this.mFeelings = mFeelings;
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Quotes>> getQuotes() {
        return mQuotes;
    }

    public void setQuotes(MutableLiveData<List<Quotes>> mQuotes) {
        this.mQuotes = mQuotes;
    }

    public void setText(MutableLiveData<String> mText) {
        this.mText = mText;
    }
}