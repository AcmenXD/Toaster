package com.acmenxd.toaster;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.acmenxd.toaster.utils.ToastUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2016/11/22 14:36
 * @detail Toast总类
 */
public final class Toaster {
    public static boolean DEBUG = true; // Toast调试开关
    public static ToastD TOAST_DURATION = ToastD.SHORT; // Toast默认显示时长
    public static ToastNW NEED_WAIT = ToastNW.NEED_WAIT; // Toast显示方式 : Toast需要等待,并逐个显示 | Toast无需等待,直接显示
    private static Context sContext; // 上下文对象

    /**
     * 设置Context对象
     * * 必须设置,否则无法使用
     */
    public static void setContext(Context pContext) {
        sContext = pContext;
        Toast toast = new Toast(pContext);
        gravity = toast.getGravity();
        offsetX = toast.getXOffset();
        offsetY = toast.getYOffset();
        marginX = toast.getHorizontalMargin();
        marginY = toast.getVerticalMargin();
    }

    /**
     * 设置debug开关,可根据debug-release配置
     * 默认为true
     */
    public static void setDebugOpen(boolean isOpen) {
        DEBUG = isOpen;
    }

    /**
     * 设置默认显示时长
     * 默认为ToastD.SHORT = Toast.LENGTH_SHORT
     */
    public static void setDefaultDuration(ToastD pToastDuration) {
        TOAST_DURATION = pToastDuration;
    }

    /**
     * 设置Toaster显示方式 :  |
     * 默认为ToastNW.NEED_WAIT(Toast需要等待,并逐个显示) 可设置为:ToastNW.No_NEED_WAIT(Toast无需等待,直接显示)
     */
    public static void setNeedWait(ToastNW pNeedWait) {
        NEED_WAIT = pNeedWait;
    }

    // Toast 表
    private static Map<Long, Toast2> tMap = new ConcurrentHashMap<>();
    private static long mTId = 10000; //每个Toast的唯一Id
    // 默认的一些参数
    private static int gravity = Gravity.BOTTOM;
    private static int offsetX = 0;
    private static int offsetY = 0;
    private static float marginX = 0;
    private static float marginY = 0;

    /**
     * 取消一个Toast
     *
     * @param tId
     */
    public static void cancel(long tId) {
        Toast2 t = tMap.remove(tId);
        if (t != null) {
            t.cancel();
        }
    }

    /**
     * 取消所有Toast
     */
    public static void cancelAll() {
        Iterator<Long> it = tMap.keySet().iterator();
        while (it.hasNext()) {
            cancel(it.next());
        }
    }

    /**
     * 检索集合,整理数据
     */
    private static void checkCancel() {
        for (Map.Entry<Long, Toast2> entry : tMap.entrySet()) {
            if (entry.getValue().isCancel()) {
                cancel(entry.getKey());
            }
        }
    }

