package com.sunnaiyu.afternoon;

import org.junit.Test;

import javax.lang.model.type.ArrayType;
import java.io.Serializable;
import java.util.*;

public class Ch02 implements Serializable {

    @Test
    public void test03() {
        Map<String, String> map = new HashMap<>();
        map.put("1001","aaa");
        map.put("1002","bbb");
        map.put("1003","ccc");
        map.put("1004","ddd");

        // 1.使用keySet先拿到所有的key，再根据key获取value
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "->" + map.get(key));
        }

        // 2.使用内部类Entry（推荐）
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

    }

    @Test
    public void test02() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");

        // 1.增强for循环
        for (String s : set) {
            // TODO
        }

        // 2.迭代器
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test01(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        // 1.for循环
        for (int i = 0; i < list.size(); i++) {
            // TODO
        }
        // 2.增强for循环
        for (String s : list) {
            // TODO
        }
        // 3.迭代器
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
