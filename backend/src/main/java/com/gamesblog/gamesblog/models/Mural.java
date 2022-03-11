package com.gamesblog.gamesblog.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_mural")
public class Mural implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "tb_mural_games",
            joinColumns = @JoinColumn(name = "mural_id"),
            inverseJoinColumns = @JoinColumn(name = "games_id"))
    private Set<Game> games = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id",unique = true,updatable = false)
    private User user;

    public Mural() {

    }

    public Mural(Long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mural mural = (Mural) o;
        return Objects.equals(id, mural.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
