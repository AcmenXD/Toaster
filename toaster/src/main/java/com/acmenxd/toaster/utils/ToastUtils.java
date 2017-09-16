package com.acmenxd.toaster.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2017/3/24 15:17
 * @detail 工具类
 */
public final class ToastUtils {

    /**
     * 字符串是否为空
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 串拼接
     *
     * @param strs 可变参数类型
     * @return 拼接后的字符串
     */
    public static String appendStrs(@NonNull Object... strs) {
        StringBuilder sb = new StringBuilder();
        if (strs != null && strs.length > 0) {
            for (Object str : strs) {
                sb.append(String.valueOf(str));
            }
        }
        return sb.toString();
    }
}
