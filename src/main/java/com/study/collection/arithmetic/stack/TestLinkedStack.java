package com.study.collection.arithmetic.stack;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestLinkedStack
 * @date 2021-04-20 16:47
 */
public class TestLinkedStack {
    public static void main(String[] args) throws Exception{
        IStack iStack = new LinkedStack();
        iStack.push("李四1");
        iStack.push("李四2");
        iStack.push("李四3");
        iStack.push("李四4");
        iStack.push("李四5");
        System.out.println(iStack.isEmpty());
        System.out.println(iStack.length());
        System.out.println(iStack.peek());
        while(!iStack.isEmpty())
            System.out.println(iStack.pop());
    }
}
