package com.ohgiraffers.section03.behavior.subsection10.memento;

import java.util.Stack;

// 1. 상태 저장 객체 (Memento)
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 2. 원본 객체 (Originator)
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }

    public void showState() {
        System.out.println("현재 상태: " + state);
    }
}

// 3. 상태 관리 객체 (Caretaker)
class Caretaker {
    private Stack<Memento> history = new Stack<>();

    public void save(Originator originator) {
        history.push(originator.saveState());
    }

    public void undo(Originator originator) {
        if (!history.isEmpty()) {
            originator.restoreState(history.pop());
        } else {
            System.out.println("실행 취소할 상태가 없습니다.");
        }
    }
}

// 4. 클라이언트 코드 (메멘토 패턴 테스트)
public class MementoPatternExample {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("상태 1");
        caretaker.save(originator);

        originator.setState("상태 2");
        caretaker.save(originator);

        originator.setState("상태 3");
        originator.showState(); // 상태 3

        caretaker.undo(originator);
        originator.showState(); // 상태 2 (실행 취소됨)

        caretaker.undo(originator);
        originator.showState(); // 상태 1 (실행 취소됨)
    }
}