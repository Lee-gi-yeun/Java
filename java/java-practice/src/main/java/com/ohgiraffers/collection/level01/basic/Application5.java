package com.ohgiraffers.collection.level01.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
//        단어 입력 ('exit' 입력 시 종료): 안녕
//        단어 입력 ('exit' 입력 시 종료): java
//        단어 입력 ('exit' 입력 시 종료): collection
//        단어 입력 ('exit' 입력 시 종료): 프로그래밍
//        단어 입력 ('exit' 입력 시 종료): exit
//        정렬 된 단어 : [collection, java, 안녕, 프로그래밍]

        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        while (true) {
            System.out.print("단어 입력 ('exit' 입력 시 종료): ");
            String str = sc.next();

            if (str.equals("exit")) {
                break;
            }
            al.add(str);
        }
        Collections.sort(al);
        System.out.println("정렬 된 단어 : " + al);

    }
}
