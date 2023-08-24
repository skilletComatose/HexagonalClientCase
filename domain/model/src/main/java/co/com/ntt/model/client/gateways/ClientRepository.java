package co.com.ntt.model.client.gateways;


import co.com.ntt.model.client.ClientResponse;

import java.util.Optional;

public interface ClientRepository {

    Optional<ClientResponse> findClientByTypeAndDocument(String documentType, String documentNumber);
}
