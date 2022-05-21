package br.com.rodrigolorandi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;

@Jacksonized
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CommentDTO implements Serializable {
    String text;
    LocalDate date;
    AuthorDTO author;
}
