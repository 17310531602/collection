package com.study.collection.arithmetic.queue;

public interface IQueue {
    void clear();
    boolean isEmpty();
    int length();
    Object peek();//查看队列头元素
    void offer(Object object) throws Exception;//入队
    Object poll();//出队
}
