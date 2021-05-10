package com.study.collection.arithmetic.ShunxuTable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pcc
 * @version 1.0.0
 * @className Test
 * @date 2021-04-13 15:44
 */
public class Test {
    public static void main(String[] args) throws Exception{
        TestShunxuTable shunxuTable = new TestShunxuTable(10);
        shunxuTable.insert("张三1",0);
        shunxuTable.insert("张三2",1);
        shunxuTable.insert("张三3",2);
        System.out.println("**********测试根据下标获取**********");
        System.out.println(shunxuTable.get(1));
        System.out.println("**********测试根据下标删除**********");
        shunxuTable.remove(0);
        for(int i=0;i<shunxuTable.length();i++)
            System.out.print(shunxuTable.get(i)+",");
        System.out.println();
        System.out.println("**********测试某元素第一次出现的下标**********");
        shunxuTable.insert("张三2",2);
        System.out.println(shunxuTable.indexOf("张三2"));
        System.out.println(shunxuTable.indexOf("张三22"));
        System.out.println("**********测试获取顺序表有效长度**********");
        System.out.println(shunxuTable.length());
        System.out.println("**********测清空况方法**********");
        shunxuTable.clear();
        for(int i=0;i<shunxuTable.length();i++)
            System.out.print(shunxuTable.get(i)+",");
    }
}
