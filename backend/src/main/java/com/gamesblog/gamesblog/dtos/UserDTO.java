package com.gamesblog.gamesblog.dtos;

import com.gamesblog.gamesblog.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @Size(min = 2,max = 60, message = "Deve ter entre 2 e 60 caracteres" )
    @NotBlank(message = "Campo obrigatório")
    private String name;
    @Email(message = "Email inválido")
    private String email;
    private MuralDTO mural;

    public UserDTO() {

    }

    public UserDTO(Long id, String name, String email, MuralDTO mural) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mural = mural;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.mural = new MuralDTO(user.getMural(),user.getMural().getGames());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
