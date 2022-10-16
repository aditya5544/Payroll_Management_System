package com.v2stech.payroll.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);
	private static final String SOMETHING_WENT_WRONG = "Something went wrong : ";

////Trying with Logger
//	@ExceptionHandler(InvalidCredentialException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public void  getInvalidCredentialException(InvalidCredentialException ex) {
//		LOGGER.info(SOMETHING_WENT_WRONG + ex.getMessage());
//	}
//	
	@ExceptionHandler
	public ResponseEntity<String> getInvalidCredentialException(InvalidCredentialException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AlreadExistException.class)
	public ResponseEntity<String> hamdleAlreadExistException(AlreadExistException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataNotExistedException.class)
	public ResponseEntity<String> hamdleDataNotExistedException(DataNotExistedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<Map<String, String>> getInvalidFieldException(InvalidFieldException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String filedName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errorMessage.put(filedName, message);
		}
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

}
