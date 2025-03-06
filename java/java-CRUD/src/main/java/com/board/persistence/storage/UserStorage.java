package com.board.persistence.storage;

import com.board.domain.User;
import java.util.List;

public interface UserStorage {
    void saveUsers(List<User> users);
    List<User> loadUsers();
}
