Bugtags Android SDK for Eclipse
===================
> 如果你使用Android Studio来开发Android App, 请访问: [Bugtags-Android].

> 要获取更多信息，请访问: [Bugtags-Android]。

# 安装集成:

1. 克隆本项目到本地，并添加到你的工作空间，然后将其添加为你的应用程序的项目的依赖。 Eclipse项目需要以下库的依赖关系：

  ```
  Android v4 support library
  Android v7 app compat support library
  ```
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
4. 在你的Application的onCreate() 方法中初始化Bugtags：

  ```java
    Bugtags.start("YOUR APPKEY", this, Bugtags.BTGInvocationEventBubble);
  ```
5. 让你的Activity中继承以下Activity, 则可自动跟踪用户步骤：
  ```java
   BugtagsAppCompatActivity: This extends android.support.v7.app.AppCompatActivity
   BugtagsActionBarActivity: This extends android.support.v7.app.ActionBarActivity
   BugtagsActivity: This extends android.app.activity
   BugtagsFragmentActivity: This extends android.support.v4.app.FragmentActivity
  ```
  *也可以在你的Activity中手动添加回调，请参考：[CustomActivity](#customactivity).*

  ##	CustomActivity
  ```java
        package your.package.name;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.MotionEvent;

        import com.bugtags.library.Bugtags;

        public class CustomActivity extends Activity{
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                Bugtags.onCreate(this);
            }

            @Override
            protected void onResume() {
                super.onResume();
                Bugtags.onResume(this);
            }

            @Override
            protected void onPause() {
                super.onPause();
                Bugtags.onPause(this);
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
                Bugtags.onDestroy(this);
            }

            @Override
            public boolean dispatchTouchEvent(MotionEvent event) {
                Bugtags.onDispatchTouchEvent(this, event);
                return super.dispatchTouchEvent(event);
            }
        }
  ```

[Bugtags-Android]:https://github.com/bugtags/Bugtags-Android
