package com.example.backend.config;

import com.example.backend.service.client.LoginClient;
import com.example.backend.service.client.LoginClients;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VendorConfiguration {
 
    @Bean
    public LoginClients loginClients(final Set<LoginClient> clients) {
        return new LoginClients(clients);
    }
}
