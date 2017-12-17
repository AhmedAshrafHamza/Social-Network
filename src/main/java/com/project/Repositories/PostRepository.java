package com.project.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.project.Entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
