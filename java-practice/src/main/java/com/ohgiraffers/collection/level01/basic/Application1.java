package com.ohgiraffers.collection.level01.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
public static void main(String[] args) {
    //    학생 성적 : 100
//    추가 입력하려면 y : y
//    학생 성적 : 95
//    추가 입력하려면 y : Y
//    학생 성적 : 66
//    추가 입력하려면 y : y
//    학생 성적 : 79
//    추가 입력하려면 y : n
//    학생 인원 : 4
//    평균 점수 : 85.0
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> al = new ArrayList<Integer>();

    int score = 0;
    String yn = "";

    while (true){
        System.out.print("학생 성적 : ");
        al.add(sc.nextInt());
        System.out.print("추가 입력하려면 y : ");
        yn = sc.next();
        if(yn.equals("n")){
            break;
        }
    }

    double avg=0;
    for(int i = 0; i < al.size(); i++){
        avg = avg + al.get(i);
    }
    System.out.println("학생 인원 : " + al.size());
    System.out.println("평균 점수 : " + avg/al.size());
    }
}
