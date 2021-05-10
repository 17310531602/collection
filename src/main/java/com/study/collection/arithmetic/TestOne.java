package com.study.collection.arithmetic;

import com.study.collection.arithmetic.LinkedTable.Node;

/**
 * @author pcc
 * @version 1.0.0
 * @className Test
 * @date 2021-04-14 15:48
 */
public class TestOne {
    public static void main(String[] args) {
//        testIf();
//        testNull(null);
        testDeng();

    }
    public static void testNull(Object obj){
        if(obj!=null)
            System.out.println("不等于null");
        else
            System.out.println("等于null");
    }
    public static void testIf(){
        for(int i=0;i<5;i++)
            if(i>1)
                System.out.println("i大于1："+i);
            else
                System.out.println("i不大于1："+i);

        System.out.println("************************分割线************************");
    }
    public static void testDeng(){
        Node head = new Node();
        head.next = new Node("张三",new Node("李四",null));

        head.next = new Node("王五",head.next);
        System.out.println(head);
    }
}
