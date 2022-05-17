package br.com.rodrigolorandi.dto;

import br.com.rodrigolorandi.domain.User;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;



@Jacksonized
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {

    String id;
    String name;
    String email;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

}
