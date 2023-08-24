package co.com.ntt.genericsource.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String residenceCity;

    private String documentType;
    private String documentNumber;
}
