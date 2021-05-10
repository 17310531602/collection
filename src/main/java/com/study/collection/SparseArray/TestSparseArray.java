package com.study.collection.SparseArray;

import java.util.Arrays;

/**
 * @author pcc
 * @version 1.0.0
 * @className TestSparseArray
 * @date 2021-04-09 16:59
 */
public class TestSparseArray {
    //因为使用lamdba，需要将其定义为类变量
    //二维数组有效数据个数
    static int countValid = 0;

    public static void main(String[] args) {
        int[][] firstArray = new int[10][10];
        firstArray[3][4] = 1;
        firstArray[0][6] = 1;
        firstArray[2][3] = 1;
        printArray(firstArray);
        System.out.println("***********************************************************");

        //调用二维数组转稀疏数组方法
        int[][] sparseArray = changeTwoDimensionToSparseArray(firstArray);
        printArray(sparseArray);
        System.out.println("***********************************************************");

        //调用稀疏数组转二维数组方法
        int[][] twoDimensionArray = changeSparseArrayToTwoDimension(sparseArray);
        printArray(twoDimensionArray);
    }

    //打印二维数组
    public static void  printArray(int[][] thisArray){
        Arrays.stream(thisArray).forEach(intArray ->{
            Arrays.stream(intArray).forEach( intValue ->{
                System.out.print(intValue);
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
    public static  int[][] changeTwoDimensionToSparseArray(int[][] twoDimensionArray){
        //判断数组是否有效
        if(twoDimensionArray.length>0 && twoDimensionArray[0].length>0){
            //通过一次遍历获取到所有有效数据
            Arrays.stream(twoDimensionArray).forEach(intArray ->{
                Arrays.stream(intArray).forEach(intNum ->{
                    if(intNum!=0){
                        countValid++;
                    }
                });
            });
            //创建稀疏数组,并将第一列值创建出来分别是：二维数组行数、列数、有效数据个数
            int[][] newSparseArray = new int[countValid+1][3];
            newSparseArray[0][0]=twoDimensionArray.length;
            newSparseArray[0][1]=twoDimensionArray[0].length;
            newSparseArray[0][2]=countValid;
            //定义稀疏数组行初始值
            int line = 1;

            //遍历二维数组，将有效数据传入到稀疏数组中
            for(int i=0;i<twoDimensionArray.length;i++){
                for(int j=0;j<twoDimensionArray[i].length;j++){
                    if(twoDimensionArray[i][j]!=0){
                        newSparseArray[line][0]=i;
                        newSparseArray[line][1]=j;
                        newSparseArray[line][2]=twoDimensionArray[i][j];
                        line++;
                    }
                }
            }
            return newSparseArray;
        }
        return null;
    }

    /**
     * 稀疏数组转变为二维数组
     * 实现逻辑：
     *      1.根据稀稀数组第一行的信息，创建二维数组。
     *      2.遍历二维数组，将信息取出，放入到二维数组中。
     *      3.返回二维数组
     * @param sparseArray
     * @return
     */
    public static int[][] changeSparseArrayToTwoDimension(int[][] sparseArray){
        //判断稀疏数组是否有效
        if(sparseArray.length>0 && sparseArray[0].length>0){
            //根据二维数组创建稀疏数组
            int[][] twoDimensionArray = new int[sparseArray[0][0]][sparseArray[0][1]];
            //遍历稀疏数组，将有效数据取出，存入到二维数组
            for(int i=0;i<sparseArray.length;i++){
                //第一行非有效数据，不取
                if(i>0){
                    //二维数组有效元素的行数是，i行0列，二维数组的列数是i行1列，二维数组有效元素值是i行2列
                    twoDimensionArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
                }
            }
            return twoDimensionArray;
        }
        return null;
    }
}
