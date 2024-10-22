package br.will.classroom.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoordenadorExemploDto {
    @NotBlank
    @Size(min = 1, max = 50)
    public String nome;
    @Size(min = 1, max = 10)
    private String senha;
    @Size(min = 1, max = 30)
    private String email;
}
