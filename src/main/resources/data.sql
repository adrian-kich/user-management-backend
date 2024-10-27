INSERT INTO cmn_usuarios(ID, NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES (1, 'Adrian Kich', 'ak', '1234', 'ak@gmail.com', 'ATIVO');

ALTER SEQUENCE cmn_usuarios_id_seq RESTART WITH 2;

INSERT INTO cmn_perfis(ID, DESCRICAO) VALUES (1, 'Administrador');
INSERT INTO cmn_perfis(ID, DESCRICAO) VALUES (2, 'Operador');
INSERT INTO cmn_perfis(ID, DESCRICAO) VALUES (3, 'Explorador');

ALTER SEQUENCE cmn_perfis_id_seq RESTART WITH 4;

INSERT INTO cmn_recursos (ID, NOME, CHAVE) VALUES (1, 'Tela Usuário', 'usuario');
INSERT INTO cmn_recursos (ID, NOME, CHAVE) VALUES (2, 'Tela Perfil', 'perfil');
INSERT INTO cmn_recursos (ID, NOME, CHAVE) VALUES (3, 'Tela Recurso', 'recurso');

ALTER SEQUENCE cmn_recursos_id_seq RESTART WITH 4;
