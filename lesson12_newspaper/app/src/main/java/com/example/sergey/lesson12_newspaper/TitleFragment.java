package com.example.sergey.lesson12_newspaper;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class TitleFragment extends Fragment {

    private ArrayAdapter<String> adapter;
    private ListView listViewTitle;
    private List<String> titleList;
    private static List<Newspaper> newsList;
    private OnClickListenerTF mOnClickListenerTF;

    public interface OnClickListenerTF {
        void onClickTF(String article);
    }


    public static TitleFragment newInstance(List<Newspaper> news) {
        Log.d("TAG", "newInstance");
        TitleFragment mTitleFragment = new TitleFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("news", (ArrayList<? extends Parcelable>) news);
        mTitleFragment.setArguments(bundle);
        return mTitleFragment;
    }

    public TitleFragment() {
        this.setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        mOnClickListenerTF = (OnClickListenerTF) getActivity();

        Log.d("TAG", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onViewCreated");
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        if (getActivity() != null) {
            newsList = getArguments().getParcelableArrayList("news");
            for (Newspaper n : newsList) {
                Log.d("TAG", n.getTitleArticle().toString());
            }
        }

        listViewTitle = (ListView) view.findViewById(R.id.lvTitle);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, allTitleList());
        listViewTitle.setAdapter(adapter);

        listViewTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("TAG", "i " + i);
                mOnClickListenerTF.onClickTF(newsList.get(i).getArticle());
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    private List<String> allTitleList() {
        titleList = new ArrayList<>();
        for (Newspaper s : newsList) {
            titleList.add(s.getTitleArticle());
        }
        return titleList;
    }

}
