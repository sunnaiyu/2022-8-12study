package com.sunnaiyu.afternoon;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

class Son<String> extends Father<String>{

//    T m;

    @Test
    public void show() {
//        Son<String> son = new Son<>();
//        String str = son.t;
//        System.out.println(str);
////        System.out.println(son.m);
//
//        Random random = new Random();
//        random.nextInt(5);

        BigDecimal bigDecimal1 = new BigDecimal("120");
        BigDecimal bigDecimal2 = new BigDecimal("120");
        System.out.println(bigDecimal1.equals(bigDecimal2));
    }

}

public class Father<T> {

    T t;

    @Test
    public void show(){
        BigDecimal bigDecimal1 = new BigDecimal("120");
        BigDecimal bigDecimal2 = new BigDecimal("120.0");
//        System.out.println(bigDecimal1.equals(bigDecimal2));
//        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        BigInteger bigInteger = new BigInteger("987987988888888888888888888888888888888888");
        System.out.println(bigInteger);
    }
}
