package com.greedy.level02.normal;

import java.util.Random;

public class RandomMaker {
    public static int randomNumber(int min, int max){
        Random random = new Random();
        int b = random.nextInt(min, max);
        return b;
    }

    public static String randomUpperAlphabet(int length) {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(26) + 'A');
            str = str + ch;
        }
        return str;
    }
    public static String rockPaperScissors(){
        Random random = new Random();
        int a = random.nextInt(1,3);
        String str;
        if(a == 1){
            str = "가위";
        } else if (a == 2) {
            str="바위";
        }
        else {
            str="보";
        }
        return str;
    }
    public static String tossCoin(){
        Random random = new Random();
        boolean b=random.nextBoolean();
        String str;
        if(b == true){
            str = "앞면";
        }else {
            str = "뒷면";
        }
        return str;
    }
}
