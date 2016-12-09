package com.vivien.recyclerviewtogallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vivien on 16/12/9.
 */

public class MyRecyclerView extends RecyclerView {

    private OnScrollListener onScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        /**
         *
         * 滚动时，判断当前第一个View是否发生变化，发生才回调
         */
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            View newView = getChildAt(0);
            if (onItemScrollChangeListener != null) {
                if (newView != null && newView != mCurrentView) {
                    mCurrentView = newView;
                    onItemScrollChangeListener.onChange(mCurrentView,
                            getChildPosition(mCurrentView));
                }
            }
        }
    };

    private View mCurrentView;
    private OnItemScrollChangeListener onItemScrollChangeListener;

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.addOnScrollListener(onScrollListener);
    }

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener listener) {
        onItemScrollChangeListener = listener;
    }

    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }
}
