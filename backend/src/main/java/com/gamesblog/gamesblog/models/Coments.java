package com.gamesblog.gamesblog.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_coments")
public class Coments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne()
    @JoinColumn(name = "game_id")
    private Game game;

    public Coments() {
    }

    public Coments(Long id, String text, Game game) {
        this.id = id;
        this.text = text;
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coments coments = (Coments) o;
        return Objects.equals(id, coments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
