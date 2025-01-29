package br.com.desafioitau.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public record StandardErrorDto(
        Instant timestamp,
        Integer status,
        @JsonProperty("path_url")
        String pathUrl,
        String error,
        String mensagem,
        @JsonProperty("campos_invalidos")
        Set<FieldErrorDto> camposInvalidos) {


  public static StandardErrorDto mapToDto(Integer status, String pathUrl, String error, String mensagem, Set<FieldErrorDto> camposInvalidos){
      return new StandardErrorDto(Instant.now(), status, pathUrl, error, mensagem, camposInvalidos);
  }

  public static Set<FieldErrorDto> getValidationErrors(MethodArgumentNotValidException exception){
      Set<FieldErrorDto> fieldErrors = new HashSet<>();
      exception.getFieldErrors().forEach(x -> {
          fieldErrors.add(new FieldErrorDto(x.getField(), x.getDefaultMessage()));
      });
      return fieldErrors;
  }
}
