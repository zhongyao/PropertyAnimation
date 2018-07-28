package com.hongri.animation;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.hongri.animation.utils.Logger;

/**
 * @author 红日
 *         属性动画可以对任何对象做动画，甚至还可以没有对象
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {
    private ImageView iv;
    private Button animBtn;
    private Button changeWidthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);
        animBtn = findViewById(R.id.animBtn);
        changeWidthBtn = findViewById(R.id.changeWidthBtn);
        animBtn.setOnClickListener(this);
        changeWidthBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animBtn:
                //animTranslationY();
                //TestURL.addShareKeyToUrl("pages/play/play?source=youkuapp&videoId=5565","$#$343");
                //animRotationY();
                break;
            case R.id.changeWidthBtn:
                //performAnimate();
                performAnimate(changeWidthBtn, 800, 200);
                break;
            default:
                break;
        }
    }

    private void performAnimate(final View target, final int start, final int end) {

        final ValueAnimator animator = ValueAnimator.ofInt(1, 100);

        animator.addUpdateListener(new AnimatorUpdateListener() {
            private IntEvaluator evaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获得当前动画值
                int currentValue = (int)animator.getAnimatedValue();
                Logger.d("current:" + currentValue);
                //获得当前动画进度比例
                float fraction = animator.getAnimatedFraction();
                Logger.d("fraction:" + fraction);

                target.getLayoutParams().width = evaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });

        animator.setDuration(5000).start();
    }

    /**
     * 方法一
     */
    private void performAnimate() {
        //ViewWrapper wrapper = new ViewWrapper(changeWidthBtn);
        //ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start();
    }

    /**
     * 方法二
     */

    private void animTranslationY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "translationY", 0, -iv.getHeight());
        animator.setDuration(2000);
        animator.start();
    }

    private void animRotationY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "rotationX", 0, 360);
        animator.setDuration(2000);
        animator.start();
    }

}
