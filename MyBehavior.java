package com.kfc.a75studycoordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by dell on 2016/7/5.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {
    private int width;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }
    /**
    * 判断child的布局是否依赖dependency
    */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        //如果返回true,也就是说dependency是TempView的实例，说明它就是我们所需要的Dependency
        return dependency instanceof TempView;
    }

    //每次dependency位置发生变化，都会执行onDependentViewChanged方法
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button btn, View dependency) {

        //根据dependency的位置，设置Button的位置

        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = width - left - btn.getWidth();
        int y = top;

        setPosition(btn, x, y);
        return true;
    }

    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        v.setLayoutParams(layoutParams);
    }


}
