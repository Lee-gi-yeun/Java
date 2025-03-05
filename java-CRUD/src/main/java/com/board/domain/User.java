package com.board.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userNo;
    private String id;
    private String pwd;
    private String userName;

    public User(int userNo, String id, String pwd, String userName) {
        this.userNo = userNo;
        this.id = id;
        this.pwd = pwd;
        this.userName = userName;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
