package com.study.collection.arithmetic.queue;

/**
 * @author pcc
 * @version 1.0.0
 * @className LoopQueue
 * @date 2021-04-29 15:08
 */
public class LoopQueue implements IQueue {

    int front = 0;
    int rear = 0;

    Object[] objArray;

    public LoopQueue(int n){
        objArray = new Object[n];
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void offer(Object object) throws Exception {

    }

    @Override
    public Object poll() {
        return null;
    }
}
