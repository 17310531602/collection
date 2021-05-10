package com.study.collection.arithmetic.job;

/**
 * @author pcc
 * @version 1.0.0
 * @className FinndNumber
 * @date 2021-04-22 14:28
 */
public class FinndNumber {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int getNumberCount(){

        int baiwei = 0;//百位
        int shiwei = 0;//十位
        int gewei = 0;//个位

        int count = 0;//统计总数量

        for(int i=100;i<1000;i++){
            baiwei = i/100;//百位的数字
            shiwei = (i-baiwei*100)/10;//十位的数字
            gewei = i-baiwei*100-shiwei*10;//个位的数字
            if(baiwei == gewei && shiwei%2!=0){//baiwei == gewei表示是对称数，shiwei%2!=0表示是奇数
                count++;
            }
        }
        return count;
    }
}
