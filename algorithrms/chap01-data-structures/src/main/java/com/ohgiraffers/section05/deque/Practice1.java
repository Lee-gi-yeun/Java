package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Practice1 {

    public String solution(Integer[] notes){
        // 풍선을 Deque에 삽입
        Deque<Ballon>  ballons = new ArrayDeque<>();
        for(int i = 0; i<notes.length; i++) {
            ballons.add(new Ballon(i+1, notes[i]));
        }

        StringBuilder sb = new StringBuilder();

        while (!ballons.isEmpty()) {
            Ballon current = ballons.pollFirst(); // 첫 번째 풍선을 꺼냄
            sb.append(current.order); // 터진 풍선의 번호 저장

            if (!ballons.isEmpty()) {
                sb.append(" ");

                int move = current.noteValue; // 이동할 값
                if (move > 0) {
                    // 오른쪽으로 이동 (pollFirst() 후 뒤에 추가)
                    for (int i = 1; i < move; i++) {
                        ballons.addLast(ballons.pollFirst());
                    }
                } else {
                    // 왼쪽으로 이동 (pollLast() 후 앞에 추가)
                    for (int i = 0; i < -move; i++) {
                        ballons.addFirst(ballons.pollLast());
                    }
                }
            }

        }
        return sb.toString();
    }

    static class Ballon{
        int order;
        int noteValue;

        Ballon(int order, int noteValue){
            this.order = order;
            this.noteValue = noteValue;
        }
    }
}
