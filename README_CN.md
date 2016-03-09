Bugtags Android SDK for Eclipse
===================
> Latest version: **1.1.2**

> 如果你使用Android Studio来开发Android App, 请访问: [Bugtags-Android].

> 要获取更多信息，请访问: [Bugtags-Android]。

# 安装集成:

## 第一步：
* 克隆本项目到本地，并添加到你的工作空间，然后将其添加为你的应用程序的项目的依赖。

* 在 AndroidManifest.xml中添加以下权限：

```
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_LOGS"/>
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
```
* 在AndroidManifest.xml中添加所需的activity和服务：

```
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

```
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

```
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

```
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
### 2016.03.09 v1.1.2

- 修复某些情况下小球可能会消失的问题
- 修复 v1.1.1 中 sslv3 解决方案未生效的问题
- 细节修复

### 2016.02.20 v1.1.1

- 兼容 Java 1.6
- 移除电话权限
- 修复可能存在的 sslv3 协议问题
- 细节修复

### 2016.01.06 v1.1.0

- 增加对 __`cocos2d-x 游戏`__的截屏支持(`仅支持以 gradle 打包`)
- 新增设置问题`提交之前和之后的回调 API`
- 新增`手动调用截屏界面` API
- 修复问题重传时可能产生的多线程竞争问题
- 其他 bug 修复

### 2015.12.05 v1.0.9

- 修复用户步骤时间记录的 bug，修改显示样式使得更易读
- 修复某些安卓 ROM 的 sdcard 路径不规范可能引起的 bug
- 修改对于 activity 的引用为软引用，`防止可能存在的内存泄漏`

### 2015.11.19 v1.0.8

- 截图改进：包括 __`Toast 和 Dialog`__
- 性能优化

### 2015.11.06 v1.0.7

- `自定义` version name 与 version code
- bug fix

### 2015.10.24 v1.0.6

- 支持 __`targetSdkVersion 23(Android M, 6.0)`__；
- 新增长按截图按钮重新开始记录数据;
- 支持后台高级设置的匿名提交选项；
- 优化闪退捕捉逻辑，Debugger Connected状态下__`默认不上报闪退`__；
- 设备信息增加 CPU 构架信息；
- 修正 console log 获取逻辑；
- __`权限可裁剪`__，裁剪方法见帮助文档；
- 启动选项可选 crash 截屏。

### 2015.09.29 v1.0.5

- `崩溃截图`
- 更多启动选项
- bug 修复
- 性能优化

### 2015.09.03 v1.0.4

- 性能优化

### 2015.08.26 v1.0.3

- 传输反馈
- 精简依赖
- 改善集成方式

### 2015.08.20 v1.0.2

- 性能优化

### 2015.08.15 v1.0.1

- 小问题修改

### 2015.08.07 v1.0.0

- 正式版发布

### 2015.08.01 v0.9.0

- Pre-release 发布

[Bugtags-Android]:https://github.com/bugtags/Bugtags-Android
