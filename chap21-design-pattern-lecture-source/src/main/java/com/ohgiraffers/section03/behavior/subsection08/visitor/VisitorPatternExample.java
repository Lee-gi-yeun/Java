package com.ohgiraffers.section03.behavior.subsection08.visitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// 1. 방문 가능한 객체(ComputerPart) 인터페이스
interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

// 2. 구체적인 방문 가능한 객체 (키보드)
class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

// 3. 구체적인 방문 가능한 객체 (마우스)
class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

// 4. 방문자(Visitor) 인터페이스 (각 요소별 방문 메서드 정의)
interface ComputerPartVisitor {
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
}

// 5. 구체적인 방문자 클래스 (컴퓨터 부품을 출력하는 역할)
class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("키보드 출력");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("마우스 출력");
    }
}

// 6. 클라이언트 코드 (방문자 패턴 테스트)
public class VisitorPatternExample {
    public static void main(String[] args) throws IOException {
        ComputerPart keyboard = new Keyboard();
        ComputerPart mouse = new Mouse();

        ComputerPartVisitor displayVisitor = new ComputerPartDisplayVisitor();

        keyboard.accept(displayVisitor);
        mouse.accept(displayVisitor);

        /* 예시 : java.nio.file.FileVisitor → 파일 시스템을 탐색할 때 사용 */
//        Path path = Paths.get("C:/Users/유저명/Downloads");
//        Files.walkFileTree(path, new MyFileVisitor());
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("파일 방문: " + file);
        return FileVisitResult.CONTINUE;
    }
}