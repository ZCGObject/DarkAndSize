package com.ikang.mydark.fanshe;

import android.nfc.Tag;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FanSheUtil{


    public static final String TAG = "FanSheUtil--->>>";


    public static void fanshe() throws Exception {

        //获取字节码文件中 方法 再取出其公有方法

        String classname = "com.ikang.mydark.fanshe.Personer";
        //寻找名称的类文件，加载进内存 产生class对象
        Class cl = Class.forName(classname);





        //获取一个Person对象
        Log.e(TAG, "获取一个Person对象:");
        Object obj = cl.newInstance();
        System.out.println();


        //1.获取 公有 无参方法 public void demo2.Person.public_prin()
        Method Person_public_prin = cl.getMethod("public_prin");
        Log.e(TAG, "获取执行 public void demo2.Person.public_prin() :");
        Person_public_prin.invoke(obj);

        System.out.println();

        //2.获取 公有 有参方法 public void demo2.Person.public_show(java.lang.String,int)
        Method Person_public_show = cl.getMethod("public_show", String.class, int.class);
        Log.e(TAG, "获取执行 public void demo2.Person.public_show(java.lang.String,int) :");
        Person_public_show.invoke(obj, "神奇的我", 12);

        System.out.println();

        //3.获取 私有 无参方法 private void demo2.Person.private_prin()
        Method Person_private_prin = cl.getDeclaredMethod("private_prin");
        Person_private_prin.setAccessible(true);
        Log.e(TAG, "获取执行 private void demo2.Person.private_prin() :");
        Person_private_prin.invoke(obj);

        System.out.println();

        //4.获取 私有 有参方法 private void demo2.Person.private_show(java.lang.String,int)
        Method Person_private_show = cl.getDeclaredMethod("private_show", String.class, int.class);
        Person_private_show.setAccessible(true);
        Log.e(TAG, "获取执行 private void demo2.Person.private_show(java.lang.String,int) :");
        Person_private_show.invoke(obj, "神奇的私有", 23);


        Method Person_set_name = cl.getDeclaredMethod("setName", String.class);
        Person_set_name.setAccessible(true);
        Log.e(TAG, "获取执行 private void demo2.Person.Person_set_name(java.lang.String) :");
        Person_set_name.invoke(obj, "张帅");


        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        Log.e(TAG, name.getName()+"---"+name.getGenericType()+"-----"+name.get(obj));

        System.out.println();
    }
}