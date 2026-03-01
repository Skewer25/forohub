package com.skwrs.forohub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicosRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensaje(@NotBlank String titulo, @NotBlank String mensaje);

    @Query("select t from Topico t where t.status != 'CERRADO'")
    Page<Topico> findAllNoCerrados(Pageable paginacion);
}
