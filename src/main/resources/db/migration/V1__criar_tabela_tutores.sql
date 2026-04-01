CREATE TABLE tutores
(
    id       BIGSERIAL PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    cpf      VARCHAR(14)  NOT NULL UNIQUE,
    telefone VARCHAR(20)  NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE
);
