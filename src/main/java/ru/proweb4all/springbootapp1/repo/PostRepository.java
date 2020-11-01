package ru.proweb4all.springbootapp1.repo;

import org.springframework.data.repository.CrudRepository;
import ru.proweb4all.springbootapp1.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
