package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author liu
 * @version 1.0
 * @description 堆排序
 * @createDate 2020/12/29
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] data = new int[]{1, 212312, 21312, 354, 562, 34};
        create(data);
        System.out.println(Arrays.toString(data));
        int length = data.length;
        while (length > 0) {
            swap(data, 0, length - 1);
            length--;
            just(data, 0, length);
        }
        System.out.println(Arrays.toString(data));

    }


    /**
     * 创建大根堆
     * 子 - 其父节点一定要大于子节点
     * 时间复杂度：n*logn
     * fu: (i-1)/2
     * zi: i*2+1   、i*2+2
     */
    public static void create(int[] data){
        for (int i = 0; i < data.length; i++) {

            int cur = i;
            int p = (i - 1) / 2;
            while (data[cur] > data[p]) {
                swap(data, cur, p);
                cur = p;
                p = (p - 1) / 2;
            }
        }
    }

    public static void just(int[] data,int start,int end){
        int left = start * 2 + 1;
        int right = start * 2 + 2;

        while (left < end) {
            //
            int maxIndex ;
            if(data[left]<data[right]&& right < end){
                maxIndex = right;
            } else maxIndex = left;

            if(data[maxIndex]<data[start]){
                break;
            }
            swap(data, maxIndex, start);
            start = maxIndex;
            left = start * 2 + 1;
            right = start * 2 + 2;
        }
    }

    /**
     * 构建大堆根
     *
     * @param data
     */
    public static void create2(int[] data) {
        int length = data.length;
        for (int i = length / 2 - 1; i >= 0; i--) {

        }
    }



    public static void swap(int[] data,int pre,int next){
        int temp = data[pre];
        data[pre] = data[next];
        data[next] = temp;
    }

}
