package com.ohgiraffers.level02.normal;

import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

//        병합할 파일의 개수 입력 : 3
//        1 번째 파일 이름 입력 : test.txt
//        2 번째 파일 이름 입력 : test2.txt
//        3 번째 파일 이름 입력 : test3.txt
//        병합 될 파일명 입력 : result.txt
//        파일 병합이 완료 되었습니다.

//        병합할 파일의 개수 입력 : 2
//        1 번째 파일 이름 입력 : test.txt
//        2 번째 파일 이름 입력 : test4.txt
//        병합 될 파일명 입력 : result.txt
//        오류 : test4.txt (지정된 파일을 찾을 수 없습니다)

        Scanner sc = new Scanner(System.in);

        System.out.print("병합할 파일의 개수 입력 : ");
        int num = sc.nextInt();
        sc.nextLine();


        String[] fileNames = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.print((i + 1) + " 번째 파일 이름 입력 : ");
            fileNames[i] = sc.nextLine();
        }

        System.out.print("병합 될 파일명 입력 : ");
        String resultFileName = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultFileName))) {
            for (int i =0; i<fileNames.length; i++) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileNames[i]))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("오류 : " + fileNames[i] + " (지정된 파일을 찾을 수 없습니다)");
                    return;
                }
            }
            System.out.println("파일 병합이 완료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}