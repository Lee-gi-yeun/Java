package com.ohgiraffers.section04.dp;

public class C_Tiling {

    public static int solution(int n){

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[0] = 0;


        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n] % 10007;
    }
}
