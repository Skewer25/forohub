alter table topicos
change column fechaCreacion fecha_creacion timestamp default current_timestamp,
change column status status ENUM('ABIERTO', 'CERRADO', 'RESUELTO') default 'ABIERTO';