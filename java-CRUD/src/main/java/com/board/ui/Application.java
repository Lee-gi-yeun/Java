package com.board.ui;

import com.board.domain.Board;
import com.board.persistence.BoardRepository;
import com.board.persistence.FileBoardStorage;
import com.board.service.BoardService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Application {
    private final BoardService boardService;
    private final Scanner scanner;

    public Application() {
        BoardRepository boardRepository = new BoardRepository(new FileBoardStorage());
        this.boardService = new BoardService(boardRepository);
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        while (true){
            System.out.println("\n===== 게시판 관리 프로그램 =====");
            System.out.println("1. 모든 게시글 조회");
            System.out.println("2. 게시글 조회");
            System.out.println("3. 게시글 작성");
            System.out.println("4. 게시글 수정");
            System.out.println("5. 게시글 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> showAllBoards();
                    case 2 -> findBoardByNo();
                    case 3 -> addBoard();
                    case 4 -> updateBoard();
                    case 5 -> removeBoard();
                    case 9 ->{
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                        default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (Exception e){
                System.out.println("오료 : " + e.getMessage());
            }
        }
    }

    private void showAllBoards() {
        boardService.findAllBoards().forEach(System.out::println);
    }

    private void findBoardByNo() {
        System.out.print("조회할 게시판 번호 입력: ");
        int no = scanner.nextInt();
        scanner.nextLine();

        Board board = boardService.findBoardByNo(no);
        if(board != null){
            System.out.println(board);
        } else{
            System.out.println("해당 번호의 게시글을 조회 할 수 없습니다.");
        }
    }

    private void addBoard() {
        try{
            System.out.print("작성자 입력: ");
            String userName = scanner.nextLine();

            System.out.print("제목 입력: ");
            String title = scanner.nextLine();

            System.out.print("본문 입력: ");
            String content = scanner.nextLine();

            System.out.print("비밀 번호 입력: ");
            String pwd = scanner.nextLine();

            LocalDateTime createTime = LocalDateTime.now();

            int nextBoardNo = boardService.findAllBoards().size() + 1;

            if (userName.trim().isEmpty()) {
                System.out.println("게시판 등록 실패: 게시판의 작성자는 빈 칸일 수 없습니다.");
                return;
            }

            if (title.trim().isEmpty()) {
                System.out.println("게시판 등록 실패: 게시판의 제목은 빈 칸일 수 없습니다.");
                return;
            }
            if (content.trim().isEmpty()) {
                System.out.println("게시판 등록 실패: 게시판의 본문은 빈 칸일 수 없습니다.");
                return;
            }

            Board newBoard =new Board(nextBoardNo,userName,title,content,createTime,pwd);

            boardService.registerBoard(newBoard);
            System.out.println("게시판 등록 성공: " + nextBoardNo);

        } catch (IllegalArgumentException e){
            System.out.println("게시판 등록 실패: " + e.getMessage());
        }
    }

    private void updateBoard() {
        try{
            System.out.print("수정할 게시글 번호 입력: ");
            int no = scanner.nextInt();
            scanner.nextLine();

            Board existingBoard = boardService.findBoardByNo(no);
            if(existingBoard == null){
                System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
                return;
            }

            System.out.print("비밀번호 확인: ");
            String currentPassword = scanner.nextLine();

            System.out.println("수정할 게시글 제목을 입력하세요 변경하지 않으려면 Enter 입력)");
            System.out.print("새로운 게시글 제목 (" + existingBoard.getTitle() + "): ");
            String title = scanner.nextLine();
            if(title.isEmpty()){
                title = existingBoard.getTitle();
            }

            System.out.println("수정할 게시글 내용을 입력하세요 변경하지 않으려면 Enter 입력)");
            System.out.print("새로운 게시글 내용 (" + existingBoard.getContent() + "): ");
            String content = scanner.nextLine();
            if(content.isEmpty()){
                content = existingBoard.getContent();
            }

            System.out.println("새로운 작성자를 입력하세요 변경하지 않으려면 Enter 입력)");
            System.out.print("새로운 작성자 (" + existingBoard.getUserName() + "): ");
            String userName = scanner.nextLine();
            if(userName.isEmpty()){
                userName = existingBoard.getUserName();
            }

            System.out.print("새로운 비밀번호 입력 (비밀번호 변경 시 입력, 아니면 Enter): ");
            String newPassword = scanner.nextLine();
            if (newPassword.isEmpty()) {
                newPassword = existingBoard.getPwd();
            }

            LocalDateTime updateTime = LocalDateTime.now();

            Board updateBoard = new Board(no,userName,title,content,updateTime,newPassword);
            boardService.updateBoard(updateBoard, currentPassword);
            System.out.println("게시글 정보 수정 완료: " + title);
        } catch (IllegalArgumentException e){
            System.out.println("회원 정보 수정 실패: " + e.getMessage());
        }
    }

    private void removeBoard() {
        try{
            System.out.print("삭제할 게시글 번호 입력: ");
            int no = scanner.nextInt();
            scanner.nextLine();

            boardService.removeBoard(no);
            System.out.println("게시글 삭제 완료 (ID: " + no + ")");

        } catch (IllegalArgumentException e){
            System.out.println("게시글 삭제 실패: " + e.getMessage());
        }
    }

    public static void main(String[] args) {new Application().run();}
}
