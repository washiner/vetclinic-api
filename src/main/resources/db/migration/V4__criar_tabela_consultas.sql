CREATE TABLE consultas
(
    id             BIGSERIAL PRIMARY KEY,
    data_hora      TIMESTAMP    NOT NULL,
    motivo         VARCHAR(100) NOT NULL,
    diagnostico    VARCHAR(450),
    status         VARCHAR(20)  NOT NULL,
    animal_id      BIGINT       NOT NULL,
    veterinario_id BIGINT       NOT NULL,
    CONSTRAINT fk_consulta_animal FOREIGN KEY (animal_id) REFERENCES animais (id),
    CONSTRAINT fk_consulta_veterinario FOREIGN KEY (veterinario_id) REFERENCES veterinarios (id)
);