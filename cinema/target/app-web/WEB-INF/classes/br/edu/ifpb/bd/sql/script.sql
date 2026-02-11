

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

    FOREIGN KEY (filme_id) REFERENCES filme(id),
    FOREIGN KEY (tipo_sala_id) REFERENCES tipo_sala(id)
);



CREATE TABLE ingresso (
    id SERIAL PRIMARY KEY,
    preco NUMERIC(10,2) NOT NULL,
    sessao_id INT NOT NULL,

    FOREIGN KEY (sessao_id) REFERENCES sessao(id)
);



CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    data_venda TIMESTAMP NOT NULL,
    ingresso_id INT NOT NULL,

    FOREIGN KEY (ingresso_id) REFERENCES ingresso(id)
);


select * from filme;
