package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.Coment;

import java.io.Serializable;
import java.util.Objects;

public class ComentsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;

    public ComentsDTO() {
    }

    public ComentsDTO(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public ComentsDTO(Coment coment) {
        this.id = coment.getId();
        this.text = coment.getText();
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
