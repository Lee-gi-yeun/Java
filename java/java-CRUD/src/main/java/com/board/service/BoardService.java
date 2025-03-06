package com.board.service;

import com.board.domain.Board;
import com.board.persistence.repository.BoardRepository;
import java.time.LocalDateTime;
import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void registerBoard(String title, String content, String writer, int userNo) {

        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("게시판 등록 실패 : 게시판의 제목은 빈 칸일 수 없습니다.");
        }

        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("게시판 등록 실패 : 게시판의 본문은 빈 칸일 수 없습니다.");
        }
        int nextBoardNo = boardRepository.getAllBoards().size() + 1;
        Board board = new Board(nextBoardNo, writer, title, content, LocalDateTime.now(), userNo);
        boardRepository.addBoard(board);
    }

    public List<Board> findAllBoards() {
        return boardRepository.getAllBoards();
    }

    public void deleteBoard(int boardNo, int userNo) {
        boardRepository.findByBoardNo(boardNo).ifPresentOrElse(board -> {
            if (board.getUserNo() == userNo) {
                boardRepository.deleteBoard(boardNo);
            } else {
                throw new IllegalArgumentException("본인이 작성한 게시글만 삭제할 수 있습니다.");
            }
        }, () -> {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
        });
    }
}
