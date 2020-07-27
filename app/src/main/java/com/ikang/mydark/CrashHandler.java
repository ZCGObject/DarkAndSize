package com.ikang.mydark;

/**
 * Created by ${chuan.qi} on 2016/7/12.
 * email:chuan.qi@ikang.com
 * explain:
 */

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * <p>
 * 需要在Application中注册，为了要在程序启动器就监控整个程序。
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler===>>>";
    private Context mContext;//程序的Context对象

    private static CrashHandler instance; //CrashHandler实例

    private Thread.UncaughtExceptionHandler mDefaultHandler;//系统默认的UncaughtException处理类

    private Map<String, String> infos = new HashMap<String, String>();//用来存储设备信息和异常信息

    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//用于格式化日期,作为日志文件名的一部分

    /**
     * 保证只有一个CrashHandler实例
     */
    private CrashHandler() { }

    /**
     * 获取CrashHandler实例 ,单例模式
     */
    public static CrashHandler getInstance() {
        if (instance == null)
            instance = new CrashHandler();
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();//获取系统默认的UncaughtException处理器
        Thread.setDefaultUncaughtExceptionHandler(this); //设置该CrashHandler为程序的默认处理器
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e("CrashHandler===>>>", "thread:" + thread.getName() + "---ex:" + ex.toString());
        if (!handleException(thread, ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            Log.e("CrashHandler===>>>", "uncaughtException  nonono");
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            Log.e("CrashHandler===>>>", "uncaughtException  yesyesyes");
            mDefaultHandler.uncaughtException(thread, ex);
//            int currentVersion = android.os.Build.VERSION.SDK_INT;
//            if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
//                Intent startMain = new Intent(Intent.ACTION_MAIN);
//                startMain.addCategory(Intent.CATEGORY_HOME);
//                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(startMain);
//                System.exit(0);
//            } else {// android2.1
//                ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
//                am.restartPackage(mContext.getPackageName());
//            }

        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private boolean handleException(Thread thread, Throwable ex) {
        if (ex == null) {
            Log.e("CrashHandler===>>>", "uncaughtException  ex == null");
            return false;
        }
        Log.e("CrashHandler===>>>", "uncaughtException  自己捕获处理");
        return true;
    }

}