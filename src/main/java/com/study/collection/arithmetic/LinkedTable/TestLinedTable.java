package com.study.collection.arithmetic.LinkedTable;

import sun.rmi.runtime.NewThreadAction;

import java.util.LinkedList;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestLinedTable
 * @date 2021-04-14 16:50
 */
public class TestLinedTable {
    public static void main(String[] args) throws Exception{
        NoHeadLinkedTable linkedTable = new NoHeadLinkedTable();
        linkedTable.insert(0,"孙悟空");
        linkedTable.insert(1,"沙和尚");
        linkedTable.insert(2,"猪八戒");
        linkedTable.insertHead("唐僧");
        linkedTable.insertTail("白龙马");
        linkedTable.display();
        System.out.println(linkedTable.get(0));
        System.out.println(linkedTable.get(linkedTable.length()-1));
        System.out.println(linkedTable.get(2));
        linkedTable.remove(2);
        linkedTable.remove(0);
        linkedTable.remove(linkedTable.length()-1);
        linkedTable.display();
        System.out.println(linkedTable.indexOf("猪八戒"));
    }

    //删除链表中相同的元素:错误示范
    public static void deleteRepeat(NewLinkedTable linkedTable) throws Exception{
        if(linkedTable.isEmpty())
            throw new Exception("链表为空");
        //遍历删除
        for(int i=0;i<linkedTable.length();i++){
            for(int j=i+1;j<linkedTable.length();j++){
                if(linkedTable.get(i).equals(linkedTable.get(j))){
                    linkedTable.remove(j);
                }
            }
        }
    }

    //删除链表中相同的元素:正确示范
    public static void deleteRepeat2(NewLinkedTable linkedTable) throws Exception{
        if(linkedTable.isEmpty())
            throw new Exception("链表为空");
        //遍历删除
        for(int i=0;i<linkedTable.length();i++){
            for(int j=i+1;j<linkedTable.length();j++){
                if(linkedTable.get(i).equals(linkedTable.get(j))){
                    linkedTable.remove(j);
                    j--;
                }
            }
        }
    }

    //合并两个单链表，且原先两个个链表的节点都是按照非递减排列（递增）
    /**
     * 思路：
     * 核心思路：遍历两个链表，每次只将更小的值继续递归
     *
     * 为什么不使用返回：
     * 不使用返回，是因为操作的都是同一个堆中对象，在调用的地方，原对象就改变了
     * 无需返回再获取，原对象直接使用即可，写返回的话，仅仅是为了更好的理解而已
     * @param LA
     * @param LB
     */
    public static void merge(NewLinkedTable LA, NewLinkedTable LB){
        Node oneNode = LA.head.next;//获取LA的首结点
        Node twoNode = LB.head.next;//获取LB的首结点
        Node threeNode = LA.head;//准备用于拼接新的链表节点的头结点
        int valueOne,valueTwo;//定义两个边量，用于接收两个链表中数据元素的数据域
        while(oneNode!=null && twoNode!=null){//两个链表有一个遍历完成，立即退出循环，因为剩下的元素也是有序
            valueOne = Integer.valueOf(oneNode.object.toString());
            valueTwo = Integer.valueOf(twoNode.object.toString());
            if(valueOne<=valueTwo){//若是LA元素更小
                threeNode.next = oneNode;//将头结点指向当前元素
                threeNode = threeNode.next;//更新待拼接元素的节点位置，将其指向最新的节点，等待下一次拼接
                oneNode = oneNode.next;//当前元素已入新链表，将LA节点往下递归一位
            }else{
                threeNode.next = twoNode;
                threeNode = threeNode.next;
                twoNode = twoNode.next;
            }
        }
        threeNode.next = (oneNode.next!=null?oneNode:twoNode);//当退出循环是LA、LB必定有一个是非null的，拼接非null的数据元素及其以后的结点元素
    }



    //合并两个单链表：书中的解法
    public static NewLinkedTable mergeList(NewLinkedTable LA,NewLinkedTable LB){
        Node pa = LA.head.next;
        Node pb = LB.head.next;
        Node pc = LA.head;
        int da,db;
        while(pa != null && pb != null){
            da = Integer.valueOf(pa.object.toString());
            db = Integer.valueOf(pb.object.toString());
            if(da<=db){
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            }else{
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }

        pc.next = (pa != null?pa:pb);
        return LA;
    }

    //合并两个单链表
    public void mergeTwoLink(NewLinkedTable oneLink,NewLinkedTable twoLink){
        Node node = oneLink.head;
        for(int i=0;i<oneLink.length();i++){
            for(int j=0;j<twoLink.length();j++){

            }
        }
    }
}
