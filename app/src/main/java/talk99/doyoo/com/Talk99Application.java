package talk99.doyoo.com;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2018/1/25.
 */

public class Talk99Application extends Application {

    private RefWatcher install;
    public static int screen_width=0;
    public static int screen_height=0;

    @Override
    public void onCreate() {
        super.onCreate();
        initLeakcanary();
        getScreen();
    }

    /**
     * 获取屏幕宽高
     */
    private void getScreen() {
        DisplayMetrics metrics=new DisplayMetrics();
        screen_width=metrics.widthPixels;
        screen_height=metrics.heightPixels;
    }

    /**
     * 初始化LeakCanary
     */
    private void initLeakcanary() {
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        install=LeakCanary.install(this);

    }

    /**
     * 获取RefWatcher
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context){
        Talk99Application application=(Talk99Application) context.getApplicationContext();
        return application.install;
    }

}
