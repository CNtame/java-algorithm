package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liu
 * @version 1.0
 * @description 快速排序
 * @createDate 2020/12/29
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] data = acceptData();
        System.out.println("原数据：" + Arrays.toString(data));
        sort2(data, 0, data.length - 1);
        System.out.println("排序后数据：" + Arrays.toString(data));
    }

    /**
     * 接收数据
     */
    public static  int[] acceptData() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next().trim();
        scanner.close();
        return Arrays.stream(data.substring(1, data.length() - 1).split(","))
                .mapToInt(Integer::valueOf).toArray();

    }

    /**
     * 快速排序
     */
    public static void  sorts(int[] data){
        circle(data, 0, data.length - 1);
    }

    public static void circle(int[] data, int begin, int end) {
        if(end<=begin) return;

        int pre = begin + 1;
        int next = end;
        int temp = data[begin];
        while (pre < next) {
            //small
            while (next > begin && data[next] > temp) {
                next--;
            }
            if(next<=begin){
                next=begin;
                break;
            }
            //big
            while(pre<=end&&data[pre]<temp){
                pre++;
            }
            if(pre>end) break;

            //
            if(pre<next){
                int temp1 = data[next];
                data[next] = data[pre];
                data[pre] = temp1;
            }
        }
        //
        data[begin] = data[next];
        data[next] = temp;

        circle(data, begin, next-1);
        circle(data, next + 1, end);
    }

    public static void sort2(int[] data,int begin,int end) {
        if(begin>=end) return;
        int mid = circle2(data, begin, end);
        sort2(data, begin, mid - 1);
        sort2(data, mid + 1, end);
    }

    public static int circle2(int[] data, int begin, int end) {
        //指针位置？
        int pre=begin;
        int next = end+1;
        int basic = data[begin];
        while (true) {
            //small？
            while(data[--next]>basic){
                if(next==begin) break;
            }
            //big？
            while(data[++pre]<basic){
                if(pre==end) break;
            }
            //结束？
            if(pre>=next) break;
            int temp = data[pre];
            data[pre] = data[next];
            data[next] = temp;
        }
        //?
        data[begin] = data[next];
        data[next] = basic;
        return next;
    }


}
