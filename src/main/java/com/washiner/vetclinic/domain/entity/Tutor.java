package com.washiner.vetclinic.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter

//Nota técnica sobre o @ToString(exclude = {}):
//O exclude vazio não exclui nada. Quando tiver o relacionamento animais populado pode causar loop. Troca para:
//java@ToString(exclude = "animais")
@ToString(exclude = "animais")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Animal> animais; //o tutor tem avarios animais entao ele gera uma lista
}
//o tutor e o one o animal é o many
// tutor é one ou many? é o one entao

//    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
//    private List<Animal> animais;