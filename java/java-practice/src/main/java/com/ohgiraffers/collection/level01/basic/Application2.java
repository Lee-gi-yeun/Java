package com.ohgiraffers.collection.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
//        최근 방문 url : [https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
//        최근 방문 url : [https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.notion.so/
//        최근 방문 url : [https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.naver.com/
//        최근 방문 url : [https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
//        최근 방문 url : [https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
//        최근 방문 url : [https://www.google.com/, https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/]
//        방문 URL을 입력하세요 (단, exit를 입력하면 종료) : exit

        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();

        while (true){

            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            String str = sc.next();
            q.add(str);
            if(str.equals("exit")){
                break;
            }
            if(q.size() > 5){
                q.poll();
            }
            System.out.print("최근 방문 url : ");
                System.out.println(q);
        }
    }
}
