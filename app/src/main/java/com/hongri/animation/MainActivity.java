package com.hongri.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

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
                performAnimate();
                break;
            default:
                break;
        }
    }

    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(changeWidthBtn);
        ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start();
    }

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
