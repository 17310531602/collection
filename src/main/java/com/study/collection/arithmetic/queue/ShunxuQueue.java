package com.study.collection.arithmetic.queue;

import com.study.collection.arithmetic.stack.ShunxuStack;

/**
 *
 * 队列可以插入的一端被称为队尾，可以删除的一端被称为队列头，
 * 所以队列的典型特征就是队尾插入，队头删除
 *
 * 问题1：为什么rear指向的是队列尾部后一位，而不是队列尾部？
 * 因为rear==front是队列的初始状态，也是判空条件，若是指向最后一位那么
 * 当有一个元素时front==rear，此时判空会出问题，当然若要使非让rear指向最后一个元素
 * 也是可以的，只不过相对就会多出一些其他操作，不如指向尾部后一个元素来的简单。
 *
 * @author pcc
 * @version 1.0.0
 * @className ShunxuQueue
 * @date 2021-04-29 09:32
 */
public class ShunxuQueue implements IQueue{
    int front = 0;
    int rear = 0;

    Object[] objArray;

    public ShunxuQueue(int n){
        objArray = new Object[n];
    }


    @Override
    public void clear() {
        objArray = null;
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        return rear - front;
    }

    @Override
    public Object peek() {
        if(objArray!=null)
            return objArray[front];
        return null;
    }

    @Override
    public void offer(Object object) throws Exception{
        rear++;
        if(rear<=objArray.length)
            objArray[rear-1] = object;
        else
            throw new Exception("队列已满");

    }

    @Override
    public Object poll() {
        if(front!=rear){
            Object obj = objArray[front];
            front++;
            return obj;
        }
        return null;
    }
}
