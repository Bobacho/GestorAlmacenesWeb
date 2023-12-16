package com.example.gestoralmacenes.auth;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateRequest {
    String nombreUsuario;
    String contraseña;
    String token;
}
