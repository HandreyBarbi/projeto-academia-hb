# PROJETO ACADEMIA

### Descrição
O projeto vai envolver Java, JDBC e MySQL

Para os que forem ler isso mais tarde, esse documento vai ser um pseudocódigo para usarmos como base no código fonte (em java). Para cada alteração peço que façam um pull request no github explicando o que mudaram (https://www.youtube.com/watch?v=Du04jBWrv4A). E deixem separado no código fonte que parte cada um escreveu usando um comentário como o exemplo a seguir:

``// Essa parte foi alterada por Gustavo``

Ou da forma que vocês quiserem, apenas deixem claro que foi você que passou por ali. Além disso, anotem o que vocês planejavam fazer antes de sair do código para a próxima pessoa conseguir editar. Expliquem erros e coisa assim para o amiguinho que for corrigir depois

# Objetivo
Desenvolver um sistema básico de gerenciamento de academia que permita o cadastro, consulta, atualização e exclusão (CRUD) de alunos e seus treinos, utilizando Java e SQL.

# Requisitos funcionais

## 2. Requisitos Funcionais (RF)<br/><br/>
### 2.1. Módulo de Alunos<br/><br/>
•	RF01: Cadastrar um novo aluno (nome, CPF, data de nascimento, telefone, e-mail).

•	RF02: Listar todos os alunos cadastrados.


•	RF03: Editar informações de um aluno existente.


•	RF04: Excluir um aluno do sistema.


•	RF05: Buscar aluno por nome ou CPF.


### 2.2. Módulo de Treinos <br/><br/>
•	RF06: Cadastrar um treino para um aluno (tipo de treino, descrição, duração, data de início).

•	RF07: Listar todos os treinos de um aluno específico.


•	RF08: Editar informações de um treino.


•	RF09: Excluir um treino.


### 2.3. Funcionalidades Gerais<br/><br/> ###
•	RF10: Persistir os dados em um banco de dados SQL (MySQL, PostgreSQL ou SQLite).


•	RF11: Interface simples no console (CLI) para interação com o usuário.

## 3. Requisitos Não Funcionais (RNF) ##
RNF01: Utilizar Java (JDK 11 ou superior) para desenvolvimento.


RNF02: Utilizar JDBC para conexão com o banco de dados.


RNF03: O sistema deve tratar erros de entrada (ex: CPF inválido, campos vazios).


RNF04: Código organizado, com classes bem definidas (ex: Aluno, Treino, AlunoDAO, TreinoDAO).


RNF05: Documentação básica (README.md explicando como executar o projeto).

## 3. Requisitos Não Funcionais (RNF)

•	RNF01: Utilizar Java (JDK 11 ou superior) para desenvolvimento.

•	RNF02: Utilizar JDBC para conexão com o banco de dados.

•	RNF03: O sistema deve tratar erros de entrada (ex: CPF inválido, campos vazios).

•	RNF04: Código organizado, com classes bem definidas (ex: Aluno, Treino, AlunoDAO, TreinoDAO).

•	RNF05: Documentação básica (README.md explicando como executar o projeto).

## 4. Entidades do Banco de Dados
<img src="https://i.imgur.com/PHNJ004.png" alt="DB do treino" width="500">

## 5. Entrega ##
- Código fonte (GitHub, GitLab ou arquivo compactado).


- Script SQL de criação do banco de dados.


README.md com:


- Descrição do projeto.


- Como configurar e executar.












<br/><br/>
<br/><br/>
<br/><br/>
Dicionário de HTML
se colocar # vai deixar o texto maior conforme mais # antes do texto.
Ex:
#### oi - muito pequeno
### oi - normal
## oi - grande
# oi - muito grande
*aa* -> deixa o texto em itálico

## dá pipoca po pai ##