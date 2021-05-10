package com.study.collection.arithmetic.stack;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestShunxuStack
 * @date 2021-04-20 16:25
 */
public class TestShunxuStack {
    public static void main(String[] args) throws Exception{
        ArrayList arrayList = new ArrayList();
        arrayList.get(3);
        IStack iStack = new LinkedStack();
        iStack.push("李四1");
        iStack.push("李四2");
        iStack.push("李四3");
        iStack.push("李四4");
        iStack.push("李四5");

//        while(!iStack.isEmpty())
//            System.out.println(iStack.pop());
        System.out.println("栈顶元素："+iStack.peek());
        System.out.println("栈深度："+iStack.length());
        iStack.clear();
        System.out.println("栈深度："+iStack.length());

    }
}
