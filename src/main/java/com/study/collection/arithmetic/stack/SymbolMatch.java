package com.study.collection.arithmetic.stack;

/**
 * @author pcc
 * @version 1.0.0
 * @className SymbolMatch
 * @date 2021-04-23 16:49
 */
public class SymbolMatch {
    public static void main(String[] args) throws Exception{
        System.out.println(symbolIfMatch("/**/(){}[]"));
    }

    public static boolean symbolIfMatch(String str) throws Exception{
        LinkedStack linkedStack = new LinkedStack();
        char[] strArray = str.toCharArray();
        for(int i=0;i<strArray.length;i++){
            String strnew = String.valueOf(strArray[i]);
            String strnewNext = "";
            if(i<strArray.length-1)
                strnewNext = String.valueOf(strArray[i])+String.valueOf(strArray[i+1]);
            if(strnew.equals("(")  ||strnew.equals("[") ||strnew.equals("{")){
                linkedStack.push(strnew);
            }
            //单独处理该场景
            if(strnewNext.equals("/*")){
                linkedStack.push(strnewNext);
            }

            if(strnew.equals(")") ||strnew.equals("]") || strnew.equals("}")){
                if(evaluateMatch(String.valueOf(linkedStack.peek()),strnew)){
                    //匹配成功出栈
                    linkedStack.pop();
                }else{
                    return false;
                }
            }
            //单独处理该场景
            if(strnewNext.equals("*/")){
                if(evaluateMatch(String.valueOf(linkedStack.peek()),strnewNext)){
                    //匹配成功出栈
                    linkedStack.pop();
                }else{
                    return false;
                }
            }
        }
        if(linkedStack.length()==0)
            return true;
        return false;
    }

    public static boolean evaluateMatch(String one,String two){
        if(one.equals("(") && two.equals(")")){
            return true;
        }
        if(one.equals("[") && two.equals("]")){
            return true;
        }
        if(one.equals("{") && two.equals("}")){
            return true;
        }
        if(one.equals("/*") && two.equals("*/")){
            return true;
        }
        return false;
    }
}
