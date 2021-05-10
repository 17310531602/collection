package com.study.collection.util;

/**
 * @author pcc
 * @version 1.0.0
 * @className StringUtil
 * @date 2021-04-26 09:47
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(str==null || str.trim().length() ==0 || str.equals(""))
            return true;
        return false;

    }
}
