package com.study.collection.arithmetic.ShunxuTable;

import java.util.Arrays;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestShunxuTable
 * @date 2021-04-13 14:50
 */
public class TestShunxuTable {

    private Object[] objectArray;
    private int length;

    //提供一个构造函数
    public TestShunxuTable(int length){
        objectArray = new Object[length];
    }

    //清空
    public void clear(){
        Arrays.stream(objectArray).forEach(obj ->obj=null);
        length = 0;
    }
    //判空
    public boolean isEmptry(){
        if (length==0)
            return true;
        else
            return false;
    }

    //判满
    public boolean isFull(){
        if(length==objectArray.length)
            return true;
        return false;
    }
    //长度
    public int length(){
        return this.length;
    }
    //根据下标获取
    public Object get(int i) throws Exception{
        if(i<0 || i>length-1)
            throw new Exception("下标越界");
        return objectArray[i];
    }
    //插入

    /**
     * 1.判断是否已满
     * 2.判断i是否有效
     * 3.在指定位置进行插入:插入位置的后方所有元素向后移动一位
     * 4.对length+1
     * @param obj
     * @param i
     */
    public void insert(Object obj,int i) throws Exception{
        boolean flag=false;
        if(isFull())
            throw new Exception("已满");
        if(isEmptry()){
            length++;
            objectArray[0]=obj;
            return;
        }
        if(1<=i && i<=objectArray.length)
            length++;
            for(int j=length-1;j>i;j--){
                objectArray[j]=objectArray[j-1];
            }
            objectArray[i] = obj;
    }
    //删除
    /**
     * 1.判断是否为空
     * 2.判断i是否有效
     * 3.将指定位置元素删除，并将指定位置后方所有元素前移1位
     * 4.length-1
     * @param i
     */
    public void remove(int i) throws Exception{
        if(isEmptry())
            throw new Exception("表为空");
        if(0<=i && i<length-1)
            for(int j=i;j<length-1;j++)
                objectArray[j]=objectArray[j+1];
            objectArray[length-1]=null;
            length--;
    }

    //获取第一次出现某值的下标

    /**
     * 1.判断obj是否有效
     * 2.判断表是否有值
     * 3.遍历表查询是否有obj，有返回下标，无返回-1
     * @param obj
     * @return
     */
    public int indexOf(Object obj){
        if(null != obj)
            if(length>0)
                for(int i=0;i<length;i++)
                    if(objectArray[i].equals(obj))
                        return i;
        return -1;
    }
}
