package com.gamesblog.gamesblog.dtos;


import com.gamesblog.gamesblog.models.Coments;

public class ComentsDTONotGames extends ComentsDTO {
    private static final long serialVersionUID = 1L;

    private GameDTO game;


    public ComentsDTONotGames() {
        super();
    }

    public ComentsDTONotGames(Coments coments) {
        this.game = (coments.getGame() == null) ? null : new GameDTO(coments.getGame());
    }


    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }
}
