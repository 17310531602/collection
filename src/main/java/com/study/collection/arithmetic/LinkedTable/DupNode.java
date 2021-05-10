package com.study.collection.arithmetic.LinkedTable;

/**
 * @author pcc
 * @version 1.0.0
 * @className DupNode
 * @date 2021-04-19 16:43
 * 该类是双向链表的结点类
 * 该类包含了数据域，后继指针域、前驱指针域三个属性。
 */
public class DupNode {
    Object object;
    DupNode prior;//前驱指针域
    DupNode next;//后继指针域

    public DupNode(){
        this(null);
    }
    public DupNode(Object object){
        this(object,null,null);
    }
    public DupNode(Object object,DupNode prior,DupNode next){
        this.object = object;
        this.prior = prior;
        this.next = next;
    }
}
