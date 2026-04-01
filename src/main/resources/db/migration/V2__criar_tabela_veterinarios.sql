CREATE TABLE veterinarios
(
    id       BIGSERIAL PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    crmv     VARCHAR(20)  NOT NULL UNIQUE,
    email    VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20)  NOT NULL
);