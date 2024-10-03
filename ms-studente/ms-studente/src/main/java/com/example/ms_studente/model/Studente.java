package com.example.ms_studente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studenti")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudente;

    private String nomeStudente;

    private String cognomeStudente;
}
