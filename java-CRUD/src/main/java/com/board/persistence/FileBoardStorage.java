package com.board.persistence;

import com.board.domain.Board;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBoardStorage implements BoardStorage {

    private static final String FILE_PATH = "src/main/java/com/board/db/boardDB.dat";

    @Override
    public void saveBoards(List<Board> boards) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
                os.writeObject(boards);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생",e);
        }
    }

    @Override
    public List<Board> loadBoards() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Board>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("게시글을 모두 로딩하였습니다.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("파일 로딩 중 오류 발생", e);
        }
    }
}
