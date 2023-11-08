package com.alianza.clients;

import com.alianza.clients.domain.entity.Client;
import com.alianza.clients.repository.client.ClientRepository;
import com.alianza.clients.service.client.impl.ClientService;
import com.alianza.clients.utils.Dates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientsApplicationTests {

    @Mock
    private ClientRepository clientRepository;

    private ClientService clientService;

    @BeforeEach
    void setUp() {
        this.clientService
                = new ClientService(this.clientRepository);
    }

    @Test
    void testGetAllCLients() {
        Client client = generateClient();
        List<Client> list = new ArrayList<Client>();

        list.add(client);

        when(clientRepository.findAll()).thenReturn(list);

        //test
        List<Client> testList = clientService.findAll();

        assertEquals(1, testList.size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void testFindBySharedKey() {
        Client client = generateClient();
        String sharedKey = client.getSharedKey();

        when(clientRepository.findBySharedKey(sharedKey)).thenReturn(Optional.of(client));

        //test
        Client clientTest = clientService.findBySharedKey(sharedKey);

        assertEquals(client, clientTest);
        verify(clientRepository, times(1)).findBySharedKey(sharedKey);
    }

    @Test
    void testSaveClient() {
        clientService.save(generateClient());
        verify(clientRepository, times(1)).save(generateClient());
    }

    private Client generateClient() {
        return Client.builder()
                .id(1)
                .sharedKey("jgutierrez")
                .businessId("Juliana Gutierrez")
                .email("jgutierrez@gmail.com")
                .phone(3219876543L)
                .startDate(Dates.getCurrentDate())
                .endDate(Dates.getCurrentDate())
                .dateAdded(Dates.getCurrentDate())
                .build();
    }
}
