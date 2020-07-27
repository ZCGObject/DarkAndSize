package com.ikang.mydark.util;

public abstract class RequestListener<T> {

    public abstract void onSuccess(T t);

    public abstract void onFailed(String err);
}
