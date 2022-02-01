package com.coderhouse.service;

import com.coderhouse.cache.CacheClient;
import com.coderhouse.model.Restaurante;
import com.coderhouse.repository.RestauranteRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestauranteServiceImp implements RestauranteService {

    private final RestauranteRepository repository;
    private final ObjectMapper mapper;
    private final CacheClient<Restaurante> cache;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }


    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) throws JsonProcessingException {
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteMap = mapper.readValue(restauranteString, Map.class);
        log.info("Restaurante en formato de Mapa : {}", restauranteMap);
        var data = repository.save(restaurante);
        return saveRestauranteInCache(data);
    }










    @Override
    public Restaurante getRestaurante(Long id) throws JsonProcessingException {
        var dataFromCache = cache.recover(id.toString(), Restaurante.class);
        if (!Objects.isNull(dataFromCache)) {
            return dataFromCache;
        }

        var data = repository.findById(id).get();
        return saveRestauranteInCache(data);
    }

    @Override
    public Restaurante actualizarRestaurante(Restaurante restaurante, Long id) {
        return null;
    }

    @Override
    public void borrarRestaurante(Long id) {

    }

    private Restaurante saveRestauranteInCache(Restaurante restaurante) throws JsonProcessingException {
        return cache.save(restaurante.getId().toString(), restaurante);
    }
}
