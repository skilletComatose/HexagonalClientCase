package co.com.ntt.model.client;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Client {
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
