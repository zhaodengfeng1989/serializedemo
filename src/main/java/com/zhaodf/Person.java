package com.zhaodf;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * 类：Person
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 8761451573880726390L;
    @Protobuf(fieldType=FieldType.STRING)
    private String name;
    @Protobuf(fieldType=FieldType.INT32)
    private int age;
    @Protobuf(fieldType=FieldType.STRING)
    private String sex;
    public static int height = 175;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
