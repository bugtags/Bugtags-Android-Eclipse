package iot.bugtags.demo;

import android.os.Bundle;
import android.view.View;

/**
 * Created by kevin on 15/7/28.
 */
public class CustomActivity extends BaseActivity {

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        setContentView(R.layout.activity_custom);
    }

    public void onBack(View view) {
        finish();
    }
}
