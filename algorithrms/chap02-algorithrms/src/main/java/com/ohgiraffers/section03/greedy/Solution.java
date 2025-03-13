package com.ohgiraffers.section03.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2]; // 학생 번호를 1부터 사용하고, 인덱스 초과 방지

        Arrays.fill(students, 1); // 모든 학생이 체육복 1개씩 갖고 있다고 가정

        for (int l : lost) students[l]--; // 도난당한 학생은 체육복 개수 감소
        for (int r : reserve) students[r]++; // 여벌 체육복이 있는 학생은 개수 증가

        for (int i = 1; i <= n; i++) { // 1번부터 n번 학생 순회
            if (students[i] == 0) { // 체육복이 없는 경우
                if (students[i - 1] == 2) { // 앞번호 학생이 여벌이 있을 경우
                    students[i]++;
                    students[i - 1]--;
                } else if (students[i + 1] == 2) { // 뒷번호 학생이 여벌이 있을 경우
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) { // 체육복이 1개 이상인 학생 수 세기
            if (students[i] >= 1) answer++;
        }

        return answer;
    }
}

