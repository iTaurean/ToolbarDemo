## Toolbar的使用
Toolbar的使用和Toolbar作为作为项目的基类的使用

### Toolbar在appcompact-v7包下面，在gradle中添加如下依赖

```
compile ‘com.android.support:appcompat-v7:22.2.1’
```
*其中22.2.1是根据项目的具体版本可以变动，但是必须要21以上版本*

### 定义Toolbar

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.Toolbar xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:minHeight="?attr/actionBarSize"
    android:paddingTop="@dimen/toolbar_padding_top"
    android:contentInsetStart="0dp"
    android:contentInsetEnd="0dp"
    app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
    app:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar" />
```

这里可以设置Toolbar的高度，主题等属性。Toolbar的高度可以根据项目的具体要求设定具体的值。
关键点在这里添加了一个paddingTop属性，是为了让顶部的状态栏的背景色跟我们app 的保持一致，需要用到这个值。


***知识补充：**在4.4以上的版本给Toolbar设置一个paddingTop的属性为status_bard高度，Toolbar就会延伸到status_bar的位置。另外，4.4系统status_bar默认是透明的，在5.0以上是半透明的。Status_bar的高度为25dp，获取status_bar高度方法:*

```
public int getStatusBarHeight() {
    int result = 0;
    int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
        result = getResources().getDimensionPixelSize(resourceId);
    }
    return result;
}
```


### 设置toolbar_padding_top值

**需要在values/dimens，values-v19/dimens两个文件下设置这个值：**
> values-v19/dimens.xml下的值为0


```
<dimen name=”toolbar_padding_top”>25dp</dimen>
```
> values/dimens.xml下的值为25dp


```
<dimen name="toolbar_padding_top">0dp</dimen>
```


### 设置主题Theme

在values-v19/styles.xml下声明AppTheme为透明状态栏

```
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="android:windowTranslucentStatus">true</item>
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
</style>
```

### 改变状态栏颜色

> 在values-v19/styles.xml下声明AppTheme为透明状态栏> 

```
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <!-- Customize your theme here. -->
    <item name="android:windowTranslucentStatus">true</item>
</style>
```

> 但是以上在xml中声明在某些国产rom上不起效果，所以建议在代码中添加如下代码

```
// 因为有些国产定制的rom上，xml中定义会不起效果。在代码里直接声明透明状态栏更有效
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
}
```













