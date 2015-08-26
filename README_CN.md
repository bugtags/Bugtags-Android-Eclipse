Bugtags Android SDK for Eclipse
===================
> 如果你使用Android Studio来开发Android App, 请访问: [Bugtags-Android].

> 要获取更多信息，请访问: [Bugtags-Android]。

# 安装集成:

1. 克隆本项目到本地，并添加到你的工作空间，然后将其添加为你的应用程序的项目的依赖。

2. 在 AndroidManifest.xml中添加以下权限：

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
3. 在AndroidManifest.xml中添加所需的activity和服务：

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
4. 继承Application，在onCreate() 方法中初始化Bugtags：
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

  ```java
    Bugtags.start("YOUR APPKEY", this, Bugtags.BTGInvocationEventBubble);
  ```
  
5. 在你的Activity基类中添加三个回调：

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

[Bugtags-Android]:https://github.com/bugtags/Bugtags-Android
