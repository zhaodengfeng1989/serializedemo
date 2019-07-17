package com.zhaodf;

import java.io.*;

/**
 * 类：SuperDemo
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class SuperDemo {
    public static void main(String[] args) {
        //序列化
        SerializePerson();
        //反序列化
        DeSerializePerson();
    }

    private static void SerializePerson(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
            User user = new User();
            user.setName("zhaodf");
            user.setAge(18);
            oos.writeObject(user);
            System.out.println("序列化成功");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User DeSerializePerson(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user.txt")));
            User user = (User) ois.readObject();
            System.out.println(user.toString());
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
