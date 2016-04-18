Bugtags Android SDK for Eclipse
===================
###中文文档请移步[README_CN](README_CN.md)
###QQ tribe for help: 479166560

> If you are using Android Studio for Android development, please visit: [Bugtags-Android].

> For more information, please visit: [Bugtags-Android]

## Step 1:
* Clone this project to your disk and add it to your workspace then add it as a dependency in your application's project.

* Request the following permissions in your AndroidManifest.xml:

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
* add activities and service in AndroidManifest.xml:

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

## Step 2:
* Add three callbacks in your base Activity class:

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

## Step 3:
* Create subclass of Application，initialize Bugtags in onCreate() method:

```
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
# 2016.04.14 v1.2.4
- fix bug in network tracking in okhttp
- fix bug in screenshot on devices with soft navigation bar
- catch exception that might happen in screenshot
- tune timeout for data upload, to prevent error in bad quality network
- fix ssl error happen in sending data via https

### 2016.03.31 v1.2.3
- remove a dependency is not used
- fix bug when network switching

### 2016.03.31 v1.2.2
- remove a dependency is not used

### 2016.03.30 v1.2.1
- support `okhttp3` network request tracking
- support `loopj/android-async-http` network request tracking
- add `uploadDataOnlyViaWiFi` start option, allow only send in WiFi network
- add `currentInvocationEvent` api, accessing the current invocation mode
- other fix

### 2016.03.12 v1.2.0
- network request tracking（support HTTP / HTTPS protocol），diable by default, set `trackingNetworkEnabled true` to open
- retrieve buble mode from server configuration
- fix issue: assignee list retrieving error
- fix issue: rotation make bubble disappear
- fix issue: ui appearance after priority set
- other bug fix

### 2016.03.09 v1.1.2
- fix issue: under some circumstance bubble disappears 
- fix ineffective sslv3 solution in v1.1.1
- other bug fix

### 2016.02.20 v1.1.1

- Java 1.6 compatibility
- remove phone permission
- fix sslv3 protocol issue
- other bug fix

### 2016.01.06 v1.1.0

- support `cocos2d-x game` screenshot(`need to build package by gradle`)
- add `callback before and after sending issue`
- add `manually invoke screenshot`
- fix competing thread bug on resending issue
- other bug fix

### 2015.12.05 v1.0.9

- bugfix for user step timestamp, better layout
- bugfix for some customized android ROM's missing sdcard
- change reference to weak reference, `prevent potential memory leak`

### 2015.11.19 v1.0.8

- screenshot with `toast and dialog`
- performance improving

### 2015.11.06 v1.0.7

- add api for `custom version name & version code`
- bug fix

### 2015.10.24 v1.0.6

- support `tartgetSdkVersion=23(Android M, 6.0)`
- long-press on "+" button to `restart logging`
- support anonymous report options
- improve crash collecting policy, `disable when debugger connected`
- add CPU architecture for device information
- fix console log policy
- support `uses-permission customization`
- start options for crashWithScrenshot

### 2015.09.29 v1.0.5

- `crash with photo`, start options,
- bug fix
- performance improving

### 2015.09.03 v1.0.4

- performance improving

### 2015.08.26 v1.0.3

- send progress
- simplify dependency
- improve integration

### 2015.08.20 v1.0.2

- performance improving

### 2015.08.15 v1.0.1

- bug fix

### 2015.08.07 v1.0.0

- official release

### 2015.08.01 v0.9.0

- pre-release

[Bugtags-Android]:https://github.com/bugtags/Bugtags-Android
