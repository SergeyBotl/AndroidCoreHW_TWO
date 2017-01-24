package com.example.sergey.lesson12_newspaper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

    private TextView textViewArticle;

    public static ArticleFragment newInstance(String article) {
        ArticleFragment af = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString("article", article);
        af.setArguments(args);
        return af;
    }

    public ArticleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container,false);
        textViewArticle = (TextView) view.findViewById(R.id.textArticle);
        textViewArticle.setText(getArguments().getString("article"));
        return view;
    }

}
