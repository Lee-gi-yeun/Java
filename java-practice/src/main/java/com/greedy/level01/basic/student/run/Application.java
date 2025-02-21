package com.greedy.level01.basic.student.run;

import com.greedy.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDTO[] studentArray = new StudentDTO[10];

        char ch;
        int studentCount = 0;

        for(int i=0; i<studentArray.length; i++){

                System.out.print("학년 : ");
                int grade = sc.nextInt();
                System.out.print("반 : ");
                int classroom = sc.nextInt();
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("국어점수 : ");
                int kor = sc.nextInt();
                System.out.print("영어점수 : ");
                int eng = sc.nextInt();
                System.out.print("수학점수 : ");
                int math = sc.nextInt();
                studentArray[i] = new StudentDTO(grade, classroom, name, kor, eng, math);

                studentCount++;

                System.out.print("계속 추가할 겁니까 ? (y/n) : ");
                ch = sc.next().charAt(0);

            if (ch != 'Y' && ch != 'y') {
                break;
             }
        }
        for(int i=0; i<studentCount; i++){
            System.out.println(studentArray[i].getInformation());
        }
    }
}
