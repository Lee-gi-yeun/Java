package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Practice2 {

    public String solution(String command, Integer[] array) {

        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(array));

        boolean isReversed = false; // 뒤집힌 상태를 추적

        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);

            if (cmd == 'R') {
                isReversed = !isReversed; // 뒤집기 상태 토글
            } else if (cmd == 'D') {
                if (deque.isEmpty()) {
                    return "error"; // 비어 있으면 즉시 에러 반환
                }

                if (isReversed) {
                    deque.pollLast(); // 뒤집힌 상태면 뒤에서 삭제
                } else {
                    deque.pollFirst(); // 기본 상태면 앞에서 삭제
                }
            }
        }

        // 최종 결과 출력
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}