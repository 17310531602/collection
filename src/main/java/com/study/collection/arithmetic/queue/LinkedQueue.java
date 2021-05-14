package com.study.collection.arithmetic.queue;

import com.study.collection.arithmetic.LinkedTable.Node;

/**
 * 链式队列就相当于，既含有首结点，也含有尾结点的单链表
 * @author pcc
 * @version 1.0.0
 * @className LinkedQueue
 * @date 2021-04-29 09:55
 */
public class LinkedQueue implements IQueue{
    Node front;//首结点
    Node rear;//尾结点

    public LinkedQueue(){
        front = rear  = new Node();
    }

    @Override
    public void clear() {
        front = rear  = new Node();

    }

    @Override
    public boolean isEmpty() {
        if(front == rear && front.object == null)
            return true;
        return false;
    }

    @Override
    public int length() {
        int length = 0;
        Node temp = front;
        if(front!=rear)
            while(temp!=null){
                length++;
                temp = temp.next;
            }
        return length;
    }

    @Override
    public Object peek() {
        return front!=null?front.object:null;
    }

    @Override
    public void offer(Object object) throws Exception {
        Node temp = new Node(object,null);
        if(rear.object==null)
            rear = front = temp;
        else{
            rear.next = temp;//尾部插入
            rear = temp;
        }

    }

    @Override
    public Object poll() {
        if(front!=null){

            Node frontTemp = front;
            if(front==rear){//只有一个元素时出队
                front = rear = new Node();
            }else{//其他场景出队
                front = front.next;
            }
            return frontTemp.object;
        }


        return null;
    }
}
