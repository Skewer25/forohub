package com.skwrs.forohub.domain.topicos.validaciones;

import com.skwrs.forohub.domain.ValidacionException;
import com.skwrs.forohub.domain.topicos.DatosActualizacionTopico;
import com.skwrs.forohub.domain.topicos.DatosRegistroTopico;
import com.skwrs.forohub.domain.topicos.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoConMismoTituloYMensajeAlActualizar {
    @Autowired
    private TopicosRepository repository;

    public void validar(DatosActualizacionTopico datos) {
        var topicoConMismoTituloYMensaje = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (topicoConMismoTituloYMensaje) {
            throw new ValidacionException("Topico ya existente");
        }
    }
}
