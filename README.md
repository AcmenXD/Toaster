# Toaster
多功能 Android 吐司工具Toaster
### 依赖
---
- AndroidStudio
```
	allprojects {
			repositories {
				...
				maven { url 'https://jitpack.io' }
		    }
	}
```
```
	 compile 'com.github.AcmenXD:Toaster:1.0'
```
### 功能
---
- 设置Debug开关,支持调试模式吐司
- 支持自定义时长
- 支持'无等待'模式,强制弹出
- 支持吐司显示位置定义,上中下左右 + 偏移量设置
- 支持R.string.id类型
- 支持View类型,自定义吐司视图
- 支持java任意类型的输出,不在局限于String类型

### 配置
---
**在Application中配置**
```java
/**
 * 设置Context对象
 * * 必须设置,否则无法使用
 */
Toaster.setContext(this);
/**
 * 设置debug开关,可根据debug-release配置
 * 默认为true
 */
Toaster.setDebugOpen(true);
/**
 * 设置默认显示时长
 * 默认为ToastD.SHORT = Toast.LENGTH_SHORT
 */
Toaster.setDefaultDuration(ToastD.SHORT);
/**
 * 设置Toaster显示方式 :  |
 * 默认为ToastNW.NEED_WAIT(Toast需要等待,并逐个显示) 可设置为:ToastNW.No_NEED_WAIT(Toast无需等待,直接显示)
 */
Toaster.setNeedWait(ToastNW.NEED_WAIT);
```
### 使用 -> 以下代码 注释很详细、很重要很重要很重要!!!
---
```java
/**
 * debug模式下显示吐司,debugOpen为false时,将不显示
 */
Toaster.debugShow("DebugToastShow");
```
---
```java
/**
 * 支持任意多个参数+多类型
 */
Toaster.show("Toast显示第1部分", "\n", "Toast显示第2部分", 5);
```
---
```java
/**
 * 支持自定义View类型
 */
Toaster.show(customView);
```
---
```java
/**
 * 强制弹出,无等待
 */
Toaster.show(ToastNW.No_NEED_WAIT, "Toast显示第1部分", "\n", "Toast显示第2部分");
```
---
```java
/**
 * 自定义时长
 */
Toaster.show(ToastD.d(4000), "Toast显示第1部分", "\n", "Toast显示第2部分");
```
---
```java
/**
 * 位置居中显示
 */
Toaster.show(Gravity.CENTER, new String[]{"Toast显示第1部分", "\n", "Toast显示第2部分"});
```
---
```java
/**
 * 强制弹出,无等待 + 自定义时长 + 位置居中显示
 */
Toaster.show(ToastNW.No_NEED_WAIT, ToastD.d(4000), Gravity.TOP, new String[]{"Toast显示第1部分", "\n", "Toast显示第2部分"});
```
---
### 打个小广告^_^
**gitHub** : https://github.com/AcmenXD   如对您有帮助,欢迎点Star支持,谢谢~

**技术博客** : http://blog.csdn.net/wxd_beijing
# END