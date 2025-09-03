CREATE TABLE pao (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT,
  tempo_preparo INT NOT NULL,  
  cor VARCHAR(20)              
);

CREATE TABLE fornada (
  id INT AUTO_INCREMENT PRIMARY KEY,
  pao_id INT NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  FOREIGN KEY (pao_id) REFERENCES pao(id) ON DELETE CASCADE
);
