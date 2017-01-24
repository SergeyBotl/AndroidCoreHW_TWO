package com.example.sergey.lesson12_newspaper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TitleFragment.OnClickListenerTF, LoginFragment.OnClickListener {
    private NewspaperDAO dao = NewspaperDAO.getNewspaperDAO();
    private List<Newspaper> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Newspaper");

        newsList = dao.getArticle();
        LoginFragment logF = new LoginFragment();
        startFragment(logF);

    }

    private void startFragment(Fragment fragment) {
        Log.d("TAG", "startFragment");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickTF(String article) {
        ArticleFragment af = ArticleFragment.newInstance(article);
        startFragment(af);
    }

    @Override
    public void onClickOnTitle() {
        startFragment(TitleFragment.newInstance(newsList));
    }

    @Override
    public void onClickOnForgot() {
        startFragment(new ForgotFragment());
    }
}

