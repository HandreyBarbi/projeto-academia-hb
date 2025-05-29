-- 1) Cria o banco apenas se não existir
CREATE DATABASE IF NOT EXISTS academia
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_general_ci;
  
-- 2) Seleciona o banco para as próximas instruções
USE academia;

-- 3) Cria a tabela de alunos
CREATE TABLE IF NOT EXISTS alunos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  data_nascimento DATE NOT NULL,
  telefone VARCHAR(15),
  email VARCHAR(100)
) CHARACTER SET = utf8mb4;

-- 4) Cria a tabela de treinos
CREATE TABLE IF NOT EXISTS treinos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  aluno_id INT NOT NULL,
  tipo_treino VARCHAR(50) NOT NULL,
  descricao TEXT,
  duracao_minutos INT,
  data_inicio DATE,
  FOREIGN KEY (aluno_id)
    REFERENCES alunos(id)
    ON DELETE CASCADE
) CHARACTER SET = utf8mb4;

-- 5) (Opcional) Teste de SELECT para validar
SELECT * FROM alunos;
SELECT * FROM treinos;
