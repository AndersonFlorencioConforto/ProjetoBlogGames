package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.Game;
import com.gamesblog.gamesblog.models.Mural;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MuralDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @Size(min = 5,max = 60, message = "Deve ter entre 5 e 60 caracteres" )
    @NotBlank(message = "Campo obrigatório")
    private String name;
    private List<GameDTO> games = new ArrayList<>();

    public MuralDTO() {

    }

    public MuralDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MuralDTO(Mural mural) {
        this.id = mural.getId();
        this.name = mural.getName();
    }

    public MuralDTO(Mural mural, Set<Game> games) {
        this(mural);
        games.forEach(x -> this.games.add(new GameDTO(x)));
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

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MuralDTO muralDTO = (MuralDTO) o;
        return Objects.equals(id, muralDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
