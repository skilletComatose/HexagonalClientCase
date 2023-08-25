package co.com.ntt.usecase.client;

import co.com.ntt.model.client.ClientResponse;
import co.com.ntt.model.client.gateways.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = ClientUseCase.class)
class ClientUseCaseTest {

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientUseCase clientUseCase;

    @Test
    void  findClientByTypeAndDocumentShouldFindClient(){
        var clientResponse = Optional.of(
                ClientResponse.builder()
                        .firstName("Carlos")
                        .middleName("Perez")
                        .lastName("Acosta")
                        .secondLastName("Berrio")
                        .phoneNumber("+57 123")
                        .address("ADR 123")
                        .residenceCity("CL 123")
                        .build()
        );
        when(clientRepository.findClientByTypeAndDocument("C","23445322") )
                .thenReturn(clientResponse);

        var result = clientUseCase.findClientByTypeAndDocument("C","23445322").getData();

        assertEquals(clientResponse.get(), result);

        verify(clientRepository,times(1)).findClientByTypeAndDocument(anyString(), anyString());
    }

    @Test
    void  findClientByTypeAndDocumentNotFoundClient(){
        var notFound = 404;
        when(clientRepository.findClientByTypeAndDocument(anyString(), anyString()) )
                .thenReturn(Optional.empty());

        var result = clientUseCase.findClientByTypeAndDocument("P","23445322");

        assertEquals(notFound, result.getCode());

        verify(clientRepository,times(1)).findClientByTypeAndDocument(anyString(), anyString());
    }

}