package com.study.collection.arithmetic.LinkedTable;

/**
 * @author pcc
 * @version 1.0.0
 * @className Node
 * @date 2021-04-14 14:35
 */
public class Node {
    public Object object;
    public Node next;

    public Node(){
    }
    public Node(Object object){
        this.object = object;
    }
    public Node(Node next){
        this.next = next;
    }
    public Node(Object object,Node next){
        this.object = object;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "object=" + object +
                ", next=" + next +
                '}';
    }
}
