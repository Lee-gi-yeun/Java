package com.board.persistence.repository;

import com.board.domain.User;
import com.board.persistence.storage.UserStorage;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final UserStorage userStorage;
    private final List<User> userList;

    public UserRepository(UserStorage userStorage) {
        this.userStorage = userStorage;
        this.userList = userStorage.loadUsers();
    }

    public void addUser(User user) {
        userList.add(user);
        userStorage.saveUsers(userList);
    }

    public Optional<User> findById(String id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> findByUserNo(int userNo) {
        return userList.stream().filter(user -> user.getUserNo() == userNo).findFirst();
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
