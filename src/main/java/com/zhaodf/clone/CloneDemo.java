package com.zhaodf.clone;

/**
 * 类：CloneDemo
 *
 * @author zhaodf
 * @date 2019/7/15
 */
public class CloneDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("zhaodf");
        student.setAge(18);
        Teacher teacher = new Teacher();
        teacher.setName("lirc");
        student.setTeacher(teacher);

        Student student1 = (Student) student.deepClone();
        student1.getTeacher().setName("zhaodl");
        System.out.println(student);
        System.out.println(student1);
    }
}
