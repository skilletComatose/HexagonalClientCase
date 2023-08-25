package co.com.ntt.usecase.client;


import co.com.ntt.model.client.gateways.ClientRepository;
import co.com.ntt.model.response.GlobalResponse;
import co.com.ntt.model.client.ClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
public class ClientUseCase {

    private final ClientRepository clientRepository;

    public GlobalResponse<ClientResponse> findClientByTypeAndDocument(String documentType, String documentNumber){
        log.info(">> Buscando cliente en los registros  " );
        var clientData = clientRepository.findClientByTypeAndDocument(documentType,documentNumber);
        return clientData.isPresent() ? toSuccessResponse(clientData.get()) : clientNotFound();
    }


    private GlobalResponse<ClientResponse> toSuccessResponse(ClientResponse clientResponse){
        return  GlobalResponse.<ClientResponse>builder()
                .code(200)
                .data(clientResponse)
                .build();
    }

    private GlobalResponse<ClientResponse> clientNotFound(){
        return  GlobalResponse.<ClientResponse>builder()
                .code(404)
                .msg("Cliente no encontrado")
                .build();
    }


}
