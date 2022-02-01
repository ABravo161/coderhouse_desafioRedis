package com.coderhouse.controller;

import com.coderhouse.model.Restaurante;
import com.coderhouse.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {
    private final RestauranteService service;

    @PostMapping("/restaurantes")
    public Restaurante crearRestaurante(@RequestBody Restaurante restaurante) throws JsonProcessingException {
        return service.crearRestaurante(restaurante);
    }

    @GetMapping("/restaurantes/{id}")
    public Restaurante getRestaurante(@PathVariable Long id) throws JsonProcessingException {
        return service.getRestaurante(id);
    }
}
