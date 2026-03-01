package com.skwrs.forohub.domain.topicos.validaciones;

import com.skwrs.forohub.domain.ValidacionException;
import com.skwrs.forohub.domain.topicos.DatosRegistroTopico;
import com.skwrs.forohub.domain.topicos.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoConMismoTituloYMensaje {
    @Autowired
    private TopicosRepository repository;

    public void validar(DatosRegistroTopico datos) {
        var topicoConMismoTituloYMensaje = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (topicoConMismoTituloYMensaje) {
            throw new ValidacionException("Topico ya existente");
        }
    }
}
