package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Owner;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class OwnerRepository {
    private final CrudRepository crudRepository;

    public List<Owner> findAll() {
        String query = "from Owner";
        return crudRepository.query(query, Owner.class);
    }

    public Optional<Owner> findById(int ownerId) {
        String query = "from Owner o WHERE o.id = :fId";
        return crudRepository.optional(query, Map.of("fId", ownerId), Owner.class);
    }
}
