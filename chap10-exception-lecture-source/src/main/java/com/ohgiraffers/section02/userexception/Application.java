package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application {
    public static void main(String[] args) {
        // 사용자 정의 예외 클래스를 사용할 수 있다
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            // 정상 수행
            exceptionTest.checkEnoughMoney(3000,5000);
            // 상품 가격이 음수
//            exceptionTest.checkEnoughMoney(-3000,2000);
            // 가진 돈이 음수
//            exceptionTest.checkEnoughMoney(3000,-1000);
            // 상품 가격보다 가진 돈이 적은 경우
            exceptionTest.checkEnoughMoney(2000, 1000);


            // 예외 상황별로 catch 블럭을 따로 작성해서 처리할 수도 있고
            // 상위 타입의 Exception을 이용해서 통합적으로 처리할 수도 있다
            // 단, 상위 타입의 Exception 블럭이 먼저 기술 되면 아래로 코드가 도달할 수 없으므로
            // 컴파일 에러가 발생한다. 서술 순서는 하위 타입 -> 상위 타입으로 기재한다
        }/*catch (Exception e){}*/
        // | : 동일한 레벨의 다른 타입의 예외를 하나의 catch 블록에서 처리할 수 있다
        // 단, 상위 타입의 Exception과 하위 타입의 Exception이 함께 서술 될 수 없다
        catch (PriceNegativeException | MoneyNegativeException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } /* catch (Exception e){
            System.out.println(e.getMessage());
        } */

        System.out.println("프로그램을 종료합니다");
    }
}
