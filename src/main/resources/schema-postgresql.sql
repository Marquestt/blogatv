CREATE TABLE IF NOT EXISTS Post (
  ID serial PRIMARY KEY,
  Titulo VARCHAR(50),
  Conteudo TEXT,
  DataCriacao TIMESTAMP
);
