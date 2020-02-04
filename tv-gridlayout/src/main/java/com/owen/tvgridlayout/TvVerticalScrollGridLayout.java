package com.owen.tvgridlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.core.widget.NestedScrollView;
import androidx.gridlayout.widget.GridLayout;

/**
 * @author ZhouSuQiang
 * @email zhousuqiang@126.com
 * @date 2018/12/25
 */
public class TvVerticalScrollGridLayout extends NestedScrollView {
    private TvGridLayout mTvGridLayout;
    private ScrollGridHelper mScrollGridHelper;

    public TvVerticalScrollGridLayout(Context context) {
        this(context, null);
    }

    public TvVerticalScrollGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TvVerticalScrollGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setClipChildren(false);
        setClipToPadding(false);

        mTvGridLayout = new TvGridLayout(context, attrs, true, GridLayout.HORIZONTAL);
        mTvGridLayout.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        mScrollGridHelper = new ScrollGridHelper(this, mTvGridLayout, attrs, true);
        super.addView(mTvGridLayout, 0, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        super.setPadding(0, 0, 0, 0);
    }

    @Override
    public boolean isInEditMode() {
        return true;
    }

    public TvGridLayout getTvGridLayout() {
        return mTvGridLayout;
    }


    public void setSelectedScrollCentered(boolean selectedCentered) {
        mScrollGridHelper.setSelectedScrollCentered(selectedCentered);
    }

    public boolean isSelectedScrollCentered() {
        return mScrollGridHelper.isSelectedScrollCentered();
    }

    public void setSelectedScrollOffsetStart(float selectedItemOffsetStart) {
        mScrollGridHelper.setSelectedScrollOffsetStart(selectedItemOffsetStart);
    }

    public float getSelectedScrollOffsetStart() {
        return mScrollGridHelper.getSelectedScrollOffsetStart();
    }

    public void setSelectedScrollOffsetEnd(float selectedItemOffsetEnd) {
        mScrollGridHelper.setSelectedScrollOffsetEnd(selectedItemOffsetEnd);
    }

    public float getSelectedScrollOffsetEnd() {
        return mScrollGridHelper.getSelectedScrollOffsetEnd();
    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return mScrollGridHelper.computeScrollDeltaToGetChildRectOnScreen(rect);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mScrollGridHelper.onScrollChanged(l, t, oldl, oldt);
    }

    public boolean isScrolling() {
        return mScrollGridHelper.isScrolling();
    }

    public void addOnScrollChangeListener(ScrollHelper.OnScrollChangeListener onScrollChangeListener) {
        mScrollGridHelper.addOnScrollChangeListener(onScrollChangeListener);
    }

    public void removeOnScrollChageListener(ScrollHelper.OnScrollChangeListener onScrollChangeListener) {
        mScrollGridHelper.removeOnScrollChageListener(onScrollChangeListener);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        mScrollGridHelper.setPaddingRelative(start, top, end, bottom);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        mScrollGridHelper.setPadding(left, top, right, bottom);
    }

    @Override
    public void addView(View child) {
        mScrollGridHelper.addView(child, -1);
    }

    @Override
    public void addView(View child, int index) {
        mScrollGridHelper.addView(child, index);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        mScrollGridHelper.addView(child, -1, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        mScrollGridHelper.addView(child, index, params);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) || mScrollGridHelper.checkLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return mScrollGridHelper.generateDefaultLayoutParams();
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return mScrollGridHelper.generateLayoutParams(lp);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return mScrollGridHelper.generateLayoutParams(attrs);
    }
}
