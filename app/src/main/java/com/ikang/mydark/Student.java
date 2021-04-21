package com.ikang.mydark;

import androidx.annotation.NonNull;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2021/4/15 0015
 * 邮箱：chenggang.zhang@ikang.com
 */
public class Student implements Cloneable{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    @NonNull
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}
