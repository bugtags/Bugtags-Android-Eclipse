package com.bugtags.demo;

import com.bugtags.library.Bugtags;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Bugtags.start("8f443d183b1d202a5b006faa4718e1a6", this, Bugtags.BTGInvocationEventBubble);
    }
}
