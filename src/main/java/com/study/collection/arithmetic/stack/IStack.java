package com.study.collection.arithmetic.stack;

/**
 * 该接口是：栈的顶层接口
 * 他的实现类会有：顺序栈、链栈
 *
 * 栈：先入后出
 */
public interface IStack {
    void clear();//清空方法
    boolean isEmpty();//判空方法
    int length();//栈深度方法
    Object peek();//取栈顶元素并返回值，若栈为空，返回null
    void push(Object object) throws Exception;//入栈操作,元素进入栈顶
    Object pop();//将栈顶元素出站
}
