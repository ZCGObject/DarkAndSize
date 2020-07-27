package com.ikang.mydark.util;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/24 0024
 * 邮箱：chenggang.zhang@ikang.com
 */
public class Person extends BaseResult{

    public String result;

    public String name;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
