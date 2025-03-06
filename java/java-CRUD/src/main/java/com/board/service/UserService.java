package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserService {
    private final UserRepository userRepository;
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".*[!@#$%^&*(),.?\":{}|<>].*");

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String id, String pwd, String userName) {
        if (userRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        if (!isValidPassword(pwd)) {
            throw new IllegalArgumentException("회원 가입 실패: 비밀번호는 최소 " + MIN_PASSWORD_LENGTH + "자 이상이어야 하고 특수문자를 포함해야 합니다.");
        }
        int nextUserNo = userRepository.getAllUsers().size() + 1;
        User newUser = new User(nextUserNo, id, pwd, userName);
        userRepository.addUser(newUser);
    }

    public User login(String id, String pwd) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent() && user.get().getPwd().equals(pwd)) {
            return user.get();
        }
        throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH && PASSWORD_PATTERN.matcher(password).matches();
    }

    public List<User> findAllUsers() {
        return userRepository.getAllUsers();
    }
}
