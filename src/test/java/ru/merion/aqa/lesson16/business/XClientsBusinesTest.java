package ru.merion.aqa.lesson16.business;

import org.junit.jupiter.api.Test;
import ru.merion.aqa.lesson15.XClientsWebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XClientsBusinesTest {
    @Test
    public void shuldCreateCompany() throws IOException {
        XClientsWebClient client = new XClientsWebClient("https://x-clients-be.onrender.com/company");
        // посмотреть, сколь было ДО
        int sizeBefore = client.getAll().size();
        // изменить
        String token = client.getToken("leonardo","leads");
        client.create("DeleteMe","", token);

        // посмотреть сколько стало после
        int sizeAfter = client.getAll().size();

        assertEquals(sizeBefore+1, sizeAfter);

    }
}
