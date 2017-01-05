Bugtags Android SDK for Eclipse
===================
# Bugtags Bug Reporter for Android

Improve your app quality and reliability through In-App bug reporting and crash reporting.

## Key Features

### Bug Reporting

Report bugs directly from within your app, no longer need to switch to a bug reporting application.

### Crash Reporting

Automatically report and analyze crashes, no longer need to symbolicate stack traces manually.

### In-App Feedback

Allow your customers to send their feedback directly from within your app by just shaking their mobile devices. 

# Integration

Please visit [Bugtags Eclipse integration](https://docs.bugtags.io/start/integrate/android/manual.html).

# Changelogs

<<<<<<< HEAD
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

# Change log

see in [releases](https://github.com/bugtags/Bugtags-Android/releases)
=======
Please visit [Bugtags changelogs](https://docs.bugtags.io/changelog/android.html).
>>>>>>> anr-demo

# License
This demo is licensed under the MIT License.

