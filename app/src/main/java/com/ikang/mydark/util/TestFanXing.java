package com.ikang.mydark.util;

import android.app.Activity;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/24 0024
 * 邮箱：chenggang.zhang@ikang.com
 */
public class TestFanXing {


    @SuppressWarnings("unchecked")
    public <T> void getData(final Activity activity, final RequestListener<T> l){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Type type = getTType(l.getClass());
                            String s = "{\"name\":\"success\"}";
                            l.onSuccess((T) JSONObject.parseObject(s, type));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public <T> void getO(final RequestNewListener<T> l){
        Type type = getType(l.getClass());
        String s = "{\"name\":\"success\"}";
        l.onSuccess((T) JSONObject.parseObject(s, type));


    }




    /**
     * 根据泛型获取Class类
     * @param clazz
     * @return
     */
    private Type getTType(Class<?> clazz) {
        Type mySuperClassType = clazz.getGenericSuperclass();//当前运行类的父类(RequestListener<T>，以为Person例，RequestListener<Person>)
        if(null != mySuperClassType){
            ParameterizedType parameterizedType = (ParameterizedType) mySuperClassType;// 强制转化“参数化类型”
            Type[] types = parameterizedType.getActualTypeArguments();// 参数化类型中可能有多个泛型参数
            if (types != null && types.length > 0) {
                //获取数据的第一个元素(User.class)
                return types[0];// com.ikang.mydark.util.Person.class
            }
        }
        return null;
    }

    /**
     * 根据泛型获取Class类
     * @param clazz
     * @return
     */
    private <T> Type getType(Class<?> clazz) {
        try {
                /*
                返回表示由此对象表示的类或接口直接实现的接口的类型。
                如果超级接口是一个参数化类型，返回的Type对象必须准确地反映源代码中使用的实际类型参数。代表每个超级界面的参数化类型是在之前没有创建的情况下创建的。有关参数化类型的创建过程的语义，请参阅ParameterizedType的声明。
                如果此对象表示一个类，则返回值是一个包含表示由类实现的所有接口的对象的数组。数组中接口对象的顺序对应于该对象表示的类的声明的implements子句中的接口名称的顺序。在数组类中，接口Cloneable和Serializable按照这个顺序返回。
                如果此对象表示一个接口，则该数组包含表示由该接口直接扩展的所有接口的对象。数组中接口对象的顺序对应于该对象表示的接口声明的extends子句中接口名称的顺序。
                如果此对象表示不实现接口的类或接口，则该方法返回长度为0的数组。
                如果这个对象表示一个原始类型或void，则该方法返回一个长度为0的数组。
                * */
            Type[] types = clazz.getGenericInterfaces();
            ParameterizedType parameterizedType = (ParameterizedType) types[0];
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Class<T> reponseClass = (Class) actualTypeArguments[0];
            return actualTypeArguments[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
