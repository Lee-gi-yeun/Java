package com.board.ui;

import com.board.persistence.repository.BoardRepository;
import com.board.persistence.repository.UserRepository;
import com.board.domain.User;
import com.board.service.*;
import com.board.persistence.storage.FileBoardStorage;
import com.board.persistence.storage.FileUserStorage;

import java.util.Scanner;

public class Application {
    private final BoardService boardService;
    private final UserService userService;
    private final Scanner scanner;
    private User loggedInUser;

    public Application() {
        UserRepository userRepository = new UserRepository(new FileUserStorage());
        BoardRepository boardRepository = new BoardRepository(new FileBoardStorage());
        this.userService = new UserService(userRepository);
        this.boardService = new BoardService(boardRepository);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===== 게시판 관리 프로그램 =====");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 모든 게시글 조회");
            System.out.println("4. 게시글 작성 (로그인 필요)");
            System.out.println("5. 게시글 삭제 (로그인 필요)");
            System.out.println("6. 모든 사용자 조회");
            System.out.println("8. 로그아웃");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> login();
                    case 2 -> registerUser();
                    case 3 -> showAllBoards();
                    case 4 -> writeBoard();
                    case 5 -> deleteBoard();
                    case 6 -> showAllUsers();
                    case 8 -> logout();
                    case 9 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }

    private void login() {
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();

        try {
            loggedInUser = userService.login(id, pwd);
            System.out.println(loggedInUser.getUserName() + "님, 로그인 성공!");
        } catch (IllegalArgumentException e) {
            System.out.println("로그인 실패: " + e.getMessage());
        }
    }

    private void registerUser() {
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        System.out.print("사용자 이름: ");
        String userName = scanner.nextLine();

        try {
            userService.registerUser(id, pwd, userName);
            System.out.println("회원가입 성공! 이제 로그인하세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("회원가입 실패: " + e.getMessage());
        }
    }

    private void showAllBoards() {
        boardService.findAllBoards().forEach(System.out::println);
    }

    private void showAllUsers() {
        userService.findAllUsers().forEach(System.out::println);
    }


    private void writeBoard() {
        if (loggedInUser == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }

        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();

        boardService.registerBoard(title, content, loggedInUser.getUserName(), loggedInUser.getUserNo());
        System.out.println("게시글 작성 완료!");
    }

    private void deleteBoard() {
        if (loggedInUser == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }

        System.out.print("삭제할 게시글 번호: ");
        int boardNo = scanner.nextInt();
        scanner.nextLine();

        boardService.deleteBoard(boardNo, loggedInUser.getUserNo());
        System.out.println("게시글 삭제 완료!");
    }

    private void logout() {
        if (loggedInUser == null) {
            System.out.println("현재 로그인된 사용자가 없습니다.");
        } else {
            System.out.println(loggedInUser.getUserName() + "님, 로그아웃 되었습니다.");
            loggedInUser = null;
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
