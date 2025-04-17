CREATE TABLE itens (
    nPatrimonio VARCHAR(50) PRIMARY KEY NOT NULL,
    nAntigo VARCHAR(50),
    descricao TEXT,
    conservacao VARCHAR(50),
    valorBem NUMERIC(12, 2),
    state VARCHAR(50),
    foto TEXT, 
    salaRegistrada VARCHAR(100) NOT NULL,
    salaAtual VARCHAR(100) NOT NULL
);
