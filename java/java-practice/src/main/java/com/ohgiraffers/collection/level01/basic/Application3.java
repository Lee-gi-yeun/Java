package com.ohgiraffers.collection.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

//        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 유관순
//        유관순 고객님 대기 등록 되었습니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 홍길동
//        홍길동 고객님 대기 등록 되었습니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
//        유관순 고객님 차례입니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 신사임당
//        신사임당 고객님 대기 등록 되었습니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
//        홍길동 고객님 차례입니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
//        신사임당 고객님 차례입니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
//        대기 고객이 없습니다.
//                대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): exit

        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();

        while (true){
            System.out.print(" 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
            String str = sc.next();

            if (str.equals("exit")) {
                break;
            } else if (str.equals("next")) {
                if (q.isEmpty()) {
                    System.out.println("대기 고객이 없습니다.");
                } else {
                    System.out.println(q.poll() + " 고객님 차례입니다.");
                }
            } else {
                q.add(str);
                System.out.println(str + " 고객님 대기 등록 되었습니다.");
            }
        }
    }
}
