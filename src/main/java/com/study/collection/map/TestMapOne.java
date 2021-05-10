package com.study.collection.map;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestMapOne
 * @date 2021-04-01 21:11
 */
public class TestMapOne {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add(null);
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);
        HashMap<String,String> hashMap = new HashMap<>(1333334);


    }

    public static Hashtable<String,String> getHashMap(){
        Hashtable<String,String> map = new Hashtable<>();
        for(int i=0;i<1000000;i++){
            map.put(i+"key",i+"value");
        }

        long timeStart = System.currentTimeMillis();
        map.forEach((key,value) ->{
            System.out.println(key+":"+value);
        });
        long timeEnd = System.currentTimeMillis();
        System.out.println("耗时："+(timeEnd-timeStart)+"毫秒");
        return map;
    }


}
