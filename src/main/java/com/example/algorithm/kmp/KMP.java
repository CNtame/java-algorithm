package com.example.algorithm.kmp;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2021/4/5
 */
public class KMP {


    public static void main(String[] args) {

        String S1 = "dserwtrefdgv";
        String S2 = "aacecaaa";

        int[] next = new int[S2.length() + 1];

        getNext5(S2, next);
        System.out.println(Arrays.toString(next));
        getNext3(S2, next);
        System.out.println(Arrays.toString(next));
        getNext2(S2, next);
        System.out.println(Arrays.toString(next));


        //
        //System.out.println(kmp(S1, S2, next));
    }

    public static void getNext(String data,int[] next){
        int pre=-1;
        int last=0;
        next[0]=-1;
        int length = data.length();
        while (last < length) {
            if (pre == -1 || data.charAt(last) == data.charAt(pre)) {
                pre++;
                last++;
                next[last] = pre;
            }else{
                pre=next[pre];
            }
        }
    }

    public static void getNext2(String data,int[] next){
        int pre=-1;
        int last=0;
        next[0]=-1;
        int length = data.length();
        while (last < length) {
            if (pre == -1 || data.charAt(last) == data.charAt(pre)) {
                pre++;
                last++;
                if (last < length && data.charAt(pre) == data.charAt(last)) {
                    next[last] = next[pre];
                } else {
                    next[last] = pre;
                }
            }else{
                pre=next[pre];
            }
        }
    }

    /**
     * 变种
     * @param data
     * @param next
     */
    public static void getNext3(String data,int[] next) {
        next[0] = -1;
        for (int i = 1; i < data.length(); i++) {
            int j = next[i - 1];
            while (j != -1 && data.charAt(j + 1) != data.charAt(i)) {
                j = next[j];
            }
            if (data.charAt(j + 1) == data.charAt(i)) {
                next[i] = j + 1;
            }
        }
    }


    public static void getNext5(String data, int[] next) {
        //next[0]=-1;
        //int pre=-1;
        //int cur=0;
        //int length = data.length();
        //while (cur < length) {
        //    if (pre == -1 || data.charAt(pre) == data.charAt(cur)) {
        //        pre++;
        //        cur++;
        //        if()
        //    }
        //}
    }

    public static int kmp(String S, String S2, int[] next) {
        int index1=0;
        int index2=0;
        while (index1 < S.length() && index2 < S2.length()) {
            if (index2 == -1 || S.charAt(index1) == S2.charAt(index2)) {

                index1++;
                index2++;
            } else {
                index2 = next[index2];
            }
        }
        if(index2==S2.length()) return index1 - index2;
        return -1;
    }
}
