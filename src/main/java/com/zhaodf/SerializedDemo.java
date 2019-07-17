package com.zhaodf;

import java.io.*;

/**
 * 类：SerializedDemo
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class SerializedDemo {
    public static void main(String[] args) {
        //序列化
        SerializePerson();
        //反序列化
        Person person = DeSerializePerson();
    }

    private static void SerializePerson(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
            Person person = new Person();
            person.setName("zhaodf");
            person.setAge(18);
            person.setSex("M");
            oos.writeObject(person);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person.txt")));
            Person person1 = (Person)ois.readObject();
            System.out.println("第一次序列化成功，序列化后文件大小："+new File("person.txt").length());
            oos.writeObject(person);
            oos.flush();
            System.out.println("第二次序列化成功，序列化后文件大小："+new File("person.txt").length());
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(new File("person.txt")));
            Person person2 = (Person)ois.readObject();

            System.out.println(person1==person2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Person DeSerializePerson(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person.txt")));
            Person person = (Person)ois.readObject();
            System.out.println(person.toString());
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
