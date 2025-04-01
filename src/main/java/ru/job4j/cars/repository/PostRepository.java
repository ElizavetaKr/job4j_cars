package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class PostRepository {

    private final CrudRepository crudRepository;

    public Post create(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    public void update(Post post) {
        crudRepository.run(session -> session.merge(post));
    }

    public void delete(int postId) {
        String query = "DELETE Post p WHERE p.id = :fId";
        crudRepository.run(query, Map.of("fId", postId));
    }

    public List<Post> findAll() {
        String query = "from Post";
        return crudRepository.query(query, Post.class);
    }

    public Optional<Post> findById(int postId) {
        String query = "from Post p WHERE p.id = :fId";
        return crudRepository.optional(query, Map.of("fId", postId), Post.class);
    }

    public List<Post> findAllForTheLastDay() {
        String query = "from Post p WHERE p.created > :data";
        return crudRepository.query(query, Map.of("data", LocalDateTime.now().minusDays(1)), Post.class);
    }

    public Optional<Post> findByName(String carName) {
        String query = "from Post p JOIN Car c ON p.car_id = c.id WHERE c.name = :fName)";
        return crudRepository.optional(query, Map.of("fName", carName), Post.class);
    }

    public List<Post> findAllWithPhoto() {
        String query = "from Post p WHERE size(p.photo) > 0";
        return crudRepository.query(query, Post.class);
    }
}
