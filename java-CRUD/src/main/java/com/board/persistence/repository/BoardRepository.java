package com.board.persistence.repository;

import com.board.domain.Board;
import com.board.persistence.storage.BoardStorage;

import java.util.List;
import java.util.Optional;

public class BoardRepository {
    private final BoardStorage boardStorage;
    private final List<Board> boardList;

    public BoardRepository(BoardStorage boardStorage) {
        this.boardStorage = boardStorage;
        this.boardList = boardStorage.loadBoards();
    }

    public void addBoard(Board board) {
        boardList.add(board);
        boardStorage.saveBoards(boardList);
    }

    public List<Board> getAllBoards() {
        return boardList;
    }

    public Optional<Board> findByBoardNo(int boardNo) {
        return boardList.stream().filter(board -> board.getBoardNo() == boardNo).findFirst();
    }

    public void deleteBoard(int boardNo) {
        boardList.removeIf(board -> board.getBoardNo() == boardNo);
        boardStorage.saveBoards(boardList);
    }
}
