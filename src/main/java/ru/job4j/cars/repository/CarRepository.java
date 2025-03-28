package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class CarRepository {
    private final CrudRepository crudRepository;

    public List<Car> findAll() {
        String query = "from Car";
        return crudRepository.query(query, Car.class);
    }

    public Optional<Car> findById(int carId) {
        String query = "from Car o WHERE o.id = :fId";
        return crudRepository.optional(query, Map.of("fId", carId), Car.class);
    }
}
