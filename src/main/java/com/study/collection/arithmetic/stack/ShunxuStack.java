package com.study.collection.arithmetic.stack;

import java.beans.Expression;
import java.util.Arrays;

/**
 *
 * @author pcc
 * @version 1.0.0
 * @className ShunxuStack:这是一种顺序栈，使用顺序存储结构来实现的栈
 * @date 2021-04-20 16:08
 */
public class ShunxuStack implements IStack {

    Object[] objArray;
    int top = -1;//指向栈顶元素所在下标

    public ShunxuStack(int i){
        objArray = new Object[i];
    }

    @Override
    public void clear() {
        Arrays.stream(objArray).forEach(obj ->obj=null);
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1?true:false;
    }

    @Override
    public int length() {
        return top+1;
    }

    @Override
    public Object peek() {
        if(isEmpty())
            return null;
        return objArray[top];
    }

    @Override
    public void push(Object object) throws Exception{
        if(top>=objArray.length-1)
            throw new Exception("StackOverFlowError");
        top++;
        objArray[top] = object;
    }

    @Override
    public Object pop() {
        if(isEmpty())
            return null;
        top--;
        return objArray[top+1];
    }
}
