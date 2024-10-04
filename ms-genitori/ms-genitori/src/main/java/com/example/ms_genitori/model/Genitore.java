package com.example.ms_genitori.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genitori")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Genitore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenitore;

    private String nomeGenitore;

    private String cognomeGenitore;
}
