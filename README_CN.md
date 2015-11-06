Bugtags Android SDK for Eclipse
===================
> Latest version: **1.0.7**

> 如果你使用Android Studio来开发Android App, 请访问: [Bugtags-Android].

> 要获取更多信息，请访问: [Bugtags-Android]。

# 安装集成:

## 第一步：
* 克隆本项目到本地，并添加到你的工作空间，然后将其添加为你的应用程序的项目的依赖。

* 在 AndroidManifest.xml中添加以下权限：
```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_LOGS"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
```
* 在AndroidManifest.xml中添加所需的activity和服务：
```xml
<activity android:name="com.bugtags.library.BugtagsActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen"/>
<service android:name="com.bugtags.library.BugtagsService"/>
<receiver android:name="com.bugtags.library.BugtagsReceiver">
            <intent-filter>
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE"/>
            </intent-filter>
</receiver>
```

## 第二步：
* 在你的Activity基类中添加三个回调：
```java
    package your.package.name;

    import android.app.Activity;
    import android.os.Bundle;
    import android.view.MotionEvent;

    import com.bugtags.library.Bugtags;

    public class CustomActivity extends Activity{
        @Override
        protected void onResume() {
            super.onResume();
            //callback 1
            Bugtags.onResume(this);
        }

        @Override
        protected void onPause() {
            super.onPause();
            //callback 2
            Bugtags.onPause(this);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            //callback 3
            Bugtags.onDispatchTouchEvent(this, event);
            return super.dispatchTouchEvent(event);
        }
    }
```

## 第三步：
* 继承Application，在onCreate() 方法中初始化Bugtags：
```java
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在这里初始化
        Bugtags.start("YOUR APPKEY", this, Bugtags.BTGInvocationEventBubble);
    }
}
```
修改AndroidManifest.xml，使用MyApplication类,例如：
```xml
<application
    android:name=".MyApplication"
    android:label="@string/app_name"
    android:theme="@style/AppTheme" >
    ....
</application>
```

# License
This demo is [BSD-licensed](LICENSE).


# Change log
2015.11.06    1.0.7
- 自定义version name 与 version code
- bug fix

2015.10.24    1.0.6     
- 支持targetSdkVersion 23(Android M, 6.0)；
- 新增长按截图按钮重新开始记录数据;
- 支持后台高级设置的匿名提交选项；
- 优化闪退捕捉逻辑，Debugger Connected状态下默认不上报闪退；
- 设备信息增加CPU构架信息；
- 修正console log获取逻辑；
- 权限可裁剪，裁剪方法见帮助文档；
- 启动选项可选crash截屏。

2015.09.29    1.0.5    崩溃截图、更多启动选项、bug修复、性能优化

2015.09.03    1.0.4    性能优化

2015.08.26    1.0.3    传输反馈、精简依赖、改善集成方式

2015.08.20    1.0.2    性能优化

2015.08.15    1.0.1    小问题修改

2015.08.07    1.0.0    正式版发布

2015.08.01    0.9.0    Pre-release发布


[Bugtags-Android]:https://github.com/bugtags/Bugtags-Android
