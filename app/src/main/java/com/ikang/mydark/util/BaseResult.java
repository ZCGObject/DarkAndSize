package com.ikang.mydark.util;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/27 0027
 * 邮箱：chenggang.zhang@ikang.com
 */
public class BaseResult {

    /** 1:成功 0:失败 */
    public int code;
    public String message;
    public String errors;

    public boolean isSuccess(){
        return code == 1;
    }



}
