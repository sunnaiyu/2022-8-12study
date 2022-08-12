package com.sunnaiyu.afternoon;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Ch01 implements Comparable {

    public static void show() throws Exception {
        int i = 0;
        if(i < 10){
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        Collection collection1 = new HashSet();

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
