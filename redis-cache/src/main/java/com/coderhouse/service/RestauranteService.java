package com.coderhouse.service;

import com.coderhouse.model.Restaurante;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RestauranteService {
    Restaurante crearRestaurante(Restaurante restaurante) throws JsonProcessingException;
    Restaurante getRestaurante(Long id) throws JsonProcessingException;
    Restaurante actualizarRestaurante(Restaurante restaurante, Long id);
    void borrarRestaurante(Long id);
}
