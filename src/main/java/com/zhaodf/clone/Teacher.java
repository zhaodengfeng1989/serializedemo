package com.zhaodf.clone;

import java.io.*;

/**
 * 类：Teacher
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class Teacher implements Serializable{

    private static final long serialVersionUID = 2325719578664034973L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
