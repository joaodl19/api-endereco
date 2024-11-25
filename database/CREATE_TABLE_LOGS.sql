CREATE TABLE logs (
    id BIGSERIAL PRIMARY KEY,                   -- Identificador único da tabela (auto-incremento com BIGSERIAL)
    data_hora TIMESTAMP NOT NULL,               -- Data e hora da consulta
    cep VARCHAR(9) NOT NULL,                    -- CEP (assumido 9 caracteres, incluindo o hífen)
    status_http INTEGER NOT NULL,               -- Status HTTP da resposta (por exemplo, 200, 404, etc.)
    body TEXT                                   -- Corpo da resposta, armazenado como texto
);