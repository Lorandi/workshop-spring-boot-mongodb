package br.com.rodrigolorandi.service;

import br.com.rodrigolorandi.domain.Post;
import br.com.rodrigolorandi.domain.User;
import br.com.rodrigolorandi.repository.PostRepository;
import br.com.rodrigolorandi.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class PostService {

    private final PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

}