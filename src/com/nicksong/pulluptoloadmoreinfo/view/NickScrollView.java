package com.nicksong.pulluptoloadmoreinfo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class NickScrollView extends ScrollView {
	
	private ScrollListener mScrollListener;

    public void setScrollListener(ScrollListener scrollListener) {
        this.mScrollListener = scrollListener;
    }

    public NickScrollView(Context context) {
        super(context);
    }

    public NickScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NickScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                if(mScrollListener != null){
                    int contentHeight = getChildAt(0).getHeight();
                    int scrollHeight = getHeight();    

                    int scrollY = getScrollY();
                    mScrollListener.onScroll(scrollY);

                    if(scrollY + scrollHeight >= contentHeight||contentHeight <= scrollHeight){
                        mScrollListener.onScrollToBottom();
                    }else {
                        mScrollListener.notBottom();
                    }

                    if(scrollY == 0){
                        mScrollListener.onScrollToTop();
                    }

                }

                break;
        }
        boolean result = super.onTouchEvent(ev);
        requestDisallowInterceptTouchEvent(false);

        return result;
    }

    public interface ScrollListener{
        void onScrollToBottom();
        void onScrollToTop();
        void onScroll(int scrollY);
        void notBottom();
    }
}
