package com.ohgiraffers.section02.stream;

import java.io.FileWriter;
import java.io.IOException;

public class Application04 {
    public static void main(String[] args) {
        // FileWriter
        try(FileWriter fw = new FileWriter("testWriter.txt",true)){

            fw.write(97);
            fw.write('A');
            fw.write(new char[]{'a','b','c','d'});
            fw.write("안녕하세요");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
