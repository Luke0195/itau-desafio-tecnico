package br.com.desafioitau.app.controller.exception;

import br.com.desafioitau.app.dtos.FieldErrorDto;
import br.com.desafioitau.app.dtos.StandardErrorDto;


import br.com.desafioitau.app.service.exceptions.TransacaoInvalidaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
public class ItauDesafioTecnicoExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorDto> handleHibernateValidation(HttpServletRequest httpServletRequest,
                                                                      MethodArgumentNotValidException exception){
      Set<FieldErrorDto> errors = StandardErrorDto.getValidationErrors(exception);
      int badRequest = getStatusCode(HttpStatus.BAD_REQUEST);
      String pathUrl = getPathUrlFromRequest(httpServletRequest);
      StandardErrorDto standardErrorDto = StandardErrorDto.mapToDto(badRequest, pathUrl, "Hibernate Validation Exception", "" +
              "Por favor valide os campos informados abaixo.", errors );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardErrorDto);
    };

    @ExceptionHandler(TransacaoInvalidaException.class)
    public ResponseEntity<StandardErrorDto> handleTranscacaoInvalidException(HttpServletRequest httpServletRequest,
                                                                             TransacaoInvalidaException exception){
        int unProcessaableEntityStatus = getStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
        String pathUrl = getPathUrlFromRequest(httpServletRequest);
        StandardErrorDto standardErrorDto  = StandardErrorDto.mapToDto(unProcessaableEntityStatus, pathUrl,
                "Não foi possivel processar a sua transação", exception.getMessage(), new HashSet<>() );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standardErrorDto);
    }

    public int  getStatusCode(HttpStatus httpStatus){
        return httpStatus.value();
    }

    public String getPathUrlFromRequest(HttpServletRequest httpServletRequest){
        return httpServletRequest.getRequestURI();
    }

}
