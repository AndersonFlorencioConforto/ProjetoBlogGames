package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.User;
import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private MuralDTO mural;

    public UserDTO() {

    }

    public UserDTO(Long id, String name, MuralDTO mural) {
        this.id = id;
        this.name = name;
        this.mural = mural;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.mural = new MuralDTO(user.getMural());
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

    public MuralDTO getMural() {
        return mural;
    }

    public void setMural(MuralDTO mural) {
        this.mural = mural;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
