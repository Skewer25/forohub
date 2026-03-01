package com.skwrs.forohub.domain.topicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EliminarTopico {

    @Autowired
    private TopicosRepository repository;

    public void eliminar(Long idTopico) {
        if (!repository.existsById(idTopico)){
            throw new RuntimeException("El topico no existe");
        }

        repository.deleteById(idTopico);
    }
}
