package com.study.collection.arithmetic.queue;

import com.study.collection.arithmetic.stack.ShunxuStack;

/**
 *
 * 队列可以插入的一端被称为队尾，可以删除的一端被称为队列头
 *
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
