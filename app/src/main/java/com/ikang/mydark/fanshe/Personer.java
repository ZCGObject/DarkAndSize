package com.ikang.mydark.fanshe;

public class Personer {
 
    private int age;
    private String name;
 
    public Personer(String name, int age) {
        this.age = age;
        this.name = name;
    }
 
    public Personer() {
    }
 
 
    //公有 有参方法
    public void public_show(String str,int i)
    {
        System.out.println("public show "+str+"..."+i);
    }

    //公有 无参方法
    public void public_prin()
    {
        System.out.println("public prin");
    }
 
 
    //私有 有参方法
    private void private_show(String str,int i)
    {
        System.out.println("private show "+str+"..."+i);
    }

    //私有 无参方法
    private void private_prin()
    {
        System.out.println("private prin");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
