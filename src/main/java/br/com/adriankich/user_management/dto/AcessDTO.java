package br.com.adriankich.user_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

    private String token;

    public AcessDTO(String token) {
        this.token = token;
    }
}
