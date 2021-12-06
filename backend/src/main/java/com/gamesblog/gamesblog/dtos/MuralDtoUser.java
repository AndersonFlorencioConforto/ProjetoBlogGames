package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.User;

public class MuralDtoUser extends MuralDTO {
    private static final long serialVersionUID = 1L;

    private User user;

    public MuralDtoUser() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
