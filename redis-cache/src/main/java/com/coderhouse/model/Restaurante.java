package com.coderhouse.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String horaApertura;
    private String horaCierre;
    private String latitud;
    private String longitud;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Categoria> categorias;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ciudad ciudad;
}
