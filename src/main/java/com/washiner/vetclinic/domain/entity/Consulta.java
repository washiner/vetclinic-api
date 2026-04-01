package com.washiner.vetclinic.domain.entity;

import com.washiner.vetclinic.domain.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = {"animal", "veterinario"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 100)
    private String motivo;

    @Column(length = 450)
    private String diagnostico;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;

}
