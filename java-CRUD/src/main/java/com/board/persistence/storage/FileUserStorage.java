package com.board.persistence.storage;

import com.board.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserStorage implements UserStorage {
    private static final String FILE_PATH = "src/main/java/com/board/db/userDB.dat";

    @Override
    public void saveUsers(List<User> users) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            os.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException("사용자 정보 저장 중 오류 발생", e);
        }
    }

    @Override
    public List<User> loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("사용자 정보 로딩 중 오류 발생", e);
        }
    }
}
