package com.study.collection.arithmetic.LinkedTable;

/**
 * 这是不带头结点的单链表
 * 说明：带头结点的标志是，第一个结点(头结点)只存储指向下一个节点的指针，其数据域为空
 *       此处的firstNode是首结点，他的数据域和指针域都是可以存储数据的。
 * @author pcc
 * @version 1.0.0
 * @className NoHeadLinkedTable
 * @date 2021-04-15 15:31
 */
public class NoHeadLinkedTable {
    private Node firstNode;


    /**
     *
     * @param i 下标
     * @param object 待存储对象
     */
    public void insert(int i,Object object) throws Exception{
        if(i<0 || i>length())
            throw new Exception("下标不合法");

        if(null == object)
            throw new Exception("数据不可为空");
        //不使用头结点时，首结点特殊处理，使用头结点的意义就是方便处理
        //从这里也可以看到，不使用头结点，需要单独处理首结点的数据
        if(i==0)
            if(length()==0){
                firstNode = new Node(object);
                return;
            }else{
                firstNode = new Node(object,firstNode);
                return;
            }
        Node node = firstNode;
        int j = 0;
        while(node.next !=null && j<i-1) {
            j++;
            node = node.next;
        }
        node.next = new Node(object,node.next);
    }
    //头部插入
    public void insertHead(Object object) throws Exception{
        firstNode = new Node(object,firstNode);
    }
    //尾部插入
    public void insertTail(Object object) throws Exception{
        if(length()==0)
            firstNode = new Node(object);
        else{
            Node node = firstNode;
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node(object);
        }
    }

    //根据下标获取方法
    public Object get(int i) throws Exception{
        if(i<0 || i>length()-1)
            throw new Exception("下标不合法");
        if(length() == 0)
            throw new Exception("链表为空");
        //单独处理首结点情况
        if(i==0)
            return firstNode.object;
        Node node = firstNode;
        int j =0;
        while(node.next != null && j < i){
            j++;
            node = node.next;
        }
        return node.object;
    }

    //根据下标删除方法
    public void remove(int i) throws Exception{
        if(i<0 || i>length()-1)
            throw new Exception("下标不合法");
        if(length() == 0)
            throw  new Exception("链表为空");
        //特殊处理i为0的时候。
        if(i==0){
            firstNode = firstNode.next;
            return;
        }
        //遍历时，与带有头结点的链表不同的是，无头结点的链表
        Node node = firstNode;
        int j = 0;
        while(node.next != null && j< i-1){
            j++;
            node =node.next;
        }
        //找到的是下标为i-1的元素
         node.next = node.next.next;
    }

    //获取某元素第一次出现的下标
    public int indexOf(Object object) throws Exception{
        if(object==null)
            throw new Exception("数据不合法");
        if(length() == 0)
            throw new Exception("链表为空");
        Node node = firstNode;
        int j = 0;
        //这里找的是当前元素下标，插入、删除都是获取的i-1的下标
        //区别是获取当前元素时，我们应该判断的是node！=null，获取i-1时，我们
        //应该判断node.next != null。
        while(node!=null ){
            if(node.object.equals(object))
                return j;
            j++;
            node = node.next;
        }
        return -1;
    }

    //判空
    public boolean isEmpty(){
        return firstNode.object==null;
    }

    //链表长度
    public int length(){
        if(firstNode!=null){
            Node node = firstNode;
            int i = 0;
            while(node!=null){
                i++;
                node = node.next;
            }
            return i;
        }
        else
                return 0;
    }


    //输出链表
    public void display(){
        if(firstNode!=null){
            Node node = firstNode;
            while(node != null){
                System.out.println("结点："+node.object);
                node = node.next;
            }
        }

    }
    //清空链表
    public void clear(){
        if (firstNode!=null){
            firstNode.object = null;firstNode.next=null;
        }
    }

}
