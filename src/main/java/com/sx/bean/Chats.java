package com.sx.bean;

import java.sql.Timestamp;

public class Chats {
    private int id;
    private String content;
    private int user_id;
    private String username;
    private Timestamp createAt;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}