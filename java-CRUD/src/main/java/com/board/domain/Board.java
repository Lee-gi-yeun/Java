package com.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Board implements Serializable {
    private int boardNo;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime created;
    private String pwd;

    public Board(int boardNo, String userName, String title, String content, LocalDateTime created, String pwd){
        this.boardNo = boardNo;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.created = created;
        this.pwd = pwd;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNo=" + boardNo +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
