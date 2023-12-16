package com.example.gestoralmacenes.auth;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Long Id;
    private String nombreUsuario;
    private String Contraseña;
    private String TipoUsuario;
    private String Nombre;
    private LocalDate FechaRegistro;
    private String TipoActividad;
    private String DireccionIp;
}
