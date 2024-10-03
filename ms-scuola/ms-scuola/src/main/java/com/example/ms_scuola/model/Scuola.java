package com.example.ms_scuola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scuole")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Scuola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScuola;

    private String nomeScuola;

    private String indirizzoScuola;
}
