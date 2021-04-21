package com.ikang.mydark;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/8/5 0005
 * 邮箱：chenggang.zhang@ikang.com
 */
class BianLiangBean {

    public int testInt;

    public String testString;


    public int getTestInt() {
        return testInt;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }


    @Override
    public String toString() {
        return "BianLiangBean{" +
                "testInt=" + testInt +
                ", testString='" + testString + '\'' +
                '}';
    }
}
