package br.com.rodrigolorandi.resource.exception;

import br.com.rodrigolorandi.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,  HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),  status.value(), "Não encontrado",
                e.getMessage(),  request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

}
