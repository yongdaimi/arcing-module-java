package app.android.module_base.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Base Application
 * <p>
 * Note: all modules that require modular development need to inherit from this BaseApplication.
 *
 * @author xp.chen
 */
public class BaseApplication extends Application {

    // Globally unique context
    private static BaseApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize ARouter
        initARouter();
        // Initialize other third-party libraries
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        sApplication = this;
        // MultiDex sub-package initialization must be initialized first
        MultiDex.install(this);
    }

    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();      // 打印日志
            ARouter.openDebug();    // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(sApplication);// 尽可能早，推荐在Application中初始化
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // Clean the ARouter registry
        ARouter.getInstance().destroy();
    }

    /**
     * Get globally unique context
     *
     * @return BaseApplication
     */
    public static BaseApplication getApplication() {
        return sApplication;
    }

}
