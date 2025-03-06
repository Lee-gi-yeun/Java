package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {

    public void printGugudanFromTwoToNice(){
        for(int i = 2;i < 10; i++){
            System.out.println("========"+i+"단========");
            for(int j = 1; j < 10; j++){
                System.out.println(i + " X " + j + " = " + i*j);
            }
            System.out.println();
        }
    }

    public void printTriangleStar(){
        // 입력 받은 정수만큼 한 행에 '*' 행의 번호 개씩 출력하기
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        for(int i=1;i <= num; i++){
            for(int j=1;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
