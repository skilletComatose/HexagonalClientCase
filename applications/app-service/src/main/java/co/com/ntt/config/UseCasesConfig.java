package co.com.ntt.config;

import co.com.ntt.model.client.gateways.ClientRepository;
import co.com.ntt.usecase.client.ClientUseCase;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCasesConfig {
        @Bean
        public ClientUseCase clientUseCase(ClientRepository clientRepository){
                return new ClientUseCase(clientRepository);
        }
}
