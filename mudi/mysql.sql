create database viagem;
use viagem;

create table pedido(
id int not null auto_increment primary key,
nomeProduto varchar(30),
valorNegociado bigint,
dataDaViagem date,
urlProduto varchar(30),
urlImagem varchar(30),
descricao varchar(30)
);

select * from pedido;

drop table pedido;
