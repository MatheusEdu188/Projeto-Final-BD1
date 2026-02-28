

CREATE TABLE filme (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    duracao INT NOT NULL,
    classificacao VARCHAR(20),
    genero VARCHAR(50)
);

CREATE TABLE tipo_sala (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE sessao (
    id SERIAL PRIMARY KEY,
    data_horario TIMESTAMP NOT NULL,
    filme_id INT NOT NULL,
    tipo_sala_id INT NOT NULL,

    CONSTRAINT fk_filme
        FOREIGN KEY (filme_id) REFERENCES filme(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_tipo_sala
        FOREIGN KEY (tipo_sala_id) REFERENCES tipo_sala(id)
        ON DELETE CASCADE
);

CREATE TABLE ingresso (
    id SERIAL PRIMARY KEY,
    preco NUMERIC(10,2) NOT NULL,
    sessao_id INT NOT NULL,

    CONSTRAINT fk_sessao
        FOREIGN KEY (sessao_id) REFERENCES sessao(id)
        ON DELETE CASCADE
);

CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    data_venda TIMESTAMP NOT NULL,
    ingresso_id INT NOT NULL,

    CONSTRAINT fk_ingresso
        FOREIGN KEY (ingresso_id) REFERENCES ingresso(id)
        ON DELETE CASCADE
);



CREATE INDEX idx_filme_genero ON filme(genero);
CREATE INDEX idx_sessao_filme ON sessao(filme_id);
CREATE INDEX idx_sessao_tipo_sala ON sessao(tipo_sala_id);
CREATE INDEX idx_ingresso_sessao ON ingresso(sessao_id);
CREATE INDEX idx_venda_ingresso ON venda(ingresso_id);



INSERT INTO filme (titulo, duracao, classificacao, genero) VALUES
('Vingadores', 150, '12', 'Ação'),
('Invocação do Mal', 120, '18', 'Terror'),
('Toy Story', 95, 'Livre', 'Animação'),
('Coringa', 130, '16', 'Drama');

INSERT INTO tipo_sala (descricao) VALUES
('Sala Normal'),
('Sala 3D'),
('Sala IMAX');

INSERT INTO sessao (data_horario, filme_id, tipo_sala_id) VALUES
('2026-03-01 18:00:00', 1, 1),
('2026-03-01 20:00:00', 1, 2),
('2026-03-02 19:00:00', 2, 1),
('2026-03-02 21:00:00', 3, 3),
('2026-03-03 20:00:00', 4, 2);

INSERT INTO ingresso (preco, sessao_id) VALUES
(25.00, 1),
(30.00, 2),
(20.00, 3),
(35.00, 4),
(28.00, 5);

INSERT INTO venda (data_venda, ingresso_id) VALUES
('2026-02-27 15:00:00', 1),
('2026-02-27 15:10:00', 2),
('2026-02-27 15:20:00', 3),
('2026-02-27 15:30:00', 4),
('2026-02-27 15:40:00', 5);


SELECT * FROM filme;
SELECT * FROM tipo_sala;
SELECT * FROM sessao;
SELECT * FROM ingresso;
SELECT * FROM venda;