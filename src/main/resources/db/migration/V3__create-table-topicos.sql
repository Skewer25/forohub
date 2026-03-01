create table topicos(
    id bigint not null auto_increment,
    titulo varchar(200) not null,
    mensaje TEXT not null,
    fechaCreacion timestamp default current_timestamp,
    status tinyint default 1,
    usuario_id bigint not null,
    curso_id bigint not null,

    primary key(id),
    foreign key (usuario_id) references usuarios(id) on delete cascade,
    foreign key (curso_id) references cursos(id) on delete cascade
);
