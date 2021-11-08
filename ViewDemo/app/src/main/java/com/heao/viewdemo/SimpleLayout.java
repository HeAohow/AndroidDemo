package com.heao.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * csdn-guoyu-深入了解View(2)
 * https://blog.csdn.net/guolin_blog/article/details/16330267
 */
public class SimpleLayout extends ViewGroup {
    public static final String TAG = "SimpleLayout";

    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
        Log.i(TAG, "onMeasure " + "getMeasuredWidth(): " + getMeasuredWidth() + ", getWidth(): " + getWidth());
        Log.i(TAG, "onMeasure " + "getMeasuredHeight(): " + getMeasuredHeight() + ", getHeight(): " + getHeight());

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            // 该函数的参数决定子View在父View中的布局位置
            // public void layout(int l, int t, int r, int b)

            childView.layout(20, 20, childView.getMeasuredWidth(), childView.getMeasuredHeight());
            // getHeight() = b - t;
            // getWidth() = r - l;
            // getMeasuredWidth() = actual width of view
            // getMeasuredHeight() = actual height of view
//            childView.layout(20, 20, 200, 100);

        }

        Log.i(TAG, "onLayout " + "getMeasuredWidth(): " + getMeasuredWidth() + ", getWidth(): " + getWidth());
        Log.i(TAG, "onLayout " + "getMeasuredHeight(): " + getMeasuredHeight() + ", getHeight(): " + getHeight());

    }

}
