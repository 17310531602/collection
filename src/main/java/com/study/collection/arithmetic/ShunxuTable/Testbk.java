package com.study.collection.arithmetic.ShunxuTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pcc
 * @version 1.0.0
 * @className Testbk
 * @date 2021-04-13 22:51
 */
public class Testbk {
    public static void main(String[] args) throws Exception{
        List<String> listt = new ArrayList<>();
        Object[] objArray = new Object[5];

        TestShunxuTable testShunxuTable = new TestShunxuTable(10);
        testShunxuTable.insert("张三1",0);
        testShunxuTable.insert("张三2",1);
        testShunxuTable.insert("张三3",2);
        testShunxuTable.insert("张三4",3);
        testShunxuTable.insert("张三5",4);
        testShunxuTable.insert("张三6",5);
        testShunxuTable.insert("张三2",6);
        for(int i=0;i<testShunxuTable.length();i++){
            System.out.println(testShunxuTable.get(i));
        }
        //测试为空方法
        System.out.println(testShunxuTable.isEmptry());
        //测试是否满方法
        System.out.println(testShunxuTable.isFull());
        //测试根据下标删除方法
        testShunxuTable.remove(2);
        for(int i=0;i<testShunxuTable.length();i++){
            System.out.println(testShunxuTable.get(i));
        }
        //测试第一次出现某个元素的第一个下标
        System.out.println(testShunxuTable.indexOf("张三21"));
        //测试数据元素进行覆盖操作
        testShunxuTable.insert("覆盖",5);
        for(int i=0;i<testShunxuTable.length();i++){
            System.out.println(testShunxuTable.get(i));
        }
    }
}
