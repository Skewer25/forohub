package com.skwrs.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(@NotBlank String nombre, @NotBlank Categoria categoria) {
}
