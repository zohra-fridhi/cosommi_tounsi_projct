package tn.esprit.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class RedundantPublicationException extends RuntimeException {
	public RedundantPublicationException(String message) {
		super(message);
	}
}