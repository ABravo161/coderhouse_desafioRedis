package com.coderhouse.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ciudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pais pais;
}
