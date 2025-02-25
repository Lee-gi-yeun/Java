package com.ohgiraffers.io.level01.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (원본 파일이 존재 하는 경우)
         * 원본 파일의 이름을 입력하세요 : origin.txt
         * 복사 파일의 이름을 입력하세요 : copy.txt
         *
         * ----- 출력 예시 -----
         *
         * 파일 복사가 성공적으로 완료 되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * (원본 파일이 존재하지 않는 경우)
         * 원본 파일의 이름을 입력하세요 : origin2.txt
         * 복사 파일의 이름을 입력하세요 : copy2.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : origin2.txt (지정된 파일을 찾을 수 없습니다)
         *
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("원본 파일의 이름을 입력하세요 : ");
        String origin = sc.nextLine();
        System.out.print("복사 파일의 이름을 입력하세요 : ");
        String copy = sc.nextLine();

        try(FileReader fr = new FileReader(origin)){
                try(FileWriter fw = new FileWriter(copy)){
                    int data;
                    while ((data = fr.read()) != -1) {
                        fw.write(data);
                    }
                }
        } catch (IOException e) {
            System.out.printf("오류 : "+origin+" (지정된 파일을 찾을 수 없습니다.)");
        }

    }
}