<<<<<<< HEAD
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
public class AlunoExemploDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String nome;
}
=======
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
public class AlunoExemploDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String nome;
}
>>>>>>> f7dea330874fc6ae04f349c39c3003d9014d2796
