package com.example.gestoralmacenes.models.personas;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "NombreUsuario", unique = true)
    private String nombreUsuario;
    @Column(name = "Contraseña")
    private String contraseña;
    @Column(name = "TipoUsuario")
    private String tipoUsuario;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "FechaRegistro")
    private LocalDate fechaRegistro;
    @Column(name = "TipoActividad")
    private String tipoActividad;
    @Column(name = "DireccionIp")
    private String direccionIp;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.contraseña;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
