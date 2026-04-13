CREATE TABlE clientes(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(256) not null UNIQUE,
    cpf varchar(11) not null UNIQUE,
    telefone varchar(20),
    ativo tinyint not null,

    primary key(id)
)