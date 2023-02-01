CREATE TABLE tb_events
(
    id            serial PRIMARY KEY,
    registered_by VARCHAR(100) UNIQUE NOT NULL,
    name          VARCHAR(100)        NOT NULL,
    owner         VARCHAR(100)        NOT NULL,
    category      VARCHAR(50)         NOT NULL,
    deadline      TIMESTAMP           NOT NULL,
    description   VARCHAR(255)        NOT NULL
)