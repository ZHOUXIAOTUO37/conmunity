package com.xt37.community.Bean;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
