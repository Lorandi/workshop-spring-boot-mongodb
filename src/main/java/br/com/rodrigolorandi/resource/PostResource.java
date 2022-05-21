package br.com.rodrigolorandi.resource;

import br.com.rodrigolorandi.domain.Post;
import br.com.rodrigolorandi.resource.util.URL;
import br.com.rodrigolorandi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostResource {

    private final PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return  ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue = "") String text,
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate
//            @RequestParam(value="minDate", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> minDate,
//            @RequestParam(value="maxDate", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> maxDate
            ){
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate, LocalDate.now().minusYears(10));
        LocalDate max = URL.convertDate(maxDate, LocalDate.now().plusYears(1));
        List<Post> list = service.fullSearch(text, min, max);
        return  ResponseEntity.ok().body(list);
    }

}
