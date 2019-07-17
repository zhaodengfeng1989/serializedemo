package com.zhaodf.jsondemo;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.zhaodf.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 类：JsonDemo
 *
 * @author zhaodf
 * @date 2019/7/16
 */
public class JsonDemo {
    public static void main(String[] args) {
        try {
            executeWithJackJson();
            executeWithFastJson();
            executeWithProtoBuf();
            executeWithHessian();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person init(){
        Person person = new Person();
        person.setName("zhaodf");
        person.setAge(18);
        person.setSex("M");
        return  person;
    }

    private static void executeWithJackJson() throws IOException {
        Person person = init();
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] writeBytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            //序列化
            writeBytes = objectMapper.writeValueAsBytes(person);
        }
        System.out.println("json序列化:"+(System.currentTimeMillis()-start)+"ms,字节数大小为"+writeBytes.length);
        //反序列化
        Person person1 = objectMapper.readValue(writeBytes,Person.class);
        System.out.println(person1.toString());
    }

    private static void executeWithFastJson() throws IOException {
        Person person = init();
        String text = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            //序列化
            text = JSON.toJSONString(person);
        }
        System.out.println("fastjson序列化:"+(System.currentTimeMillis()-start)+"ms,字节数大小为"+text.getBytes().length);
        //反序列化
        Person person1 =  JSON.parseObject(text,Person.class);
        System.out.println(person1.toString());
    }

    private static void executeWithProtoBuf() throws IOException {
        Person person = init();
        Codec<Person> personCodec = ProtobufProxy.create(Person.class,false);
        long start = System.currentTimeMillis();
        byte[] bytes = null;
        for (int i = 0; i < 100 ; i++) {
            //序列化
            bytes = personCodec.encode(person);
        }
        System.out.println("jprotobuf序列化:"+(System.currentTimeMillis()-start)+"ms,字节数大小为"+bytes.length);
        //反序列化
        Person person1 =  personCodec.decode(bytes);
        System.out.println(person1.toString());
    }

    private static void executeWithHessian() throws IOException {
        Person person = init();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bos);
        long start = System.currentTimeMillis();
        //序列化
        hessianOutput.writeObject(person);
        System.out.println("hessian序列化:"+(System.currentTimeMillis()-start)+"ms,字节数大小为"+bos.toByteArray().length);
        //反序列化
        HessianInput hessianInput = new HessianInput(new ByteArrayInputStream(bos.toByteArray()));
        Person person1 =  (Person) hessianInput.readObject();
        System.out.println(person1.toString());
    }
}
