INSERT INTO tb_user (name) VALUES ('Anderson Conforto');
INSERT INTO tb_user (name) VALUES ('Airton Conforto');
INSERT INTO tb_user (name) VALUES ('Neide');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 1','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 2','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 3','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_mural (name,user_id) VALUES ('Mural do Anderson',1);
INSERT INTO tb_mural (name,user_id) VALUES ('Mural do Airton',2);
INSERT INTO tb_mural_games (mural_id,games_id) VALUES (1,1);
INSERT INTO tb_mural_games (mural_id,games_id) VALUES (2,2);


