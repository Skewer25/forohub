package com.skwrs.forohub.domain.topicos.validaciones;

import com.skwrs.forohub.domain.ValidacionException;
import com.skwrs.forohub.domain.topicos.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdExistente {

    @Autowired
    private TopicosRepository repository;

    public void validar(Long id) {
        if (!repository.existsById(id)) {
            throw new ValidacionException("Topico no encontrado, por favor revise el id");
        }
    }
}
