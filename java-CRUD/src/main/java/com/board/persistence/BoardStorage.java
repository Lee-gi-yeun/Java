package com.board.persistence;

import com.board.domain.Board;

import java.util.List;

public interface BoardStorage {
    void saveBoards(List<Board> boards);
    List<Board> loadBoards();
}
