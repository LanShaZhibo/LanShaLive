package com.lansha.lanshalive.HomePage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by my on 2016/11/28.
 */
public class InitGridView extends GridView {
    public InitGridView(Context context) {
        super(context);
    }

    public InitGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InitGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //核心在此
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec+50);
    }
}
