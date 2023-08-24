package co.com.ntt.genericsource.client;

import co.com.ntt.genericsource.MockDataBase;
import co.com.ntt.model.client.Client;
import co.com.ntt.model.client.gateways.ClientRepository;
import co.com.ntt.model.client.ClientResponse;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ClientDataRepositoryAdapter implements ClientRepository {
    @Override
    public Optional<ClientResponse> findClientByTypeAndDocument(String documentType, String documentNumber) {

        return MockDataBase.clients.stream()
                .filter(client -> checkTypeAndDocument(client,documentType,documentNumber))
                .findFirst()
                .map(this::toClientResonse);
    }


    private Boolean checkTypeAndDocument(Client client, String documentType, String documentNumber){
        return documentType.equals(client.getDocumentType()) && documentNumber.equals(client.getDocumentNumber());
    }

    private ClientResponse toClientResonse(Client client){
        return ClientResponse.builder()
                .firstName(client.getFirstName())
                .middleName(client.getMiddleName())
                .lastName(client.getLastName())
                .secondLastName(client.getSecondLastName())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .residenceCity(client.getResidenceCity())
                .build();
    }
}
