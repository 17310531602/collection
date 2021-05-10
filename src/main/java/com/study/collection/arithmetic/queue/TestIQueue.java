package com.study.collection.arithmetic.queue;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestIQueue
 * @date 2021-04-29 09:46
 */
public class TestIQueue {
    public static void main(String[] args) throws Exception{
        IQueue iQueue = new LinkedQueue();
        iQueue.offer("张三");
        iQueue.offer("李四");
        iQueue.offer("王五");
        iQueue.offer("赵柳");
        iQueue.offer("李琦");
        System.out.println(iQueue.length());

        while(!iQueue.isEmpty())
            System.out.println(iQueue.poll());
        System.out.println(iQueue.isEmpty());
        System.out.println(iQueue.length());
        System.out.println(iQueue.peek());

    }
}
