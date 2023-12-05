package com.crud.dio.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message = "Nome obrigatório.")
    private String name;

    @NotEmpty(message = "Email obrigatório.")
    private String email;
}
