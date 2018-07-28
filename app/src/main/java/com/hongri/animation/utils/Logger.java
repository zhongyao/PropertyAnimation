package com.hongri.animation.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * @author zhongyao
 * @date 2017/12/5
 */

public class Logger {

    private static final String YAO = "yao";

    public static void d(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(YAO, msg);
        }
    }
}
