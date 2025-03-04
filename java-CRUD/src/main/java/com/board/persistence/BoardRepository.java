package com.board.persistence;

import com.board.domain.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {

    private final BoardStorage boardStorage;
    private final List<Board> boardList;

    public BoardRepository(BoardStorage boardStoreage){
        this.boardStorage = boardStoreage;
        this.boardList = boardStoreage.loadBoards();
    }

    public List<Board> selectAllBoards(){
        return new ArrayList<>(boardList);
    }

    public Board selectBoardByNo(int no){
        return boardList.stream()
                .filter(board -> board.getBoardNo() == no)
                .findFirst()
                .orElse(null);
    }

    public void insertBoard(Board board){
        boardList.add(board);
        boardStorage.saveBoards(boardList);
    }

    public void deleteBoard(){
        boardList.removeIf(board -> board.getBoardNo() == board.getBoardNo());
        boardStorage.saveBoards(boardList);
    }

    public void updateBoard(Board updateBoard){
        for(int i=0; i<boardList.size(); i++){
            if (boardList.get(i).getBoardNo() == boardList.get(i).getBoardNo()){
                boardList.set(i,updateBoard);
                boardStorage.saveBoards(boardList);
                break;
            }
        }
    }

}
