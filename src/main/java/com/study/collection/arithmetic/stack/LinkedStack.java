package com.study.collection.arithmetic.stack;

import com.study.collection.arithmetic.LinkedTable.Node;

/**
 *
 * @author pcc
 * @version 1.0.0
 * @className LinkedStack:该栈类，使用链式存储结构实现，是链栈，这里使用单链表的方式实现
 * @date 2021-04-20 16:32
 *
 * 栈的特点是先进后出：
 * 因此我们可以使用头插法，每次在头部插入，出栈时只需获取链表的头结点即可。
 *
 * 链栈与顺序栈的区别：
 * 顺序栈底层是数组，因此必须初始化一个数组的容量，也就是栈的容量，链栈则无需此操作
 * 对比链栈和顺序栈的实现，可以发现入栈和出战方法的时间复杂度都是O（1），效率上没有区别，但是顺序栈占用的空间会相对更多
 * 一些，顺序栈是通过指针指向假设的栈顶，其他元素其实依然存在，但链栈的栈顶之前的元素会被垃圾回收，因此链栈的实现综合时间和
 * 空间来看，更优秀一些。
 */
public class LinkedStack implements IStack {
    //这是首结点
    Node node;

    public LinkedStack(){
        node = new Node();
    }

    @Override
    public void clear() {
        node.next = null;
        node.object = null;
    }

    @Override
    public boolean isEmpty() {
        return node.object==null?true:false;
    }

    @Override
    public int length() {
        if(node.object==null)
            return 0;
        int j= 1;
        Node nodeNew = node;
        while(nodeNew.next!=null){
            j++;
            nodeNew = nodeNew.next;
        }
        return j;
    }

    @Override
    public Object peek() {
        return node.object;
    }

    @Override
    public void push(Object object) throws Exception {
        if(node.object==null){
            node.object = object;
            return;
        }
        //头插法
        node = new Node(object,node);
    }

    @Override
    public Object pop() {
        if(node.object==null)
            return null;
        Node tem = node;
        node = node.next==null?new Node():node.next;
        return tem.object;
    }
}
