INSERT INTO tb_user (name,email,password) VALUES ('Anderson Conforto','anderson@gmail.com','$2a$10$8EwolCCKI.x0aFdqhHlvXeXoeF/VV/0QePkQ5y6T85M2.Xu7k8cmu');
INSERT INTO tb_user (name,email,password) VALUES ('Airton Conforto','airton@gmail.com','$2a$10$8EwolCCKI.x0aFdqhHlvXeXoeF/VV/0QePkQ5y6T85M2.Xu7k8cmu');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 1','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 2','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_games (name,photo,note,description) VALUES ('Uncharted 3','Sem foto',10.0,'Jogo perfeito');
INSERT INTO tb_mural (name,user_id) VALUES ('Mural do Anderson',1);
INSERT INTO tb_mural (name,user_id) VALUES ('Mural do Airton',2);
INSERT INTO tb_mural_games (mural_id,games_id) VALUES (1,1);
INSERT INTO tb_mural_games (mural_id,games_id) VALUES (2,2);


