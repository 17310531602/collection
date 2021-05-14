package com.study.collection.arithmetic.sqequeenceString;

/**
 * @author pcc
 * @version 1.0.0
 * @className StringBruteForce
 * @date 2021-05-13 15:01
 */
public class StringBruteForce {
    public static void main(String[] args) {
        String strMain = "abcabcdabcde1bcdeabcadef2";
        String strSub = "abcde1";
        System.out.println(strMain.indexOf(strSub));
    }
}
