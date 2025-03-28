package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Map;

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

    public List<Post> findById(int postId) {
        String query = "from Post p WHERE p.id = :fId";
        return crudRepository.query(query, Map.of("fId", postId), Post.class);
    }
}
