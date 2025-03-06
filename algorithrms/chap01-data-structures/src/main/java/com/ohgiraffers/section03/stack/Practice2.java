package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {

    public int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int pieceCount = 0; // 잘린 조각 개수

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c); // 막대 시작 또는 레이저의 '('
            } else { // c == ')'
                stack.pop(); // 일단 '(' 제거

                if (input.charAt(i - 1) == '(') {
                    // 직전 문자가 '('라면 → 레이저
                    pieceCount += stack.size(); // 현재 stack의 크기만큼 막대 조각 추가
                } else {
                    // 직전 문자가 ')'라면 → 막대의 끝
                    pieceCount += 1; // 하나의 막대가 끝났으므로 조각 1개 추가
                }
            }
        }
        return pieceCount;
    }
}