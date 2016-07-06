package com.kfc.a75studycoordinatorlayout;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 2016/7/5.
 */

public class TempView extends View {
    private int lastX;
    private int lastY;
    private int screenwidth;
    private int screenheight;
    private int measuredWidth;
    private int measuredHeight;

    public TempView(Context context) {
        super(context);
        DisplayMetrics display=context.getResources().getDisplayMetrics();
        screenwidth = display.widthPixels;
        screenheight = display.heightPixels;
    }

    public TempView(Context context, AttributeSet attrs) {
        super(context, attrs);
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getRawX();
        int y= (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                int left=layoutParams.leftMargin+x-lastX;
                int top=layoutParams.topMargin+y-lastY;

                layoutParams.leftMargin=left;
                layoutParams.topMargin=top;
                setLayoutParams(layoutParams);
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        lastX=x;
        lastY=y;
        return true;
    }
}
