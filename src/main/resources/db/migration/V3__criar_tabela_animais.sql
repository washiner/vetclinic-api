CREATE TABLE animais
(
    id              BIGSERIAL PRIMARY KEY,
    nome            VARCHAR(100) NOT NULL,
    especie         VARCHAR(50)  NOT NULL,
    raca            VARCHAR(100),
    data_nascimento DATE         NOT NULL,
    sexo            VARCHAR(10)  NOT NULL,
    tutor_id        BIGINT       NOT NULL,
    CONSTRAINT fk_animal_tutor FOREIGN KEY (tutor_id) REFERENCES tutores (id)
);