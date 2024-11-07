package ru.merion.aqa.lesson16.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.merion.aqa.lesson15.XClientsWebClient;
import ru.merion.aqa.lesson15.model.Company;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XClientsBusinesTest {

    private XClientsWebClient client;
    private String token;
    private int companyId;

    @BeforeEach
    public void setUp() throws IOException {
        client = new XClientsWebClient("https://x-clients-be.onrender.com");
        token = client.getToken("leonardo", "leads");
    }

    @AfterEach
    public  void tearDown() throws IOException {
        client.deleteById(companyId, token);
    }
    @Test
    public void shuldCreateCompany() throws IOException {
        // посмотреть, сколь было ДО
        int sizeBefore = client.getAll().size();
        // изменить
        companyId = client.create("DeleteMe","", token);

        // посмотреть сколько стало после
        int sizeAfter = client.getAll().size();

        assertEquals(sizeBefore+1, sizeAfter);

    }

    @Test
    public void shouldSetDefaultValues() throws IOException {
        String companyName = "DeleteMe";
        companyId = client.create(companyName,"", token);

        Company company = client.getById(companyId);

        assertEquals(companyId, company.id());
        assertTrue(company.isActive());
        assertTrue(company.description().isBlank());
        assertEquals(companyName, company.name());

    }

    @Test
    public void shouldSaveNameAndDescValues() throws IOException {
        String companyName = "DeleteMe";
        String desc = "please";

        companyId = client.create(companyName,desc, token);

        Company company = client.getById(companyId);

        assertEquals(companyId, company.id());
        assertTrue(company.isActive());
        assertEquals(desc, company.description());
        assertEquals(companyName, company.name());

    }

}
