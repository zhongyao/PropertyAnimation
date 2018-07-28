package com.hongri.animation;

import android.view.View;

/**
 * @author zhongyao
 * @date 2018/7/28
 */

public class ViewWrapper {

    public View mTarget;

    public ViewWrapper(View mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
