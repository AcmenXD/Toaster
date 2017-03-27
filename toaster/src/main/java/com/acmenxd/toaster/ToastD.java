package com.acmenxd.toaster;

import android.widget.Toast;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2016/12/22 13:27
 * @detail 设置Toast显示时长类 -> 作用ToastDuration
 */
public class ToastD {
    /**
     * 短时间显示 -> 对应Toast.LENGTH_SHORT
     */
    public static final ToastD SHORT = ToastD.d(Toast.LENGTH_SHORT);
    /**
     * 长时间显示 -> 对应Toast.LENGTH_LONG
     */
    public static final ToastD LONG = ToastD.d(Toast.LENGTH_LONG);

    /**
     * 默认显示时长 -> BuildConfig里配置
     */
    public static final ToastD Default() {
        return Toaster.TOAST_DURATION;
    }

    /**
     * 创建一个Toast显示时长
     *
     * @param pDuration 时长(毫秒)
     * @return
     */
    public static ToastD d(int pDuration) {
        return new ToastD(pDuration);
    }

    // 初始显示时长
    private int mDuration = Toast.LENGTH_SHORT;

    private ToastD(int pDuration) {
        mDuration = pDuration;
    }

    /**
     * 获取时长
     */
    public int gDuration() {
        return mDuration;
    }
}