    /**
     * Debug模式 ----------------- start
     */
    public static void debugShow(int[] resIds) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void debugShow(Object... objs) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(View view) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void debugShow(ToastD duration, int[] resIds) {
        showAll(true, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void debugShow(ToastD duration, Object... objs) {
        showAll(true, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(ToastD duration, View view) {
        showAll(true, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void debugShow(ToastNW needWait, int[] resIds) {
        showAll(true, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void debugShow(ToastNW needWait, Object... objs) {
        showAll(true, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(ToastNW needWait, View view) {
        showAll(true, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void debugShow(int gravity, int[] resIds) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    // 此函数的 objs 特殊,否则与show(Object... objs)冲突
    public static void debugShow(int gravity, Object[] objs) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(int gravity, View view) {
        showAll(true, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void debugShow(ToastNW needWait, ToastD duration, int[] resIds) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void debugShow(ToastNW needWait, ToastD duration, Object... objs) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(ToastNW needWait, ToastD duration, View view) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void debugShow(ToastNW needWait, ToastD duration, int gravity, int[] resIds) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    // 此函数的 objs 特殊,否则与show(Object... objs)冲突
    public static void debugShow(ToastNW needWait, ToastD duration, int gravity, Object[] objs) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void debugShow(ToastNW needWait, ToastD duration, int gravity, View view) {
        showAll(true, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }
    // Debug模式 ----------------- end

    /**
     * 非调试模式 ----------------- start
     */
    public static void show(int[] resIds) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void show(Object... objs) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(View view) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void show(ToastD duration, int[] resIds) {
        showAll(false, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void show(ToastD duration, Object... objs) {
        showAll(false, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(ToastD duration, View view) {
        showAll(false, NEED_WAIT, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void show(ToastNW needWait, int[] resIds) {
        showAll(false, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void show(ToastNW needWait, Object... objs) {
        showAll(false, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(ToastNW needWait, View view) {
        showAll(false, needWait, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void show(int gravity, int[] resIds) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    // 此函数的 objs 特殊,否则与show(Object... objs)冲突
    public static void show(int gravity, Object[] objs) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(int gravity, View view) {
        showAll(false, NEED_WAIT, ToastD.Default(), gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void show(ToastNW needWait, ToastD duration, int[] resIds) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    public static void show(ToastNW needWait, ToastD duration, Object... objs) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(ToastNW needWait, ToastD duration, View view) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }

    public static void show(ToastNW needWait, ToastD duration, int gravity, int[] resIds) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, resIds);
    }

    // 此函数的 objs 特殊,否则与show(Object... objs)冲突
    public static void show(ToastNW needWait, ToastD duration, int gravity, Object[] objs) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, objs);
    }

    public static void show(ToastNW needWait, ToastD duration, int gravity, View view) {
        showAll(false, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }
    // 非调试模式 ----------------- end

    /**
     * 所有参数为 resIds 的统一到这里
     */
    public static void showAll(boolean isDebug, ToastNW needWait, ToastD duration, int gravity, int offsetX, int offsetY, float marginX, float marginY, int... resIds) {
        if (resIds == null) {
            return;
        }
        int len = resIds.length;
        if (len <= 0) {
            return;
        }
        Object[] msgs = new Object[len];
        for (int i = 0; i < len; i++) {
            msgs[i] = sContext.getResources().getString(resIds[i]);
        }
        showBase(isDebug, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, null, msgs);
    }

    /**
     * 所有参数为 objs 的统一到这里
     */
    public static void showAll(boolean isDebug, ToastNW needWait, ToastD duration, int gravity, int offsetX, int offsetY, float marginX, float marginY, Object... msgs) {
        showBase(isDebug, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, null, msgs);
    }

    /**
     * 所有参数为 view 的统一到这里
     */
    public static void showAll(boolean isDebug, ToastNW needWait, ToastD duration, int gravity, int offsetX, int offsetY, float marginX, float marginY, View view) {
        showBase(isDebug, needWait, duration, gravity, offsetX, offsetY, marginX, marginY, view);
    }

    /**
     * 基础,所有调用 最后都统一到这里
     *
     * @param isDebug  是否是调试~ 如果为true, 那么这个Toast在正式上线版本中不会显示
     * @param needWait Toast显示方式 : Toast需要等待,并逐个显示 | Toast无需等待,直接显示
     * @param duration 显示时间,支持自定义时间(单位毫秒)
     * @param gravity  对其方式 -> 默认 Gravity.BOTTOM
     * @param offsetX  偏移量X
     * @param offsetY  偏移量Y
     * @param marginX  Toast左上角的X间距, 取值0 - 1
     * @param marginY  Toast左上角的Y间距, 取值0 - 1
     * @param view     Toast要显示的view
     * @param msgs     Toast要显示的内容
     * @return Toast2 对象实例
     */
    private static final synchronized Toast2 showBase(boolean isDebug, ToastNW needWait, ToastD duration, int gravity, int offsetX, int offsetY, float marginX, float marginY, View view, Object... msgs) {
        /**
         * 初始化
         */
        boolean canShow = false;
        /**
         * 处理逻辑
         */
        if (needWait.isNeedWait()) {
            checkCancel();
        } else {
            cancelAll();
        }
        mTId += 1; // 自增Toast的唯一id
        Toast2 toast2 = new Toast2(sContext, mTId);
        tMap.put(toast2.getTId(), toast2);
        if (view != null) {
            // view不等于null时, 显示view ,而不显示其他内容
            toast2.setView(view);
            canShow = true;
        } else if (msgs != null & msgs.length > 0) {
            // view等于null时, 不显示view ,而显示内容
            // Toast bug -> 文本存在换行时,Toast弹出动画会有问题,迷之问题
            String msgStr = ToastUtils.appendStrs(msgs);
            if (!TextUtils.isEmpty(msgStr)) {
                toast2.setText(msgStr);
                canShow = true;
            }
        }
        if (canShow) {
            toast2.setGravity(gravity, offsetX, offsetY);
            toast2.setMargin(marginX, marginY);
            if (isDebug) {
                if (DEBUG) {
                    toast2.show(duration.gDuration());
                    return toast2;
                } else {
                    // 取消掉,整理数据
                    cancel(toast2.getTId());
                }
            } else {
                toast2.show(duration.gDuration());
                return toast2;
            }
        }
        return null;
    }
}
