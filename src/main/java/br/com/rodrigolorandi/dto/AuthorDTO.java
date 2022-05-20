package br.com.rodrigolorandi.dto;

import br.com.rodrigolorandi.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Jacksonized
@NoArgsConstructor
@Data
public class AuthorDTO implements Serializable {
    String id;
    String name;

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
