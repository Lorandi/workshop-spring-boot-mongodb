package br.com.rodrigolorandi.repository;

import br.com.rodrigolorandi.domain.Post;
import br.com.rodrigolorandi.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
