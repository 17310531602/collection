package com.study.collection.arithmetic.stack;

import java.time.chrono.IsoChronology;

/**
 * @author pcc
 * @version 1.0.0
 * @className Hanoi
 * @date 2021-04-26 16:23
 */
public class Hanoi {
    public static void main(String[] args) throws Exception{
        implHanoi(5,'x','y','z');
    }

    //递归实现
    public static int implHanoi( int n,char x,char y,char z) throws Exception{
        if(n==1){
            move(x,1,z);
        }else{
            implHanoi(n-1,x,z,y);
            move(x,n,z);
            implHanoi(n-1,y,x,z);
        }

        return 11;
    }
    public static void move(char x, int n, char z){
        System.out.println("移动"+n+"号圆盘");
    }
}
