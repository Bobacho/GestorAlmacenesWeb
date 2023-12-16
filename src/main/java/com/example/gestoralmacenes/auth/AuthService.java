package com.example.gestoralmacenes.auth;

import com.example.gestoralmacenes.jwt.JwtService;
import com.example.gestoralmacenes.models.personas.Usuario;
import com.example.gestoralmacenes.repositories.UsuarioRepository;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParametersException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AuthService {
    final UsuarioRepository repository;
    private final JwtService jwtService;
    private final Argon2PasswordEncoder passwordEncoder;
    public AuthResponse login(LoginRequest request) {
        Usuario user=repository.findByNombreUsuario(request.getNombreUsuario()).orElseThrow();
        if(!passwordEncoder.matches(request.getContraseña(), user.getContraseña()))
        {
            return null;
        }
        String token= jwtService.getToken(user);
        return AuthResponse.
                builder().
                token(token)
                .build();
    }
    public Boolean validateToken(ValidateRequest request)
    {
        try {
            return jwtService.isTokenValid(request.getToken(), new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return request.getContraseña();
                }

                @Override
                public String getUsername() {
                    return request.getNombreUsuario();
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
            });
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public AuthResponse register(RegisterRequest request) {
        Usuario usuario= Usuario.builder()
                .nombreUsuario(request.getNombreUsuario())
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .direccionIp(request.getDireccionIp())
                .fechaRegistro(request.getFechaRegistro())
                .nombre(request.getNombre())
                .tipoActividad(request.getTipoActividad())
                .build();
        repository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
