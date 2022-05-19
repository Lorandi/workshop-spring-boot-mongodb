package br.com.rodrigolorandi.service;

import br.com.rodrigolorandi.domain.User;
import br.com.rodrigolorandi.dto.UserDTO;
import br.com.rodrigolorandi.repository.UserRepository;
import br.com.rodrigolorandi.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.deleteById(this.findById(id).getId());
    }

    public User update(UserDTO userDTO) {
        User user = this.findById(userDTO.getId());
        return repository.save(user
                .withEmail(userDTO.getEmail())
                .withName(userDTO.getName()));
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
