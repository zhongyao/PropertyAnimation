package com.hongri.animation;

import android.net.Uri;

/**
 * @author zhongyao
 * @date 2018/7/27
 */

public class TestURL {

    private static final String URI_KEY_SHAREKEY = "sharekey";

    public static String addShareKeyToUrl(String url, String shareKey) {
        if (url == null || shareKey == null) {
            return url;
        }
        Uri uri = Uri.parse(url);
        if (uri == null) {
            return url;
        }
        String oldShareKey = uri.getQueryParameter(URI_KEY_SHAREKEY);
        if (oldShareKey != null) {
            //如果旧的shareKey存在，用新的替换
            url = url.replaceAll(oldShareKey, shareKey);
            return url;
        }
        Uri.Builder builder = uri.buildUpon();
        if (builder == null) {
            return url;
        }
        builder.appendQueryParameter(URI_KEY_SHAREKEY, shareKey);
        return builder.toString();
    }
}
