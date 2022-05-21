package br.com.rodrigolorandi.config;

import br.com.rodrigolorandi.domain.Post;
import br.com.rodrigolorandi.domain.User;
import br.com.rodrigolorandi.dto.AuthorDTO;
import br.com.rodrigolorandi.dto.CommentDTO;
import br.com.rodrigolorandi.repository.PostRepository;
import br.com.rodrigolorandi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;


@RequiredArgsConstructor
@Configuration
public class Instantiation  implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2018,03,21), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2019,05,05), "Bom dia", "Acordei feliz", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem Mano!", LocalDate.now().minusWeeks(53), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveita", LocalDate.of(2019, 07, 05), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.of(2019, 07, 05), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);


    }
}
