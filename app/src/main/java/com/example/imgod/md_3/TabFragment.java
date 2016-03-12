package com.example.imgod.md_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imgod on 2016/3/11.
 */
public class TabFragment extends Fragment {

    public static final String TYPE = "type";

    private View parentView;
    private RecyclerView rv_main;
    private List<String> str_list;
    private MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_tab,container,false);
        initView();
        initData();
        return parentView;
    }


    public static TabFragment newInstance(String content){
        Bundle bundle = new Bundle();
        bundle.putString(TYPE,content);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    private void initView() {
        rv_main = (RecyclerView) parentView.findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_main.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        String content = getArguments().getString(TYPE,"xixihaha");
        str_list = new ArrayList<>();
        myAdapter = new MyAdapter(getActivity(),str_list);
        rv_main.setAdapter(myAdapter);
        for(int i=0;i<20;i++) {
            str_list.add(content+"\t"+i);
        }
        myAdapter.notifyDataSetChanged();
    }

}
