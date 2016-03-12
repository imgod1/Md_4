package com.example.imgod.md_3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private RecyclerView rv_main;
    private FloatingActionButton fab;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(this));

        titles = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(this, titles);
        rv_main.setAdapter(adapter);
        for (int i = 0; i < 40; i++) {
            titles.add("Tab1\t" + i);
        }
        adapter.notifyDataSetChanged();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Hello");
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rv_main, "Hello SnackBar", Snackbar.LENGTH_SHORT).show();
            }
        });

        //选色板,从给出的bitmap和默认颜色值中选出最适合的颜色满足ActionBar被收折后,背景颜色能保持和Banner大图的色调一致,而Title文字的颜色保证和Banner大图的色调形成强对比.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image09);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(final Palette palette) {
                int defaultColor = ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark);
                int defaultTitleColor = ContextCompat.getColor(MainActivity.this, R.color.dark_transparent);
                int bgColor = palette.getDarkVibrantColor(defaultColor);
                int titleColor = palette.getLightVibrantColor(defaultTitleColor);
                collapsingToolbar.setContentScrimColor(bgColor);
                collapsingToolbar.setCollapsedTitleTextColor(titleColor);
                collapsingToolbar.setExpandedTitleColor(titleColor);
            }
        });

    }
}
