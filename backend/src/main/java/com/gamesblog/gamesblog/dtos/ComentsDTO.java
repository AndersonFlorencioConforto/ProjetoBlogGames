package com.gamesblog.gamesblog.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamesblog.gamesblog.models.Coment;

import java.io.Serializable;
import java.util.Objects;

public class ComentsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;
    @JsonIgnoreProperties({"mural","email"})
    private UserDTO user;

    public ComentsDTO() {
    }

    public ComentsDTO(Long id, String text,UserDTO user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public ComentsDTO(Coment coment) {
        this.id = coment.getId();
        this.text = coment.getText();
        this.user = (coment.getUser() == null) ? null : new UserDTO(coment.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComentsDTO that = (ComentsDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
