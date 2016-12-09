package com.vivien.recyclerviewtogallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> mDatas;
    private MyRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;

    private ImageView showIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = (MyRecyclerView) findViewById(R.id.recyclerview_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GalleryAdapter(this, mDatas);
        mAdapter.setOnItemClickLister(new GalleryAdapter.OnItemClickLister() {
            @Override
            public void onItemClick(View view, int position) {
                showIv.setImageResource(mDatas.get(position));
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {

            @Override
            public void onChange(View view, int position) {
                showIv.setImageResource(mDatas.get(position));
            }
        });

        showIv = (ImageView) findViewById(R.id.show_img);
    }

    private void initData() {
        mDatas = new ArrayList<Integer>(Arrays.asList(
                R.mipmap.a,
                R.mipmap.b,
                R.mipmap.c,
                R.mipmap.d,
                R.mipmap.e));
    }
}
