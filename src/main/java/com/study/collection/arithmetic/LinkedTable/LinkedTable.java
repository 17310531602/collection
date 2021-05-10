package com.study.collection.arithmetic.LinkedTable;

import lombok.Data;

/**
 * @author pcc
 * @version 1.0.0
 * @className LinkedTable
 * @date 2021-04-14 14:39
 */
@Data
public class LinkedTable {
    private Node head;

    public LinkedTable(){
        head = new Node();
    }

    //插入方法-尾插法
    public void insertTail(Object obj) throws Exception{
        if(null==obj)
            throw new Exception("数据无效");
        Node node = head;
        while(node.next!=null)
            node = node.next;
        node.next = new Node(obj);
    }

    //插入方法-头插法
    public void insertHead(Object obj) throws Exception{
        if(null==obj)
            throw new Exception("数据无效");
        if(head.next!=null)
            head.next = new Node(obj,head.next);
        head.next = new Node(obj);
    }

    //插入方法-根据下标i插入

    /**
     * 思路：
     * 1.确定obj是否有效
     * 2.确定i是否有效
     * 3.遍历链表，在指定位置插入，将当前元素的指针指向下一个元素，将前一个元素的指针指向当前元素。
     * @param obj
     * @param i
     */
    public void insert(Object obj ,int i) throws Exception{
        if(null==obj)
            throw new Exception("插入内容为空");
        if(i<0)
            throw new Exception("下标越界");
        Node node = head;
        int j=0;
        while(node.next!=null) {
            j++;
            if(i==j){
               node.next = new Node(obj,node.next);
               return;
            }
            node = node.next;
        }
        throw new Exception("不存在下标为i的数据元素");

    }

    //根据下标获取的方法

    /**
     * 思路：
     * 1.判断下标是否有效
     * 2.遍历链表，从0开始，找到下标为i的数据元素
     * @param i
     * @return
     */
    public Object get(int i) throws Exception{
        if(i<0)
            throw new Exception("下标越界");
        Node node = head;
        int j=0;
        while(node.next!=null){
            if(i==j)
                return node;
            node = node.next;
            j++;
        }
        throw new Exception("不存在i为下标的数据元素");
    }

    //清空方法

    /**
     * 思路：
     * 1.判断链表是否有效
     * 2.将头结点的指针域清空，就相当于清空了链表
     */
    public void clear(){
        if(head.next!=null)
            head.next=null;
    }

    //计算链表长度的方法

    /**
     * 思路：
     * 1.判断链表是否有效
     * 2.遍历链表，计算长度
     * @return
     */
    public int length(){
        Node node = head;
        int j=0;
        if(node.next!=null)
            while(node.next!=null){
                node = node.next;
                j++;
            }
        return j;
    }

    //判空
    public boolean isEmpty(){
        Node node = head;
        if(head.next!=null)
            return false;
        else
            return true;
    }
}
