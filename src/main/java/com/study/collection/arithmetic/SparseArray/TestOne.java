package com.study.collection.arithmetic.SparseArray;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestOne
 * @date 2021-04-12 16:56
 */
public class TestOne {
    public static void main(String[] args) {
        int[] a = {3,2,3,8,23,19,7,5};
        a = getReverseArrayTwo(a);
        Arrays.stream(a).forEach(intParam -> {
            System.out.print(intParam+",");
        });
    }

    //方式一

    /**
     * 思路：使用一个数组做中间变量，存储倒叙的a数组
     * @param a
     * @return
     */
    public static int[] getReverseArray(int[] a){
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++){
            b[b.length-1-i] = a[i];
        }
        for(int i=0;i<a.length;i++){
            a[i]=b[i];
        }
        return a;
    }


    //方式二

    /**
     * 思路：逆置，那就交换首尾的元素。
     * @param a
     * @return
     */
    public static int[] getReverseArrayTwo(int[] a){
        int tem = 0;
        for(int i=0;i<a.length;i++){
            if(i<a.length-1-i){
                tem = a[i];
                a[i] = a[a.length-1-i];
                a[a.length-1-i]=tem;
            }
        }
        return a;
    }

    //方式三
    /**
     * 思路：通过对方式二的修改得来，无需控制次数，知道数组的长度，知道起始下标，那么我们就可以
     *       正续倒续一起查找，然后交换，这样当查找到同样的元素就代表已经交换完了。
     * @param a
     * @return
     */
    public static int[] getReverseArrayThree(int[] a){
        int tem = 0;
        for(int i=0,j=a.length-1;i<j;i++,j--){
            tem = a[i];
            a[i] = a[j];
            a[j] = tem;
        }
        return a;
    }
}
