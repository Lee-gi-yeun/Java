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
//        for(int i = 0; i < input.length(); i++) {
//            /* 여는 괄호는 stack에 push, 닫는 괄호는 stack에서 pop 해서 짝을 맞춘다. */
//            if(input.charAt(i) == '(') {
//                stack.push('(');
//            } else {
//                stack.pop();
//                /* 닫는 괄호 앞에 여는 괄호가 있었다면 레이저이므로 막대기가 잘린다.
//                현재 stack에 쌓인 개수가 쌓인 막대기의 개수이므로 사이즈만큼을 더한다.
//                닫는 괄호 앞에 닫는 괄호가 있었다면 막대기의 끝을 의미하므로 1을 더한다. */
//                if(input.charAt(i - 1) == '(') {
//                    cnt += stack.size();
//                } else {
//                    cnt++;
//                }
//            }
//        }
        return pieceCount;
    }
}