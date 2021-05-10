package com.study.collection.arithmetic.LinkedTable;

/**
 * 说明
 * 这是带头结点的单链表
 * 且默认首结点（第一个存储数据元素的结点是首结点）的下标时0
 * 注意:头结点默认是不计算在内的。
 * 注意：该实现不支持结点存储null值。
 * @author pcc
 * @version 1.0.0
 * @className NewLinkedTable
 * @date 2021-04-15 10:49
 */
public class NewLinkedTable {
    public Node head;

    //提供一个构造器
    public NewLinkedTable(){
        head = new Node();
    }

    //提供插入方法：根据下标插入
    /**
     * 思路：
     * 1.寻找i位置的前一个数据元素，若是找不到则说明i输入有误（）
     * 2.在指定位置插入object
     * @param i
     * @param object
     */
    public void insert(int i,Object object) throws Exception{
        if(i<0 || i>length() ||object==null)
            throw new Exception("下标或者值无效");
       Node node = head;
       int j = 0;
       while(node.next!=null && j<i){
           node = node.next;
            j++;
       }
       node.next = new Node(object,node.next);
    }

    //提供插入方法：在头部插入
    public void insertHead(Object object) throws Exception{
        insert(0,object);
    }

    //提供插入方法：在尾部插入
    public void insertTail(Object object) throws Exception{
        insert(length(),object);
    }

    //根据下标获取元素
    /**
     * 思路：
     * 1.遍历链表，直到第i+1个元素（第i+1个元素下标是i）
     * @param i
     * @return
     */
    public Object get(int i) throws Exception{
        if(i>length()-1 || i<0 || isEmpty())
            throw new Exception("i无效");
        Node node = head;
        int j=0;
        while(node.next!=null && j<i){
            j++;
            node = node.next;
        }
        if(j<i)
            throw new Exception("i无效");
        return node.next.object;
    }

    //根据下标删除
    /**
     * 思路：
     * 1.判断i是否有效
     * 2.找到下标为i的数据元素，将其删除
     * 3.删除策略是：将下标为i-1的数据元素的指针域指向下标为i+1的Node对象。
     * @param i
     */
    public void remove(int i) throws Exception{
        if(i<0 ||  i >length()-1 || isEmpty())
            throw new Exception("i无效");
        Node node = head;
        int j = 0;
        while(node.next!=null && j<i){
            j++;
            node = node.next;
        }
        node.next = node.next.next;
    }

    //清空链表方法
    public void clear(){
        head.next = null;
    }

    //判空
    public boolean isEmpty(){
        return head.next==null;
    }

    //获取某元素第一次出现的下标
    public int indexOf(Object object){
        if(object == null || isEmpty())
            return -1;
        Node node = head;
        int i = 0;
        while(node.next!=null && !node.next.object.equals(object)){
            i++;
            node = node.next;
        }
        if(i==length())
            return -1;
        return i;
    }

    //提供获取链表长度方法
    public int length(){
        Node node = head;
        int i=0;
        while(node.next!=null){
            i++;
            node = node.next;
        }
        return i;
    }

    public void display(){
        Node node = head;
        while(node.next!=null){
            node = node.next;
            System.out.println("node："+node.object);
        }
    }

}
