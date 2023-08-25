package co.com.ntt.genericsource;

import co.com.ntt.model.client.Client;


import java.util.Collections;
import java.util.List;

public class MockDataBase {
    public static final  List<Client> clients = Collections.singletonList(
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
