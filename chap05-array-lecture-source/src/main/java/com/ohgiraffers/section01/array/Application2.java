package com.ohgiraffers.section01.array;

public class Application2 {
    public static void main(String[] args) {
        // 배열 선언 : stack에 배열의 주소를 보관할 레퍼런스 변수 공간을 만드는 것
        int[] iarr;
        double[] darr;

        // 선언한 레퍼런스 변수에 배열을 할당하여 대입할 수 있다
        // new 연산자는 heep 영역에 공간을 할당하고 발생한 주소 값을 반환한다
        // 발생한 주소가 레퍼런스 변수(참조형 변수)에 저장 되고 이것을 참조하여 사용하기 떄문에
        // 참조 자료형이라고 한다.
        iarr = new int[5];
        darr = new double[10];

        // heap 영역은 이름으로 접근하지 않고 주소 값으로 접근하는 영역이다
        // stack에 저장 된 주소로 heap에 할당 된 배열을 찾아갈 수 있다
        System.out.println("iarr : " + iarr);
        System.out.println("dirr : " + darr);

        // hashCode() : 객체의 주소 값을 10진수로 변환하여 생성한 객체의 고유 정수값을 반환하는 메소드
        System.out.println("iarr.hashCode() : "+ iarr.hashCode());
        System.out.println("darr.hashCode() : "+ darr.hashCode());
    }
}
