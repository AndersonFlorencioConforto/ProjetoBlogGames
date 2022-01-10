package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.Coment;
import com.gamesblog.gamesblog.models.Game;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @Size(min = 2, max = 60, message = "Deve conter entre 2 e 60 caracteres.")
    @NotBlank(message = "Campo requerido.")
    private String name;
    private String photo;
    @NotNull
    @DecimalMax("10.0") @DecimalMin("0.0")
    private Double note;
    @NotBlank(message = "Campo requerido.")
    private String description;
    private List<ComentsDTO> coments = new ArrayList<>();


    public GameDTO() {

    }

    public GameDTO(Long id, String name, String photo, Double note, String description) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.note = note;
        this.description = description;
    }

    public GameDTO(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.photo = game.getPhoto();
        this.note = game.getNote();
        this.description = game.getDescription();
    }

    public GameDTO(Game game, List<Coment> coments) {
        this(game);
        coments.forEach(x -> this.coments.add(new ComentsDTO(x)));
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ComentsDTO> getComents() {
        return coments;
    }

    public void setComents(List<ComentsDTO> coments) {
        this.coments = coments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDTO gameDTO = (GameDTO) o;
        return Objects.equals(id, gameDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
