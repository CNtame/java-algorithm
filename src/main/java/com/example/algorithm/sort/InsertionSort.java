package com.example.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author liu
 * @version 1.0
 * @description 插入排序
 * @createDate 2020/12/29
 */
public class InsertionSort {

    public static void main(String[] args) throws IOException {

        int[] data = getInfo2();
        System.out.println("原数组"+Arrays.toString(data));
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if(data[j]>data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;

                }
            }
        }
        System.out.println("排序后数组" + Arrays.toString(data));
    }

    /**
     * 获取数据 控制台输入[1,2,3,4,5,6]
     * 流处理
     */
    public static int[] getInfo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        int data=-1;
        while ((data = reader.read()) != -1) {
            buffer.append((char) data);
        }
        reader.close();
        String datas = buffer.toString().trim();
        for (int i = 0; i < datas.length() - 1; i++) {
            res.add(datas.charAt(i) - '0');
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getInfo2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']') {
                data.append(s.charAt(i));
            }
        }
        return Arrays.stream(data.toString().split(",")).mapToInt(Integer::valueOf).toArray();
    }





    
}
