package com.heao.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

import java.util.List;

/**
 * csdn-guolin-深入理解View(4)
 * https://blog.csdn.net/guolin_blog/article/details/17357967
 */
public class SimpleListView extends ListView
        implements GestureDetector.OnGestureListener, View.OnTouchListener {

    public interface OnDeleteListener {
        void onDelete(int index);
    }

    private GestureDetectorCompat mGestureDetector;
    private OnDeleteListener mDeleteListener;
    private View mDeleteButton;
    private ViewGroup mItemLayout;
    private int mSelectedItem;
    private boolean isDeleteShown;

    public static class SimpleAdapter extends ArrayAdapter<String> {
        public SimpleAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.simple_list_item, null);
            } else {
                view = convertView;
            }
            TextView textView = view.findViewById(R.id.text_view);
            textView.setText(getItem(position));

            return view;
        }
    }

    public SimpleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetectorCompat(getContext(), this);
        setOnTouchListener(this);
    }

    public void setDeleteListener(OnDeleteListener listener) {
        mDeleteListener = listener;
    }

    /**
     * View.OnTouchListener
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDeleteShown) {
            mItemLayout.removeView(mDeleteButton);
            mDeleteButton = null;
            isDeleteShown = false;
            return false;
        } else {
            return mGestureDetector.onTouchEvent(event);
        }
    }

    /**
     * GestureDetector.OnGestureListener
     */
    @Override
    public boolean onDown(MotionEvent e) {
        if (!isDeleteShown) {
            // 求出当前选中的是ListView中的哪一行
            mSelectedItem = pointToPosition((int) e.getX(), (int) e.getY());
        }
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            mDeleteButton = LayoutInflater.from(getContext()).inflate(R.layout.delete_button, null);
            mDeleteButton.setOnClickListener((v) -> {
                mItemLayout.removeView(mDeleteButton);
                mDeleteButton = null;
                isDeleteShown = false;
                mDeleteListener.onDelete(mSelectedItem);
            });
            // 获取当前正在操作的item项
            mItemLayout = (ViewGroup) getChildAt(mSelectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            // 动态地按照给定布局样式添加delete按钮
            mItemLayout.addView(mDeleteButton, params);
            // 此时删除按钮可见
            isDeleteShown = true;
        }
        return false;
    }

    /**
     * 以下方法暂时未用到
     */

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
