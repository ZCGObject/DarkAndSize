package com.ikang.mydark.util;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/9/26 0026
 * 邮箱：chenggang.zhang@ikang.com
 */
public interface RequestNewListener<T> {
    void onSuccess(T t);
    void onFailed(String err);
}
