package com.zhaodf;

import java.io.Serializable;

/**
 * 类：SuperPerson
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class SuperUser implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
