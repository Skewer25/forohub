package com.skwrs.forohub.domain.topicos;

import com.skwrs.forohub.domain.curso.Curso;
import com.skwrs.forohub.domain.curso.CursosRepository;
import com.skwrs.forohub.domain.respuestas.Respuesta;
import com.skwrs.forohub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ABIERTO','CERRADO','RESUELTO') DEFAULT 'ABIERTO'")
    private Estado status = Estado.ABIERTO;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos, CursosRepository cursosRepo) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.idCurso() != null) {
            this.curso = cursosRepo.findById(datos.idCurso())
                    .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        }
    }
}
