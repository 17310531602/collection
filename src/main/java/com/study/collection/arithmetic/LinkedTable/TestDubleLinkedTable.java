package com.study.collection.arithmetic.LinkedTable;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestDubleLinkedTable
 * @date 2021-04-19 17:04
 */
public class TestDubleLinkedTable {
    public static void main(String[] args) throws Exception{
        DoubleLinkedTable linkedTable = new DoubleLinkedTable();
        linkedTable.insert(0,"张三");
        linkedTable.insert(1,"李四");
        linkedTable.insert(2,"王五");
        linkedTable.insert(3,"赵柳");
        linkedTable.display();
        System.out.println("*************************分割线*************************");
        linkedTable.remove(linkedTable.length()-1);
        linkedTable.display();
        System.out.println("*************************分割线*************************");
        System.out.println(linkedTable.get(1));
        System.out.println(linkedTable.getPrior(1));
        System.out.println(linkedTable.getNext(1));
    }
}
