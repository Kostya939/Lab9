package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ProductExcelExporter {

    private static final String[] HEADERS = {"ID", "Title", "Price", "Description"};

    public static void exportProductsToExcel(List<Product> products, String filePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(filePath)) {
            Sheet sheet = createProductSheet(workbook);

            int rowNum = 1;
            for (Product product : products) {
                populateProductRow(sheet, product, rowNum++);
            }

            workbook.write(fileOut);
        }
    }

    private static Sheet createProductSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet("Products");
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < HEADERS.length; i++) {
            headerRow.createCell(i).setCellValue(HEADERS[i]);
        }
        return sheet;
    }

    private static void populateProductRow(Sheet sheet, Product product, int rowNum) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(product.getId());
        row.createCell(1).setCellValue(product.getTitle());
        row.createCell(2).setCellValue(product.getPrice());
        row.createCell(3).setCellValue(product.getDescription());
    }

    public static void main(String[] args) {
        try {
            List<Product> products = OnlineProductRetriever.fetchProducts();
            String filePath = "C:\\Users\\Public\\Documents\\products.xlsx";
            ProductExcelExporter.exportProductsToExcel(products, filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
