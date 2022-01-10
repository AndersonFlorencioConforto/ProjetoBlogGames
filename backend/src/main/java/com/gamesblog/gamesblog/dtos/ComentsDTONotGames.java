package com.gamesblog.gamesblog.dtos;


import com.gamesblog.gamesblog.models.Coment;

public class ComentsDTONotGames extends ComentsDTO {
    private static final long serialVersionUID = 1L;

    private GameDTO game;


    public ComentsDTONotGames() {
        super();
    }

    public ComentsDTONotGames(Coment coment) {
        this.game = (coment.getGame() == null) ? null : new GameDTO(coment.getGame());
    }


    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }
}
