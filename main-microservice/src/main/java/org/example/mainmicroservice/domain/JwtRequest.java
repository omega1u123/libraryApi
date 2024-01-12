package org.example.mainmicroservice.domain;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
