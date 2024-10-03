package com.example.ms_professore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "professori")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessore;

    private String nomeProfessore;

    private String cognomeProfessore;
}
