DROP TABLE tb_events;

CREATE TABLE tb_events
(
    id          serial PRIMARY KEY,
    created_by  VARCHAR(100) UNIQUE NOT NULL,
    created_on  TIMESTAMP           NOT NULL,
    name        VARCHAR(100)        NOT NULL,
    status      BOOLEAN             NOT NULL DEFAULT FALSE,
    owner       VARCHAR(100)        NOT NULL,
    category    VARCHAR(50)         NOT NULL,
    deadline    TIMESTAMP           NOT NULL,
    description VARCHAR(255)        NOT NULL
);

SET timezone = 'America/Sao_Paulo';

INSERT INTO tb_events(created_by, created_on, name, status, owner, category, deadline, description)
VALUES ('Gabriela',
        NOW(),
        'Elixir com José Valim',
        TRUE,
        'He4rt',
        'ONLINE_EVENT',
        '2023-02-04 15:00:00',
        'Apenas o evento mais esperado pela comunidade Elixir!');