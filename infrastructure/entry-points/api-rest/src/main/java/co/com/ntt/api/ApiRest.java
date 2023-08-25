package co.com.ntt.api;
import co.com.ntt.api.client.dto.FindClientByTypeAndDocumentDto;
import co.com.ntt.api.validations.requestBody.BodyValidations;
import co.com.ntt.model.response.GlobalResponse;
import co.com.ntt.model.client.ClientResponse;
import co.com.ntt.usecase.client.ClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class ApiRest {
    private final ClientUseCase clientUseCase;


    @PostMapping(path = "/client")
    @BodyValidations
    public  ResponseEntity<ClientResponse> findClientByTypeAndDocument( @RequestBody @Validated FindClientByTypeAndDocumentDto body, BindingResult bindingResult){
        if(body.getDocumentType().isEmpty()|| body.getDocumentNumber().isEmpty()){
            return ResponseEntity.internalServerError().body(null);
        }

        return getResponse(
                clientUseCase.findClientByTypeAndDocument(
                        body.getDocumentType(),
                        body.getDocumentNumber()
                )
        );
    }

    private ResponseEntity<ClientResponse> getResponse(GlobalResponse<ClientResponse> data){
        return ResponseEntity.status(data.getCode())
                .body(data.getData());
    }
}
