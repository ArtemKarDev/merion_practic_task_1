package ru.merion.aqa.lesson15;

import okhttp3.*;
import ru.merion.aqa.lesson15.model.Company;


import java.io.IOException;
import java.util.List;


public class XClientDemo {
    public static final String URL = "https://x-clients-be.onrender.com";

    public static void main(String[] args) throws IOException {

        // авторизация
        XClientsWebClient service = new XClientsWebClient(URL);
        String token = service.getToken("leonardo", "leads");

        // создать новую компанию
        int newCompanyId = service.create("NewCompany2","test company 2", token);

        // получить список компаний
     //   List<Company> companyList = service.getAll();

        // получить созданную компанию
        Company company = service.getById(newCompanyId);

        //удалить созданную компанию
        Company companyDel = service.deleteById(newCompanyId, token);
        System.out.println("deleteResp " + companyDel);

    }


}
