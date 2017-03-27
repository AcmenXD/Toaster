package com.acmenxd.toaster.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.acmenxd.toaster.ToastD;
import com.acmenxd.toaster.ToastNW;
import com.acmenxd.toaster.Toaster;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2016/11/22 14:36
 * @detail something
 */
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Toaster使用演示");
        setContentView(R.layout.activity_main);
    }

    /**
     * String资源Toast(debug模式)
     */
    public void btnClick1(View view) {
        Toaster.debugShow("DebugToastShow");
    }

    /**
     * Object资源Toast
     */
    public void btnClick2(View view) {
        Toaster.show("Toast显示第1部分", "\n", "Toast显示第2部分", 5);
    }

    /**
     * View资源Toast
     */
    public void btnClick3(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        Toaster.show(inflater.inflate(R.layout.activity_toast_test, null));
    }

    /**
     * 无等待Toast
     */
    public void btnClick7(View view) {
        Toaster.show(ToastNW.No_NEED_WAIT, "Toast显示第1部分", "\n", "Toast显示第2部分");
    }

    /**
     * 自定义显示时长(毫秒)
     */
    public void btnClick4(View view) {
        Toaster.show(ToastD.d(4000), "Toast显示第1部分", "\n", "Toast显示第2部分");
    }

    /**
     * 无等待 + 自定义显示时长(毫秒)
     */
    public void btnClick8(View view) {
        Toaster.show(ToastNW.No_NEED_WAIT, ToastD.d(4000), "Toast显示第1部分", "\n", "Toast显示第2部分");
    }

    /**
     * 居中显示
     */
    public void btnClick5(View view) {
        Toaster.show(Gravity.CENTER, new String[]{"Toast显示第1部分", "\n", "Toast显示第2部分"});
    }

    /**
     * 无等待 + 自定义显示时长(毫秒) + 顶部显示
     */
    public void btnClick9(View view) {
        Toaster.show(ToastNW.No_NEED_WAIT, ToastD.d(4000), Gravity.TOP, new String[]{"Toast显示第1部分", "\n", "Toast显示第2部分"});
    }

}
