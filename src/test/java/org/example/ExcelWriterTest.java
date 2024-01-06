package org.example;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExcelWriterTest {

    @Mock
    private ApiClient apiClient;

    @Test
    void testExportDataToExcel() throws IOException {
        ExcelWriter excelWriter = new ExcelWriter();

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "john.doe@example.com", "123-456-7890"));
        customers.add(new Customer(2, "Jane Doe", "jane.doe@example.com", "987-654-3210"));

        File file = new File("customers.xlsx");

        Mockito.when(apiClient.getCustomers()).thenReturn(customers);
        excelWriter.exportDataToExcel(customers, file);

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        assertEquals(2, rowCount);

        Row row = sheet.getRow(0);
        assertEquals(1, row.getCell(0).getNumericCellValue());
        assertEquals("John Doe", row.getCell(1).getStringCellValue());
        assertEquals("john.doe@example.com", row.getCell(2).getStringCellValue());
        assertEquals("123-456-7890", row.getCell(3).getStringCellValue());

        row = sheet.getRow(1);
        assertEquals(2, row.getCell(0).getNumericCellValue());
        assertEquals("Jane Doe", row.getCell(1).getStringCellValue());
        assertEquals("jane.doe@example.com", row.getCell(2).getStringCellValue());
        assertEquals("987-654-3210", row.getCell(3).getStringCellValue());
    }
}
