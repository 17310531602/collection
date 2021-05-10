package com.study.collection.SparseArray;

import java.util.Arrays;

/**
 * @author pcc
 * @version 1.0.0
 * @className StoreHair
 * @date 2021-04-09 20:41
 */
public class StoreHair {
    //有效数据的个数
    public static int countValid=0;
    public static void main(String[] args) {
        //定义一个4行4列的二维数组，将我的头发存入到对角线的节点中
        String[][] twoDimensionArray = new String[4][4];
        twoDimensionArray[0][0] = "我";
        twoDimensionArray[1][1] = "的";
        twoDimensionArray[2][2] = "头";
        twoDimensionArray[3][3] = "发";
        printArray(twoDimensionArray);
        System.out.println("*****************************************");
        String[][] sparseArray =  changeTwoDimensionToSparseArray(twoDimensionArray);
        printArray(sparseArray);
    }

    //打印二维数组
    public static void  printArray(String[][] thisArray){
        Arrays.stream(thisArray).forEach(intArray ->{
            Arrays.stream(intArray).forEach( intValue ->{
                System.out.print("\t"+intValue);
            });
            System.out.println();
        });
    }


    /**
     * 将二维数组转变为稀疏数组sparsearray
     * 实现思路：
     *      1.首先确定二维数组中有效数据的个数，用以得到稀疏数组的行数：二维数组有效数据个数+1
     *      2.将二维数组中有效数据，存入到稀疏数组中
     *      3.返回稀疏数组
     * @param twoDimensionArray
     * @return
     */
    public static  String[][] changeTwoDimensionToSparseArray(String[][] twoDimensionArray){
        //判断数组是否有效
        if(twoDimensionArray.length>0 && twoDimensionArray[0].length>0){
            //通过一次遍历获取到所有有效数据
            Arrays.stream(twoDimensionArray).forEach(strArray ->{
                Arrays.stream(strArray).forEach(str ->{
                    if(str != null && str!=""){
                        countValid++;
                    }
                });
            });
            //创建稀疏数组,并将第一列值创建出来分别是：二维数组行数、列数、有效数据个数
            String[][] newSparseArray = new String[countValid+1][3];
            newSparseArray[0][0]=new Integer(twoDimensionArray.length).toString();
            newSparseArray[0][1]=new Integer(twoDimensionArray[0].length).toString();
            newSparseArray[0][2]=new Integer(countValid).toString();
            //定义稀疏数组行初始值
            int line = 1;

            //遍历二维数组，将有效数据传入到稀疏数组中
            for(int i=0;i<twoDimensionArray.length;i++){
                for(int j=0;j<twoDimensionArray[i].length;j++){
                    if(twoDimensionArray[i][j]!=null && twoDimensionArray[i][j]!=""){
                        newSparseArray[line][0]=new Integer(i).toString();
                        newSparseArray[line][1]=new Integer(j).toString();
                        newSparseArray[line][2]=twoDimensionArray[i][j];
                        line++;
                    }
                }
            }
            return newSparseArray;
        }
        return null;
    }
}
