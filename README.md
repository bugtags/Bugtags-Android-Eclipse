Bugtags Android SDK for Eclipse
===================
###中文文档请移步[README_CN](README_CN.md)
###QQ tribe for help: 479166560
> If you are using Android Studio for Android development, please visit: [Bugtags-Android].

> For more information, please visit: [Bugtags-Android]

1. Clone this project to your disk and add it to your workspace then add it as a dependency in your application's project.

2. Request the following permissions in your AndroidManifest.xml:

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

3. add activities and service in AndroidManifest.xml:

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

4. Create subclass of Application，initialize Bugtags in onCreate() method:
```java
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //initialize here
        Bugtags.start("YOUR APPKEY", this, Bugtags.BTGInvocationEventBubble);
    }
}
```
Modify AndroidManifest.xml，use MyApplication:
```xml
<application
    android:name=".MyApplication"
    android:label="@string/app_name"
    android:theme="@style/AppTheme" >
    ....
</application>
```

5. Add three callbacks in your base Activity class:
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
