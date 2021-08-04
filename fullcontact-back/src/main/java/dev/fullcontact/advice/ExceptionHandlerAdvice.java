package dev.fullcontact.advice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.exceptions.ErrorVO;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorVO>> handleError(BusinessException businessException) {
		List<ErrorVO> vo=businessException.getErrorVO();
		return new ResponseEntity<List<ErrorVO>>(vo,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorVO>> handleError(MethodArgumentNotValidException  methodArgumentNotValidException ) {
		 String errors = methodArgumentNotValidException.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.joining(","));
		 ErrorVO vo=new ErrorVO("01", errors);
		return new ResponseEntity<List<ErrorVO>>(Arrays.asList(vo),HttpStatus.BAD_REQUEST);
	}
}
