package co.com.ntt.api.client.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FindClientByTypeAndDocumentDto {

    @NotNull(message = "El tipo de documento es obligatorio")
    private String documentType;

    @NotNull(message = "El  documento es obligatorio")
    private String documentNumber;
}
