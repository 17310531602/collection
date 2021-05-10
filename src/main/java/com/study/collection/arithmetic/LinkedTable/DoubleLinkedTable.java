package com.study.collection.arithmetic.LinkedTable;

/**
 * @author pcc
 * @version 1.0.0
 * @className DoubleLinkedTable
 * @date 2021-04-19 16:48
 */
public class DoubleLinkedTable {
    //头结点
    DupNode head;

    public DoubleLinkedTable(){
        head = new DupNode();
        head.prior = head;
        head.next = head;
    }

    //根据下标插入:寻找下标为i-1的元素(书上思路是寻找i+1位置元素，原理一样)

    /**
     * 思路：
     * 1.寻找下标为i-1的数据元素，注意退出循环的条件应该是node！=head
     * 2.赋值即可，循环链表的核心就是空表也会有循环体系
     * 3，赋值时，i+1位置的元素应该是node.next 所以，应为node.next最后赋值
     * @param i
     * @param object
     * @throws Exception
     */
    public void insert(int i,Object object) throws Exception{
        if(i<0 || i>length())
            throw new Exception("下标不合法");
         DupNode node = head;
         int j = 0;
         while(!node.next.equals(head) && j<i){
             j++;
             node = node.next;
         }
//         DupNode newNode = new DupNode(object);
//         node.next.prior = newNode;
//         newNode.prior = node;
//         newNode.next = node.next;
//         node.next = newNode;

        //写成以下这种和上面注释的部分，效果一样，无区别
         DupNode newNode = new DupNode(object,node,node.next);
         node.next.prior = newNode;
         node.next = newNode;
    }

    //删除
    public void remove(int i) throws Exception{
        if(i<0 || i>length()-1)
            throw new Exception("下标不合法");
        DupNode node = head;
        int j = 0;
        while(!node.next.equals(head) && j<i){
            j++;
            node = node.next;
        }
        node.next = node.next.next;
        node.next.prior = node;
    }

    //根据下标获取
    public Object get(int i) throws Exception{
        return getNode(i).object;
    }

    //根据下标获取其前一个元素
    public Object getPrior(int i) throws Exception{
        return getNode(i).prior.object;
    }

    //根据下标获取其后一个元素
    public Object getNext(int i) throws Exception{
        return getNode(i).next.object;
    }

    public DupNode getNode(int i) throws Exception{
        if(i<0 || i>length())
            throw new Exception("下标不合法");
        DupNode node = head.next;
        int j =0;
        while(!node.equals(head) && j<i){
            j++;
            node = node.next;
        }
        return node;
    }

    //长度
    public int length(){
        DupNode node = head.next;
        int j = 0;
        while(!node.equals(head)){
            j++;
            node = node.next;
        }
        return j;
    }

    //打印
    public void display(){
        DupNode node = head.next;
        while(!node.equals(head)){
            System.out.println(node.object);
            node = node.next;
        }
    }
    //清空
    public void clear(){
        head.next = head;
        head.prior = head;
    }
}
