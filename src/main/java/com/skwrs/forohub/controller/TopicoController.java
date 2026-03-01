package com.skwrs.forohub.controller;

import com.skwrs.forohub.domain.topicos.*;
import com.skwrs.forohub.domain.topicos.validaciones.ValidadorIdExistente;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registro;

    @Autowired
    private ActualizarTopico actualizacion;

    @Autowired
    private EliminarTopico eliminacion;

    @Autowired
    private TopicosRepository repository;

    @Autowired
    private ValidadorIdExistente validacion;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = registro.registrar(datos);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listar(@PageableDefault(size = 10, sort = {"fecha_creacion"}) Pageable paginacion) {
        var page = repository.findAllNoCerrados(paginacion).map(DatosDetalleTopico::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable @Valid Long id) {
        validacion.validar(id);
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos) {
        var topico = actualizacion.actualizar(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable @Valid Long id) {
        eliminacion.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
