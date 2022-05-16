package br.com.rodrigolorandi.resource;

import br.com.rodrigolorandi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brow", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");

        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(maria,alex));

        return ResponseEntity.ok().body(list);
    }
}
