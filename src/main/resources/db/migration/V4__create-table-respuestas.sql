create table respuestas(
    id bigint not null auto_increment,
    mensaje TEXT not null,
    topico_id bigint not null,
    fechaCreacion timestamp default current_timestamp,
    usuario_id bigint not null,
    solucion tinyint default 0,

    primary key(id),
    foreign key (topico_id) references topicos(id) on delete cascade,
    foreign key (usuario_id) references usuarios(id) on delete cascade,

    unique key unique_solucion_topico (topico_id, solucion)
                       comment 'Solo una respuesta marcada como solucion por topico'
);
