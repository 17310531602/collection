package com.study.collection.arithmetic.stack;


import com.study.collection.util.StringUtil;

/**
 * @author pcc
 * @version 1.0.0
 * @className BigNumberAdd
 * @date 2021-04-26 09:43
 */
public class BigNumberAdd {
    public static void main(String[] args) throws Exception{
        System.out.println(add("123456789123456779","123456789123456779123"));
    }

    /**
     * 将两个字符串数字存入到不同的栈中
     * @param numberOne
     * @param numberTwo
     * @return
     * @throws Exception
     */
    public static String add(String numberOne,String numberTwo) throws  Exception{

        if(StringUtil.isEmpty(numberOne)||StringUtil.isEmpty(numberTwo))
            throw new Exception("输入内容不可为空");
        IStack linkedStackOne = new LinkedStack();
        IStack linkedStackTwo = new LinkedStack();
        //将两个字符串类型数据放入到栈中
        for(int i=0;i<numberOne.length();i++){
            linkedStackOne.push(String.valueOf(numberOne.charAt(i)));
        }
        for(int i=0;i<numberTwo.length();i++){
            linkedStackTwo.push(String.valueOf(numberTwo.charAt(i)));
        }
        //调用将两个栈中的数据进行相加，然后返回一个新的栈
        StringBuilder stringBuilder;
        if(linkedStackOne.length()<=linkedStackTwo.length()){
            //较小的先传入
            stringBuilder = popStack(linkedStackOne,linkedStackTwo);
        }else{
            //较小的先传入
            stringBuilder = popStack(linkedStackTwo,linkedStackOne);
        }

        return stringBuilder.toString();
    }

    /**
     * 将两个栈中的栈顶数据相加
     * 栈顶数据他的数据位置一定是一致的，这是可以使用栈来解决该问题的关键
     * @param statckOne
     * @param stackTwo
     * @return
     * @throws Exception
     */
    public static StringBuilder popStack(IStack statckOne,IStack stackTwo) throws Exception{
        IStack iStack = new LinkedStack();
        //谁小遍历谁即可，大的最后加上
        if(statckOne.length()<=stackTwo.length()){
            //标注是否需要进位
            Integer temp = 0;
            while(!statckOne.isEmpty()){
                if(!StringUtil.isEmpty((String)statckOne.peek())){
                    //深度较浅的栈有值
                    Integer intOne = new Integer((String)statckOne.pop());
                    Integer intTwo = new Integer((String)stackTwo.pop());
                    Integer intThree = new Integer(intOne+intTwo+temp);
                    if(intThree>9){
                        temp = 1;
                        iStack.push(String.valueOf(intThree%10));
                    }else{
                        temp = 0;
                    iStack.push(String.valueOf(intThree));
                    }

                }
            }
            //深度较浅的栈无值时，拼接较长的栈与新栈，这样就是相加后的数据
            //判断statckOne栈顶的数据相加后是否进位
            if(temp==1)
                if(!stackTwo.isEmpty()){
                    Integer intFour = new Integer((String)stackTwo.pop());
                    stackTwo.push(String.valueOf(intFour+1));
                    //拼接两个栈：stackTwo、iStack
                    return apend(stackTwo,iStack);
                }else{
                    //说明两个栈相等,进位1直接放进最高位
                    iStack.push(String.valueOf(1));
                    return apend(null,iStack);

                }
            else
                return apend(stackTwo,iStack);
        }else{
            //该部分与上面逻辑相同，无差别，只是将两个数组调换位置
            return null;
        }
    }

    /**
     * 传入的两个栈计算完成后的两个栈。
     * 将两个栈中的数据元素拼接成一个新的字符串
     * @param stackOne
     * @param stackTwo
     * @return
     */
    public static StringBuilder apend(IStack stackOne,IStack stackTwo) throws Exception{

        StringBuilder stringBuilder = new StringBuilder();
        //将stackOne 中剩余的元素加入到stackTwo中
        while(null != stackOne && !stackOne.isEmpty())
            stackTwo.push(stackOne.pop());
        while(null != stackTwo && !stackTwo.isEmpty())
            stringBuilder.append(stackTwo.pop());
        return stringBuilder;
    }
}
