package org.spring.application.accuweather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ZipCodeNotFoundException extends RuntimeException {

	public ZipCodeNotFoundException(String message) {
		super(message);
	}

	public ZipCodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
