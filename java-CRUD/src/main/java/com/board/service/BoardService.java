package com.board.service;

import com.board.domain.Board;
import com.board.persistence.BoardRepository;

import java.util.List;
import java.util.regex.Pattern;

public class BoardService {
    private final BoardRepository boardRepository;
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".*[!@#$%^&*(),.?\":{}|<>].*");

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAllBoards() {
        return boardRepository.selectAllBoards();
    }

    public Board findBoardByNo(int no) {
        return boardRepository.selectBoardByNo(no);
    }

    public void registerBoard(Board board){
        if(!isValidPassword(board.getPwd())){
            throw new IllegalArgumentException("게시판 등록 실패 : 비밀번호는 최소 " + MIN_PASSWORD_LENGTH +"자 이상이여야 하고 특수문자를 포함해야 합니다.");
        }
        if(board.getTitle() == null || board.getTitle().trim().isEmpty()){
            throw new IllegalArgumentException("게시판 등록 실패 : 게시판의 제목은 빈 칸일 수 없습니다.");
        }

        if (board.getContent() == null || board.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("게시판 등록 실패 : 게시판의 본문은 빈 칸일 수 없습니다.");
        }
        boardRepository.insertBoard(board);
    }

    public void removeBoard(int no){
        Board existingBoard = boardRepository.selectBoardByNo(no);
        if(existingBoard == null){
            throw new IllegalArgumentException("삭제 실패 : 해당 게시글을 찾을 수 없습니다.");
        }
        boardRepository.deleteBoard();
    }

    public void updateBoard(Board updatedBoard, String currentPwd){
        Board existingBoard = boardRepository.selectBoardByNo(updatedBoard.getBoardNo());
        if(existingBoard == null){
            throw new IllegalArgumentException("게시글 수정 실패 : 해당 게시글을 찾을 수 없습니다.");
        }
        if(!existingBoard.getPwd().equals(currentPwd)){
            throw new IllegalArgumentException("게시글 수정 실패 : 비밀번호가 일치 하지 않습니다.");
        }

        if(! existingBoard.getPwd().equals(updatedBoard.getPwd()) &&  !isValidPassword(updatedBoard.getPwd())){
            throw new IllegalArgumentException("게시글 수정 실패 : 새 비밀번호는 최소 " + MIN_PASSWORD_LENGTH +"자 이상이여야 하고 특수문자를 포함해야 합니다.");
        }
        if(updatedBoard.getTitle() == null){
            throw new IllegalArgumentException("게시글 수정 실패 : 게시글의 제목은 빈 칸일 수 없습니다.");
        }
        if(updatedBoard.getContent() == null){
            throw new IllegalArgumentException("게시글 수정 실패 : 게시글의 본문은 빈 칸일 수 없습니다.");
        }
        boardRepository.updateBoard(updatedBoard);
    }

    private boolean isValidPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH && PASSWORD_PATTERN.matcher(password).matches();
    }
}
