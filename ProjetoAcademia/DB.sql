create database academia
default character set=utf8mb4
default collate=utf8mb4_general_ci;

create table alunos(
id int auto_increment not null unique primary key,
nome varchar(100) not null,
cpf varchar(14) unique not null,
data_nascimento date not null,
telefone varchar(15),
email varchar(100)
) character set=utf8mb4;

create table treinos(
id int not null auto_increment unique primary key,
aluno_id int not null,
tipo_treino varchar(50),
descricao text,
duracao_minutos int,
data_inicio date,
foreign key(aluno_id) references alunos(id)
) character set=utf8mb4;

insert into alunos (nome, cpf, data_nascimento)
values ();

insert into treinos (aluno_id, descricao)
values ();

select * from alunos;
select * from treinos; 