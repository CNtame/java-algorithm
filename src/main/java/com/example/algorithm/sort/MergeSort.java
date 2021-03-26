package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liu
 * @version 1.0
 * @description 归并排序
 * @createDate 2020/12/29
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] data = getData();
        System.out.println(Arrays.toString(data));
        sorts(data);
        System.out.println(Arrays.toString(data));

    }

    public static int[] getData() {
        Scanner s = new Scanner(System.in);


        String transfer = s.next().trim();
        String data = transfer.substring(1, transfer.length()-1);
        s.close();
        return Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();

    }

    public static void sorts(int[] data) {
        circle(data, 0, data.length - 1);
    }

    public static void circle(int[] data, int start, int end) {
        if(start>=end) return;
        int mid = (end + start) / 2;
        circle(data, start, mid);
        circle(data, mid + 1, end);
        int[] copy = new int[end - start + 1];
        for (int i = 0; i < end - start + 1; i++) {
            copy[i] = data[i + start];
        }
        int preIndex = start;
        int lastIndex = mid+1;
        int index=start;
        while (index<=end) {
            if (preIndex > mid) {
                data[index++] = copy[lastIndex++ - start];
            } else if (lastIndex >end){
                data[index++] = copy[preIndex++ - start];
            } else if (copy[lastIndex - start] > copy[preIndex - start]) {
                data[index++] = copy[lastIndex++ - start];
            }else{
                data[index++] = copy[preIndex++ - start];
            }
        }

    }
}
