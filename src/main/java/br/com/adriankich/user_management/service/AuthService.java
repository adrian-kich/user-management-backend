package br.com.adriankich.user_management.service;

import br.com.adriankich.user_management.dto.AcessDTO;
import br.com.adriankich.user_management.dto.AuthenticationDTO;
import br.com.adriankich.user_management.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authenticationDTO) {

        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                    authenticationDTO.getUsername(), authenticationDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;

        } catch (BadCredentialsException e) {

        }
        return new AcessDTO("Acesso negado");
    }
}
