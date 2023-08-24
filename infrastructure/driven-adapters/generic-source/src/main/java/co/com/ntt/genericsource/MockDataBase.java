package co.com.ntt.genericsource;

import co.com.ntt.model.client.Client;

import java.util.Arrays;
import java.util.List;

public class MockDataBase {
    public static final  List<Client> clients = Arrays.asList(
            Client.builder()
                    .firstName("John")
                    .middleName("Michael")
                    .lastName("Doe")
                    .secondLastName("Johnson")
                    .phoneNumber("123-456-7890")
                    .address("123 Main St")
                    .residenceCity("Cityville")
                    .documentType("P")
                    .documentNumber("AB123456")
                    .build(),

            Client.builder()
                    .firstName("Jane")
                    .middleName("Marie")
                    .lastName("Smith")
                    .secondLastName("Williams")
                    .phoneNumber("987-654-3210")
                    .address("456 Elm St")
                    .residenceCity("Townville")
                    .documentType("C")
                    .documentNumber("XY789012")
                    .build(),

            Client.builder()
                    .firstName("Alice")
                    .middleName("Wich")
                    .lastName("torres")
                    .secondLastName("escobar")
                    .phoneNumber("555-123-4567")
                    .address("789 Oak St")
                    .residenceCity("cll 22,....")
                    .documentType("C")
                    .documentNumber("23445322")
                    .build()
    );



}
