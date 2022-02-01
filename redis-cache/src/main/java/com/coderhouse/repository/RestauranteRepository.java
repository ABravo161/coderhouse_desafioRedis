package com.coderhouse.repository;

import com.coderhouse.model.Restaurante;
import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {
}
