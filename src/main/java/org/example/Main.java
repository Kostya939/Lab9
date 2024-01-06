package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final String API_KEY = "43a0cef4dd3b4c818a5328154582ef5d";

    public static void main(String[] args) throws IOException {
        ApiClient apiClient = new ApiClient(API_KEY);

        List<Customer> customers = apiClient.getCustomers();

        File file = new File("customers.xlsx");

        ExcelWriter excelExporter = new ExcelWriter();
        excelExporter.exportDataToExcel(customers, file);

        System.out.println("Дані успішно збережені у файл Excel");
    }
}

