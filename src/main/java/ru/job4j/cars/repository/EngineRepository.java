package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class EngineRepository {
    private final CrudRepository crudRepository;

    public List<Engine> findAll() {
        String query = "from Engine";
        return crudRepository.query(query, Engine.class);
    }

    public Optional<Engine> findById(int engineId) {
        String query = "from Engine o WHERE o.id = :fId";
        return crudRepository.optional(query, Map.of("fId", engineId), Engine.class);
    }
}
