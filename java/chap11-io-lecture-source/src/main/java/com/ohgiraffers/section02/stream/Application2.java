package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        // FileReader
        try(FileReader fr = new FileReader("testReader.txt")){

//            int value;
//            while ((value = fr.read()) != -1){
//                System.out.println((char)value);
//            }

            char[] carr = new char[100];
            fr.read(carr);
            for(char c:carr){
                System.out.print(c);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
