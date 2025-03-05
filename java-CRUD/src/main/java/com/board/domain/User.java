package com.board.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userNo;
    private String id;
    private String pwd;

    public User(int userNo, String id, String pwd) {
        this.userNo = userNo;
        this.id = id;
        this.pwd = pwd;
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
}
