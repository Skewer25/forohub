package com.skwrs.forohub.domain.topicos;

import com.skwrs.forohub.domain.curso.CursosRepository;
import com.skwrs.forohub.domain.topicos.validaciones.ValidadorTopicoConMismoTituloYMensajeAlActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizarTopico {

    @Autowired
    private CursosRepository cursosRepository;

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private ValidadorTopicoConMismoTituloYMensajeAlActualizar validacion;

    public Topico actualizar(DatosActualizacionTopico datos){
        validacion.validar(datos);

        Topico topico = topicosRepository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos, cursosRepository);

        return topico;
    }
}
