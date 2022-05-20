package br.com.rodrigolorandi.config;

import br.com.rodrigolorandi.domain.Post;
import br.com.rodrigolorandi.domain.User;
import br.com.rodrigolorandi.dto.AuthorDTO;
import br.com.rodrigolorandi.repository.PostRepository;
import br.com.rodrigolorandi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;


@RequiredArgsConstructor
@Configuration
public class Instantiation  implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2018,03,21), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2019,05,05), "Bom dia", "Acordei feliz", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
