CREATE DATABASE IF NOT EXISTS barberia;

USE barberia;

CREATE TABLE IF NOT EXISTS tbl_clientes (
	id_cliente varchar(12) NOT NULL,
    nombre_cliente varchar(45) NOT null,
    apellido_cliente varchar(45) not null,
    cel varchar(10) not null,
    tipoDocumento int not null,
    
    primary key(id_cliente)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS tbl_agenda(
	id_cita INT NOT NULL,
    anio varchar(4) not null,
    mes varchar(2) not null,
    dia varchar(2) not null,
    hora varchar(5) not null,
    
    primary key(id_cita),
    clientes_id_cliente varchar(12),
    constraint fk_cita_cliente
    foreign key (clientes_id_cliente)
    references tbl_clientes(id_cliente)
    
)ENGINE=INNODB;