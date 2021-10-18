package br.com.cwi.reset.arielgustavo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentsExceptions extends Exception {

    public InvalidArgumentsExceptions(String mensagem) {
        super(mensagem);
    }
}
