package com.skwrs.forohub.domain.topicos;

import com.skwrs.forohub.domain.curso.CursosRepository;
import com.skwrs.forohub.domain.topicos.validaciones.ValidadorTopicoConMismoTituloYMensaje;
import com.skwrs.forohub.domain.usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroDeTopicos {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private CursosRepository cursosRepository;

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private ValidadorTopicoConMismoTituloYMensaje validacion;

    public Topico registrar(DatosRegistroTopico datos){
        validacion.validar(datos);

        var autor = usuariosRepository.findById(datos.idAutor()).get();
        var curso = cursosRepository.findById(datos.idCurso()).get();
        var fecha = LocalDateTime.now();
        var estado = Estado.ABIERTO;
        var topico = new Topico(null, datos.titulo(), datos.mensaje(), fecha, estado, autor, curso, null);

        return topicosRepository.save(topico);
    }
}
