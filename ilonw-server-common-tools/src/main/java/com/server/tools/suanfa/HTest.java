package com.server.tools.suanfa;

/**
 * 选择排序  复杂度O (n2)
 */
public class HTest {
    public void testHtest1(){
        Integer [] numList = {1,2,3,5,4,4,3,4,5,6,7,4,8,4,9,0,1};
        for (int i=0; i<numList.length-1;i++){
            int max = numList[i];
            for (int j = i+1; j <numList.length ; j++) {
                if(numList[i]<numList[j]){
                    max = numList[j];
                    numList[j] = numList[i];
                    numList[i] = max;
                }
            }
        }
        for (int num : numList){
            System.out.println(numList[num]);
        }
    }

    public static void main(String[] args){
        new HTest().testHtest1();
    }
}
