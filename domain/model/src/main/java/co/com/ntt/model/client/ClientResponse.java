package co.com.ntt.model.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String residenceCity;
}
