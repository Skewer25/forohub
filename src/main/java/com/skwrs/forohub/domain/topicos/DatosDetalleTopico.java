package com.skwrs.forohub.domain.topicos;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Estado status,
        Long idAutor,
        Long idCurso
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId());
    }
}
