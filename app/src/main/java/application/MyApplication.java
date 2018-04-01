package application;

import android.app.Application;

/**
 * Created by Administrator on 2018/3/30.
 * 整个程序的入口 进行初始化工作
 * 为整个应用模块提供上下文环境
 */

public class MyApplication extends Application {
    private static MyApplication application=null;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;

    }

    public static MyApplication getInstance(){
        return application;
    }

}
