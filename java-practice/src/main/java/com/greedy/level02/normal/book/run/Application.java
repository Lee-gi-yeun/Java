package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO bd = new BookDTO();
        bd.printInformation();

        BookDTO bd1 = new BookDTO("자바의 정석","도우출판","남궁성");
        bd1.printInformation();

        BookDTO bd2 = new BookDTO("홍길동전", "활빈당", "허균", 50000000, 0.5);
        bd2.printInformation();

    }
}
