package com.ohgiraffers.collection.level01.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {

//        학생 ID 입력('exit' 입력 시 종료): hello
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): java
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): programmer
//        ID가 추가 되었습니다.
//                학생 ID 입력('exit' 입력 시 종료): java
//        이미 등록 된 ID입니다.
//        학생 ID 입력('exit' 입력 시 종료): exit
//        모든 학생의 ID : [java, programmer, hello]

        Scanner sc = new Scanner(System.in);

        HashSet<String> hs = new HashSet<>();

        while (true){
            System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
            String str = sc.next();

            if(str.equals("exit")){
                System.out.println("모든 학생의 ID : " + hs);
                break;
            }

            if(hs.contains(str)){
                System.out.println("이미 등록 된 ID입니다.");
            } else {
                hs.add(str);
                System.out.println("ID가 추가 되었습니다.");
            }

        }
    }
}
