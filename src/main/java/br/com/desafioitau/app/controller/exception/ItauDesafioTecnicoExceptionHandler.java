package br.com.desafioitau.app.controller.exception;

import br.com.desafioitau.app.dtos.FieldErrorDto;
import br.com.desafioitau.app.dtos.StandardErrorDto;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Set;

@ControllerAdvice
public class ItauDesafioTecnicoExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorDto> handleHibernateValidation(HttpServletRequest httpServletRequest,
                                                                      MethodArgumentNotValidException exception){
      Set<FieldErrorDto> errors = StandardErrorDto.getValidationErrors(exception);
      int badRequest = HttpStatus.BAD_REQUEST.value();
      String pathUrl = httpServletRequest.getRequestURI();
      StandardErrorDto standardErrorDto = StandardErrorDto.mapToDto(badRequest, pathUrl, "Hibernate Validation Exception", "" +
              "Por favor valide os campos informados abaixo.", errors );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardErrorDto);
    };

}
